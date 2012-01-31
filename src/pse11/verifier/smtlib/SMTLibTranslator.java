package verifier.smtlib;

import ast.*;

import java.util.*;

/**
 *
 */
public class SMTLibTranslator implements ASTVisitor {
    private ArrayList<LinkedList<S_Expression>> programs;
    private Stack<HashMap<VarDef, S_Expression>> upScopeReplacements;
    private Stack<S_Expression> upScopeExpr;
    private S_Expression tempExpr;
    private int currentProgram;
    private boolean change;

    public WPProgram getWPTree(ASTRoot ast) {
        programs = new ArrayList<LinkedList<S_Expression>>();
        ast.accept(this);
        LinkedList<S_Expression> result = prepareFinalProgram(programs);
        int size = result.size();
        return new WPProgram(result.toArray(new S_Expression[size]));
    }

    private static LinkedList<S_Expression> prepareFinalProgram(ArrayList<LinkedList<S_Expression>> programs) {
        ListIterator<LinkedList<S_Expression>> i = programs.listIterator();
        while(i.hasNext()) {
           createBlock(i.next());
        }
        i = programs.listIterator();
        ListIterator<S_Expression> j;
        LinkedList<S_Expression> result = new LinkedList<S_Expression>();
        while(i.hasNext()) {
            j = i.next().listIterator();
            while(j.hasNext()) {
                result.add(j.next());
            }
        }
        result.addFirst(new S_Expression("set-logic",
                new S_Expression[]{new Constant("AUFNIRA")}));
        return result;
    }
    
    private static void createBlock(LinkedList<S_Expression> program) {
        LinkedList<String> vars = program.getLast().getUndefinedVars();
        for (String var : vars) {
            program.addFirst(new S_Expression("declare-fun",
                    new S_Expression[]{new Constant(var)}));
        }
        program.addFirst(new Constant("(push)"));
        program.addLast(new Constant("(check-sat)"));
        program.addLast(new Constant("(get-model)"));
        program.addLast(new Constant("(pop)"));
    }
    
    private static void replaceInAssignments(Map<VarDef, S_Expression> map,
                                     VarDef varDef, S_Expression newExpr) {
        for (Map.Entry<VarDef, S_Expression> oldEntry : map.entrySet()) {
            oldEntry.getValue().replace(varDef,
                    newExpr.deepCopy());    
        }
        if (!map.containsKey(varDef)) {
            map.put(varDef, newExpr.deepCopy());
        }
    }

    public static String getTypeString(Type type) {
        return type instanceof IntegerType ? "Int" : "Bool";
        //TODO: Arrays
    }

    private void prepareEndedLoop(LinkedList<S_Expression> program) {
        while (upScopeReplacements.size() > 1) {
            S_Expression upperExpr = upScopeExpr.pop();
            HashMap<VarDef, S_Expression> replacements =
                    upScopeReplacements.pop();
            for (Map.Entry<VarDef, S_Expression> entry :
                    replacements.entrySet()) {
                upperExpr.replace(entry.getKey(), entry.getValue());
            }
            program.set(program.size() - 1, new S_Expression("and",
                    new S_Expression[]{upperExpr, program.getLast()}));
        }
    }

