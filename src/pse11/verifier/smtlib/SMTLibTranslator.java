package verifier.smtlib;

import ast.*;
import misc.Pair;
import verifier.KindOfProgram;

import java.util.*;

/**
 * This class translates a program given as AST into the smtlib format that can
 * be given to certain verifiers.
 */
public class SMTLibTranslator implements ASTVisitor {
    /**
     * list of descriptions for the programs
     */
    private LinkedList<Pair<KindOfProgram, Position>> descriptions;
    /**
     * temporarily saves the list of all programs,
     * i.e. a list of all contracts to be verified
     */
    private ArrayList<LinkedList<S_Expression>> programs;
    /**
     * Keeps track of all arrays that need to be defined.
     */
    private static LinkedList<S_Expression> arrays;
    /**
     * temporarily saves the current expression
     */
    private S_Expression tempExpr;
    /**
     * temporarily saves the number of the current program
     */
    private S_Expression currentProgram;
    private LinkedList<S_Expression> functionAssumes = new LinkedList<S_Expression>();

    /**
     * Translates the given AST into a formula
     * and returns a WPProgram that contains all contracts to be verified.
     *
     * @param ast given AST
     * @return WPProgram of all contracts to be verified
     */
    public WPProgram getWPTree(ASTRoot ast) {
        programs = new ArrayList<LinkedList<S_Expression>>();
        descriptions = new LinkedList<Pair<KindOfProgram, Position>>();
        arrays = new LinkedList<S_Expression>();
        ast.accept(this);
        LinkedList<S_Expression> result = prepareFinalProgram(programs);
        int size = result.size();
        return new WPProgram(result.toArray(new S_Expression[size]));
    }

    /**
     * Returns a list of program descriptions.
     * @return list of program descriptions
     */
    public LinkedList<Pair<KindOfProgram, Position>> getDescriptions() {
        return descriptions;
    }