    //TODO: fill in stubs
    @Override
    public void visit(Conditional conditional) {
        upScopeExpr.push(tempExpr);
        Stack<S_Expression> tempExprStack = (Stack<S_Expression>) upScopeExpr.clone();
        Stack<HashMap<VarDef, S_Expression>> tempReplacements = upScopeReplacements;
        upScopeReplacements.push(new HashMap<VarDef, S_Expression>());
        conditional.getCondition().accept(this);
        S_Expression condition = tempExpr;
        tempExpr = new Constant("true");
        conditional.getTrueConditionBody().accept(this);
        HashMap<VarDef, S_Expression> replacements = upScopeReplacements.pop();
        Set<Map.Entry<VarDef, S_Expression>> entries = replacements.entrySet();
        tempExpr = upScopeExpr.lastElement().deepCopy();
        for (Map.Entry<VarDef, S_Expression> entry : entries) {
            tempExpr.replace(entry.getKey(), entry.getValue());
        }
        S_Expression trueBranch = new S_Expression("and",
                new S_Expression[]{condition.deepCopy(), tempExpr});
        upScopeExpr = tempExprStack;
        upScopeReplacements = tempReplacements;
        upScopeReplacements.push(new HashMap<VarDef, S_Expression>());
        tempExpr = new Constant("true");
        if (conditional.getFalseConditionBody() != null) {
            conditional.getFalseConditionBody().accept(this);
        }
        entries = upScopeReplacements.pop().entrySet();
        tempExpr = upScopeExpr.pop().deepCopy();
        for (Map.Entry<VarDef, S_Expression> entry : entries) {
            tempExpr.replace(entry.getKey(), entry.getValue());
            if (replacements.containsKey(entry.getKey())) {
                replaceInAssignments(upScopeReplacements.lastElement(),
                        entry.getKey(),
                        new S_Expression("ite", new S_Expression[]{
                                new S_Expression("not",
                                        new S_Expression[]{condition.deepCopy()}),
                                entry.getValue(),
                                replacements.get(entry.getKey())
                        }));
                replacements.remove(entry.getKey());
            } else {
                replaceInAssignments(upScopeReplacements.lastElement(),
                        entry.getKey(),
                        new S_Expression("ite", new S_Expression[]{
                                condition.deepCopy(),
                                entry.getKey().deepCopy(),
                                entry.getValue()
                        }));
            }
        }
        entries = replacements.entrySet();
        for (Map.Entry<VarDef, S_Expression> entry : entries) {
            replaceInAssignments(upScopeReplacements.lastElement(),
                    entry.getKey(),
                    new S_Expression("ite", new S_Expression[]{
                            condition.deepCopy(),
                            replacements.get(entry.getKey()),
                            entry.getKey().deepCopy()}));
        }
        S_Expression falseBranch = new S_Expression("and",
                new S_Expression[]{new S_Expression("not",
                        new S_Expression[]{condition}), tempExpr});
        tempExpr = new S_Expression("or",
                new S_Expression[]{trueBranch, falseBranch});
        change = true;
    }

    @Override
    public void visit(Loop loop) {
        Ensure[] ensures = loop.getPostconditions();
        int depth = upScopeReplacements.size();
        //ensures=>rest
        LinkedList<S_Expression> program = new LinkedList<S_Expression>();
        program.add(tempExpr);
        programs.add(program);
        for (Ensure ensure : ensures) {
            ensure.accept(this);
            program.set(program.size() - 1, new S_Expression("=>",
                    new S_Expression[]{tempExpr, program.getLast()}));
        }
        prepareEndedLoop(program);
        program.set(program.size() - 1, new S_Expression("assert",
                new S_Expression[]{new S_Expression("not",
                        new S_Expression[]{program.getLast()})}));
        //invariants & !condition => ensures
        program = new LinkedList<S_Expression>();
        programs.add(program);
        program.add(new Constant("true"));
        for (Ensure ensure : ensures) {
            ensure.accept(this);
            program.set(program.size() - 1, new S_Expression("and",
                    new S_Expression[]{tempExpr, program.getLast()}));
        }
        Invariant[] invariants = loop.getInvariants();
        for (Invariant invariant : invariants) {
            invariant.accept(this);
            program.set(program.size() - 1, new S_Expression("=>",
                    new S_Expression[]{tempExpr, program.getLast()}));
        }
        loop.getCondition().accept(this);
        program.set(program.size() - 1, new S_Expression("=>",
                new S_Expression[]{new S_Expression("not",
                        new S_Expression[]{tempExpr}), program.getLast()}));
        program.set(program.size() - 1, new S_Expression("assert",
                new S_Expression[]{ new S_Expression("not",
                            new S_Expression[]{program.getLast()})}));
        //invariants & condition => invariant
        upScopeReplacements = new Stack<HashMap<VarDef, S_Expression>>();
        upScopeExpr = new Stack<S_Expression>();
        for (int i = 0; i < depth; i++) {
            upScopeReplacements.add(new HashMap<VarDef, S_Expression>());
            upScopeExpr.add(new Constant("true"));
        }
        program = new LinkedList<S_Expression>();
        programs.add(program);
        program.add(new Constant("true"));
        for (Invariant invariant : invariants) {
            invariant.accept(this);
            program.set(program.size() - 1, new S_Expression("and",
                    new S_Expression[]{tempExpr, program.getLast()}));
        }
        tempExpr = program.getLast();
        loop.getLoopBody().accept(this);
        program.set(program.size() - 1, tempExpr);
        for (Invariant invariant : invariants) {
            invariant.accept(this);
            program.set(program.size() - 1, new S_Expression("=>",
                    new S_Expression[]{tempExpr, program.getLast()}));
        }
        loop.getCondition().accept(this);
        program.set(program.size() - 1, new S_Expression("=>",
                new S_Expression[]{tempExpr, program.getLast()}));
        program.set(program.size() - 1, new S_Expression("assert",
                new S_Expression[]{ new S_Expression("not",
                            new S_Expression[]{program.getLast()})}));
        //pre=>invariants
        upScopeReplacements = new Stack<HashMap<VarDef, S_Expression>>();
        upScopeExpr = new Stack<S_Expression>();
        for (int i = 0; i < depth; i++) {
            upScopeReplacements.add(new HashMap<VarDef, S_Expression>());
            upScopeExpr.add(new Constant("true"));
        }
        S_Expression saveTempExpr = new Constant("true");
        for (Invariant invariant : invariants) {
            invariant.accept(this);
            saveTempExpr = new S_Expression("and",
                    new S_Expression[]{tempExpr, saveTempExpr});
        }
        tempExpr = saveTempExpr;
        change = true;
    }

    @Override
    public void visit(ArrayAssignment arrayAssignment) {
    }

    @Override
    public void visit(ArithmeticExpression arithmeticExpression) {
        arithmeticExpression.getSubexpression1().accept(this);
        ArithmeticOperator operator =
                arithmeticExpression.getArithmeticOperator();
        int length = operator instanceof BinaryOperator ? 2 : 1;
        S_Expression[] expressions = new S_Expression[length];
        expressions[0] = tempExpr;
        String op = operator.toString();
        if (operator instanceof Division) {
            op = "div";
        } else if (operator instanceof Modulo) {
            op = "mod";
        }
        if (operator instanceof BinaryOperator) {
            arithmeticExpression.getSubexpression2().accept(this);
            expressions[1] = tempExpr;
        }
        tempExpr = new S_Expression(op, expressions);
    }

    @Override
    public void visit(NumericLiteral number) {
        tempExpr = new Constant(number.toString());
    }

    @Override
    public void visit(LogicalExpression logicalExpression) {
        logicalExpression.getSubexpression1().accept(this);
        LogicalOperator operator = logicalExpression.getLogicalOperator();
        int length = operator instanceof BinaryOperator ? 2 : 1;
        S_Expression[] expressions = new S_Expression[length];
        expressions[0] = tempExpr;
        String op = operator.toString();
        if (operator instanceof Negation) {
            op = "not";
        } else if (operator instanceof Conjunction) {
            op = "and";
        } else if (operator instanceof Disjunction) {
            op = "or";
        } else if (operator instanceof Equal) {
            op = "=";
        } else if (operator instanceof NotEqual) {
            op = "distinct";
        }
        if (operator instanceof BinaryOperator) {
            logicalExpression.getSubexpression2().accept(this);
            expressions[1] = tempExpr;
        }
        tempExpr = new S_Expression(op, expressions);
    }

    @Override
    public void visit(BooleanLiteral bool) {
        tempExpr = new Constant(bool.toString());
    }

    @Override
    public void visit(FunctionCall functionCall) {
    }

    @Override
    public void visit(VariableRead variableRead) {
        tempExpr = new VarDef(variableRead.toString(), variableRead.getType(),
                variableRead.getDepth());
    }

    @Override
    public void visit(ArrayRead arrayRead) {
    }