    /**
     * Prepares the final program after the most translations.
     * @param programs programs to be prepared to form the final program
     * @return final program
     */
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
        for (S_Expression array : arrays) result.addFirst(array);
        result.addFirst(new S_Expression("set-logic",
                new Constant("AUFNIRA")));
        return result;
    }

    /**
     * Creates a block, i.e. a single contract to be verified.
     * @param program program to be formed to the final block
     */
    private static void createBlock(LinkedList<S_Expression> program) {
        LinkedList<VarDef> vars = program.getLast().getUndefinedVars();
        for (VarDef var : vars) {
            program.addFirst(new S_Expression("declare-fun",
                    new Constant(var.getFullRepresentation())));
        }
        program.addFirst(new Constant("(push)"));
        program.addLast(new Constant("(check-sat)"));
        program.addLast(new Constant("(get-model)"));
        program.addLast(new Constant("(pop)"));
    }

    /**
     * Returns the string representation of the given type
     * @param type given type
     * @return string representation of the given type
     */
    public static String getTypeString(Type type) {
        if (type instanceof IntegerType) return "Int";
        else if (type instanceof BooleanType) return "Bool";
        else {
            Type t = type;
            StringBuilder result = new StringBuilder().append("(");
            int n = 0;
            while (t instanceof ArrayType) {
                t = ((ArrayType) t).getType();
                result.append("(p").append(n).append(' ').append("Int)");
                n += 1;
            }
            result.append(")").append(getTypeString(t));
            return result.toString();
        }
    }

    @Override
    public void visit(Conditional conditional) {
        S_Expression saveProgram = currentProgram;
        conditional.getCondition().accept(this);
        S_Expression condition = tempExpr;
        currentProgram = saveProgram.deepCopy();
        conditional.getTrueConditionBody().accept(this);
        S_Expression trueBranch = new S_Expression("and",
                condition.deepCopy(), currentProgram);
        currentProgram = saveProgram.deepCopy();
        if (conditional.getFalseConditionBody() != null) {
            conditional.getFalseConditionBody().accept(this);
        }
        S_Expression falseBranch = new S_Expression("and",
                new S_Expression("not",
                        condition), currentProgram);
        currentProgram = new S_Expression("or",
                trueBranch, falseBranch);
    }

    @Override
    public void visit(Loop loop) {
        Ensure[] ensures = loop.getPostconditions();
        //ensures=>rest
        LinkedList<S_Expression> program = new LinkedList<S_Expression>();
        program.add(currentProgram);
        programs.add(program);
        descriptions.add(new Pair<KindOfProgram, Position>(
                KindOfProgram.WhileEnsureToRemainingProgram, loop.getPosition()));
        for (Ensure ensure : ensures) {
            ensure.accept(this);
            program.set(program.size() - 1, new S_Expression("=>",
                    tempExpr, program.getLast()));
        }
        program.set(program.size() - 1, new S_Expression("assert",
                new S_Expression("not",
                        program.getLast())));
        //invariants & !condition => ensures
        program = new LinkedList<S_Expression>();
        programs.add(program);
        descriptions.add(new Pair<KindOfProgram, Position>(
                KindOfProgram.InvariantAndNotConditionToWhileEnsure, loop.getPosition()));
        program.add(new Constant("true"));
        for (Ensure ensure : ensures) {
            ensure.accept(this);
            program.set(program.size() - 1, new S_Expression("and",
                    tempExpr, program.getLast()));
        }
        Invariant[] invariants = loop.getInvariants();
        for (Invariant invariant : invariants) {
            invariant.accept(this);
            program.set(program.size() - 1, new S_Expression("=>",
                    tempExpr, program.getLast()));
        }
        functionAssumes = new LinkedList<S_Expression>();
        loop.getCondition().accept(this);
        program.set(program.size() - 1, new S_Expression("=>",
                new S_Expression("not",
                        tempExpr), program.getLast()));
        program.set(program.size() - 1, new S_Expression("assert",
                new S_Expression("not",
                        program.getLast())));
        //invariants & condition => invariant
        currentProgram = new Constant("true");
        for (Invariant invariant : invariants) {
            invariant.accept(this);
            currentProgram =  new S_Expression("and", tempExpr, currentProgram);
        }
        for (S_Expression assume : functionAssumes) {
            currentProgram = new S_Expression("and", assume, currentProgram);
        }
        loop.getLoopBody().accept(this);
        program = new LinkedList<S_Expression>();
        programs.add(program);
        descriptions.add(new Pair<KindOfProgram, Position>(
                KindOfProgram.InvariantAndConditionToInvariant, loop.getPosition()));
        program.add(currentProgram);
        for (Invariant invariant : invariants) {
            invariant.accept(this);
            program.set(program.size() - 1, new S_Expression("=>",
                    tempExpr, program.getLast()));
        }
        functionAssumes = new LinkedList<S_Expression>();
        loop.getCondition().accept(this);
        program.set(program.size() - 1, new S_Expression("=>",
                tempExpr, program.getLast()));
        program.set(program.size() - 1, new S_Expression("assert",
                new S_Expression("not",
                        program.getLast())));
        //pre=>invariants
        currentProgram = new Constant("true");
        for (Invariant invariant : invariants) {
            invariant.accept(this);
            currentProgram = new S_Expression("and",
                    tempExpr, currentProgram);
        }
    }

    @Override
    public void visit(ArrayAssignment arrayAssignment) {
        arrayAssignment.getValue().accept(this);
        String name = arrayAssignment.getIdentifier().getName();
        int depth = arrayAssignment.getDepth();
        VarDef var = arrayVar(arrayAssignment.getPosition(), name, arrayAssignment.getType(), depth);
        String variable = var.toString() + " " + getTypeString(arrayAssignment.getType());
        Expression[] indices = arrayAssignment.getIndices();
        S_Expression[] idx = new S_Expression[indices.length + 1];
        S_Expression[] checks = new S_Expression[indices.length];
        idx[0] = new VarDef(arrayAssignment.getIdentifier().getName(), arrayAssignment.getType(),
                    arrayAssignment.getDepth());
        for (int i = 0; i < indices.length; i++) {
            indices[i].accept(this);
            idx[i + 1] = new Constant("p" + i);
            checks[i] = new S_Expression("=", new Constant("p" + i), tempExpr);
        }
        arrayAssignment.getValue().accept(this);
        VarDef varDef = new VarDef(arrayAssignment.getIdentifier().getName(),
                arrayAssignment.getType(), arrayAssignment.getDepth());
        currentProgram.replace(varDef, new Constant(var.toString()));
        for (S_Expression fun : arrays) fun.replace(varDef, new Constant(var.toString()));
        S_Expression defun = new S_Expression("define-fun", new Constant(variable),
                   new S_Expression("ite", new S_Expression("and", checks),
                       tempExpr, new S_Expression("", idx)));
        arrays.add(defun);
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
        if ("length".equals(functionCall.getFunctionIdentifier().getName())) {
            StringBuilder name = new StringBuilder("$length$");
            if (functionCall.getParameters()[0] instanceof ArrayRead) {
                ArrayRead param = (ArrayRead) functionCall.getParameters()[0];
                name.append(param.getVariable().getName()).append("$");
                Expression[] indices = param.getIndices();
                for (int i = 0; i < indices.length; i++) {
                    name.append('*');
                }
                tempExpr = new VarDef(name.toString(), new IntegerType(), 0);
            } else {
                VariableRead param = (VariableRead) functionCall.getParameters()[0];
                name.append(param.getVariable().getName()).append("$");
                tempExpr = new VarDef(name.toString(), new IntegerType(), 0);
            }
            return;
        }
        Position position = functionCall.getPosition();
        Function function = functionCall.getFunction();
        for (Ensure ensure : function.getEnsures()) {
            ensure.accept(this);
            replaceInFunctionResult(position, function);
            currentProgram = new S_Expression("=>", tempExpr, currentProgram);
        }
        for (Assumption assume : function.getAssumptions()) {
            assume.accept(this);
            replaceInFunctionAssume();
            functionAssumes.add(tempExpr);
        }
        for (int i = 0; i < function.getParameters().length; i++) {
            functionCall.getParameters()[i].accept(this);
            FunctionParameter param = function.getParameters()[i];
            VarDef varDef = new VarDef("$param$" + param.getName(), param.getType(), 0);
            for (int j = 0; j < functionAssumes.size(); j++) {
                S_Expression assume = functionAssumes.get(j);
                assume.replace(varDef, tempExpr);
                if (assume.equals(varDef)) {
                    functionAssumes.set(j, tempExpr);
                }
            }
        }
        Statement[] statements = function.getFunctionBlock().getStatements();
        (statements[statements.length - 1]).accept(this);
        replaceInFunctionResult(position, function);
    }

    private void replaceInFunctionResult(Position position, Function function) {
        for (VarDef varDef : tempExpr.getUndefinedVars()) {
            String newName = "res<" + function.getName() + ">@L" + position.getLine()
                    + 'C' + position.getColumn() + '$' + varDef.getIdent();
            VarDef newVar = new VarDef(newName, varDef.getType(), 0);
            tempExpr.replace(varDef, newVar);
            if (tempExpr.equals(varDef)) {
                tempExpr = newVar;
            }
        }
    }

    private void replaceInFunctionAssume() {
        for (VarDef varDef : tempExpr.getUndefinedVars()) {
            String newName = "$param$" + varDef.getIdent();
            VarDef newVar = new VarDef(newName, varDef.getType(), 0);
            tempExpr.replace(varDef, newVar);
            if (tempExpr.equals(varDef)) {
                tempExpr = newVar;
            }
        }
    }

    @Override
    public void visit(VariableRead variableRead) {
        String variableName = variableRead.toString();
        tempExpr = new VarDef(variableName, variableRead.getType(),
                variableRead.getDepth());
    }

    @Override
    public void visit(ArrayRead arrayRead) {
        Expression[] indices = arrayRead.getIndices();
        S_Expression[] idx = new S_Expression[indices.length + 1];
        idx[0] = new VarDef(arrayRead.getVariable().getName(), arrayRead.getType(),
                    arrayRead.getDepth());
        for (int i = 0; i < indices.length; i++) {
            indices[i].accept(this);
            idx[i + 1] = tempExpr;
        }
        tempExpr = new S_Expression("", idx);
    }

    @Override
    public void visit(Function function) {
        currentProgram = new Constant("true");
        Ensure[] ensures = function.getEnsures();
        for (Ensure ensure : ensures) {
            ensure.accept(this);
            currentProgram = new S_Expression("and",
                    tempExpr, currentProgram);
        }
        function.getFunctionBlock().accept(this);
        LinkedList<S_Expression> program = new LinkedList<S_Expression>();
        program.add(currentProgram);
        programs.add(program);
        descriptions.add(new Pair<KindOfProgram, Position>(
                KindOfProgram.FunctionAssumeToRemainingProgram, function.getPosition()));
        Assumption[] assumptions = function.getAssumptions();
        for (Assumption assumption : assumptions) {
            assumption.accept(this);
            program.set(program.size() - 1, new S_Expression("=>",
                    tempExpr, program.getLast()));
        }
        program.set(program.size() - 1, new S_Expression("assert",
                new S_Expression("not",
                        program.getLast())));
    }

    @Override
    public void visit(Program program) {
        Function[] functions = program.getFunctions();
        for (Function function : functions) {
            function.accept(this);
        }
        program.getMainFunction().accept(this);
    }

    @Override
    public void visit(Assignment assignment) {
        assignment.getValue().accept(this);
        VarDef varDef = new VarDef(assignment.getIdentifier().toString(),
                assignment.getType(), assignment.getDepth());
        currentProgram.replace(varDef, tempExpr);
    }

    @Override
    public void visit(Assertion assertion) {
        assertion.getExpression().accept(this);
        currentProgram = new S_Expression("and", tempExpr, currentProgram);
    }

    @Override
    public void visit(Assumption assumption) {
        assumption.getExpression().accept(this);
    }

    @Override
    public void visit(Axiom axiom) {
        axiom.getExpression().accept(this);
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
        returnStatement.getReturnValue().accept(this);
    }

    @Override
    public void visit(VariableDeclaration varDec) {
        if (varDec.getValue() != null) {
            varDec.getValue().accept(this);
        } else {
            if (varDec.getType() instanceof BooleanType) {
                tempExpr = new Constant("false");
            } else {
                tempExpr = new Constant("0");
            }
        }
        VarDef varDef = new VarDef(varDec.getName(), varDec.getType(), varDec.getDepth());
        currentProgram.replace(varDef, tempExpr);
    }

    @Override
    public void visit(ArrayDeclaration arrDec) {
        String name = arrDec.getName();
        int depth = arrDec.getDepth();
        VarDef var = arrayVar(arrDec.getPosition(), name, arrDec.getType(), depth);
        String variable = var.toString() + " " + getTypeString(arrDec.getType());
        arrays.add(new S_Expression("define-fun", new Constant(variable), new Constant("0")));
        tempExpr = new Constant(var.toString());
        VarDef varDef = new VarDef(arrDec.getName(), arrDec.getType(), arrDec.getDepth());
        for (S_Expression fun : arrays) fun.replace(varDef, tempExpr);
        currentProgram.replace(varDef, tempExpr);
        StringBuilder lname = new StringBuilder("$length$").append(name).append('$');
        for (Expression idx : arrDec.getIndices()) {
            idx.accept(this);
            varDef = new VarDef(lname.toString(), new IntegerType(), 0);
            currentProgram.replace(varDef, tempExpr);
            lname.append('*');
        }
    }

    @Override
    public void visit(ExistsQuantifier existsQuantifier) {
        existsQuantifier.getSubexpression1().accept(this);
        String name = existsQuantifier.getIdentifier().toString();
        int depth = existsQuantifier.getDepth();
        VarDef var = quantifierVar(existsQuantifier.getPosition(), name, depth);
        String variable = "((" + var.toString() + " Int))";
        S_Expression saveTempExpr = tempExpr;
        Range range = existsQuantifier.getRange();
        if (range != null) {
            range.getLowerBound().accept(this);
            saveTempExpr = new S_Expression("and", new S_Expression(
                    ">=", new VarDef(name, new IntegerType(), depth), tempExpr
            ), saveTempExpr);
            range.getUpperBound().accept(this);
            saveTempExpr = new S_Expression("and", new S_Expression(
                    "<=", new VarDef(name, new IntegerType(), depth), tempExpr
            ), saveTempExpr);
        }
        saveTempExpr.replace(new VarDef(name, new IntegerType(), depth), var);
        tempExpr = new S_Expression("exists", new Constant(variable), saveTempExpr);
    }

    @Override
    public void visit(ForAllQuantifier forAllQuantifier) {
        forAllQuantifier.getSubexpression1().accept(this);
        String name = forAllQuantifier.getIdentifier().toString();
        int depth = forAllQuantifier.getDepth();
        VarDef var = quantifierVar(forAllQuantifier.getPosition(), name, depth);
        String variable = "((" + var.toString() + " Int))";
        S_Expression saveTempExpr = tempExpr;
        Range range = forAllQuantifier.getRange();
        if (range != null) {
            range.getLowerBound().accept(this);
            saveTempExpr = new S_Expression("or", new S_Expression(
                    "<", new VarDef(name, new IntegerType(), depth), tempExpr
            ), saveTempExpr);
            range.getUpperBound().accept(this);
            saveTempExpr = new S_Expression("or", new S_Expression(
                    ">", new VarDef(name, new IntegerType(), depth), tempExpr
            ), saveTempExpr);
        }
        saveTempExpr.replace(new VarDef(name, new IntegerType(), depth), var);
        tempExpr = new S_Expression("forall", new Constant(variable), saveTempExpr);
    }

    private static VarDef quantifierVar(Position position, String name, int depth) {
        String varDefName = "qvar<" + name + ">@L" + position.getLine()
                    + 'C' + position.getColumn();
        return new VarDef(varDefName, new IntegerType(), depth);
    }

    @Override
    public void visit(StatementBlock statementBlock) {
        Statement[] statements = statementBlock.getStatements();
        for (int i = statements.length - 1; i >= 0; i--) {
            functionAssumes = new LinkedList<S_Expression>();
            statements[i].accept(this);
            for (S_Expression assume : functionAssumes) {
                currentProgram = new S_Expression("and", assume, currentProgram);
            }
        }
    }

    private VarDef arrayVar(Position position, String name, Type t, int depth) {
        String varDefName = "$array@" + 'l' + position.getLine()
                    + 'c' + position.getColumn() + '$' + name;
        return new VarDef(varDefName, t, depth);
    }
}