    @Override
    public void visit(Function function) {
        upScopeReplacements = new Stack<HashMap<VarDef, S_Expression>>();
        upScopeReplacements.push(new HashMap<VarDef, S_Expression>());
        upScopeExpr = new Stack<S_Expression>();
        S_Expression saveTempExpression = new Constant("true");
        Ensure[] ensures = function.getEnsures();
        for (Ensure ensure : ensures) {
            ensure.accept(this);
            saveTempExpression = new S_Expression("and",
                            new S_Expression[]{tempExpr, saveTempExpression});
        }
        tempExpr = saveTempExpression;
        function.getFunctionBlock().accept(this);
        LinkedList<S_Expression> program = new LinkedList<S_Expression>();
        program.add(tempExpr);
        programs.add(program);
        program.set(program.size() - 1, tempExpr);
        Assumption[] assumptions = function.getAssumptions();
        for (Assumption assumption : assumptions) {
            assumption.accept(this);
            program.set(program.size() - 1, new S_Expression("=>",
                    new S_Expression[]{tempExpr, program.getLast()}));
        }
        program.set(program.size() - 1, new S_Expression("assert",
                new S_Expression[]{ new S_Expression("not",
                            new S_Expression[]{program.getLast()})}));
        /*FunctionParameter[] parameters = function.getParameters();
        for (FunctionParameter parameter : parameters) {
            //TODO: check for arrays
            String type = parameter.getType() instanceof BooleanType
                    ? "Bool" : "Int";
            program.addFirst(new S_Expression("declare-fun",
                    new S_Expression[]{new Constant(parameter.getName()),
                        new Constant("()"), new Constant(type)}));
        }*/
    }

    @Override
    public void visit(Program program) {
        program.getMainFunction().accept(this);
    }

    @Override
    public void visit(Assignment assignment) {
        S_Expression expression = tempExpr;
        assignment.getValue().accept(this);
        VarDef varDef = new VarDef(assignment.getIdentifier().toString(),
                assignment.getType(), assignment.getDepth());
        expression.replace(varDef, tempExpr);
        replaceInAssignments(upScopeReplacements.lastElement(), varDef, tempExpr);
    }

    @Override
    public void visit(Assertion assertion) {
        //TODO: insert in statements
        assertion.getExpression().accept(this);
    }

    @Override
    public void visit(Assumption assumption) {
        assumption.getExpression().accept(this);
    }

    @Override
    public void visit(Axiom axiom) {
        //TODO
    }

    @Override
    public void visit(Ensure ensure) {
        ensure.getExpression().accept(this);
    }

    @Override
    public void visit(Invariant invariant) {
        invariant.getExpression().accept(this);
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
    }

    @Override
    public void visit(VariableDeclaration varDec) {
        S_Expression expression = tempExpr;
        if (varDec.getValue() != null) {
            varDec.getValue().accept(this);
        } else {
            if (varDec.getType() instanceof BooleanType) {
                tempExpr = new Constant("true");
            } else {
                tempExpr = new Constant("0");
            }
        }
        VarDef varDef = new VarDef(varDec.getName(), varDec.getType(), 0);
        expression.replace(varDef, tempExpr);
        replaceInAssignments(upScopeReplacements.lastElement(),
                varDef, tempExpr);
        upScopeReplacements.lastElement().remove(varDef);
    }

    @Override
    public void visit(ArrayDeclaration arrDec) {
    }

    @Override
    public void visit(ExistsQuantifier existsQuantifier) {
        existsQuantifier.getSubexpression1().accept(this);
        tempExpr = new S_Expression("exists", new S_Expression[] {
            new VarDef(existsQuantifier.getIdentifier().getName(), new IntegerType(), 0), tempExpr});
    }

    @Override
    public void visit(ForAllQuantifier forAllQuantifier) {
        forAllQuantifier.getSubexpression1().accept(this);
        tempExpr = new S_Expression("forall", new S_Expression[] {
            new VarDef(forAllQuantifier.getIdentifier().getName(), new IntegerType(), 0), tempExpr});
    }

    @Override
    public void visit(StatementBlock statementBlock) {
        int saveCurrentProgram = currentProgram;
        S_Expression expression = tempExpr;
        Statement[] statements = statementBlock.getStatements();
        for (int i = statements.length - 1; i >= 0; i--) {
            change = false;
            statements[i].accept(this);
            if (change) {
                expression = tempExpr;
            }
            tempExpr = expression;
            currentProgram = saveCurrentProgram;
        }
    }
}
