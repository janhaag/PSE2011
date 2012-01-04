package parser;

import ast.*;
import interpreter.ASTVisitor;
import interpreter.Scope;
import interpreter.Value;

import java.util.HashMap;

/**
 * This class checks the type correctness of a user program.
 */
public class TypeChecker implements ASTVisitor {
    private Type currentReturnType;
    private Type tempType;
    private Scope currentScope;
    
    public void checkTypes(ASTRoot ast) {
        ast.accept(this);
    }
    
    public void visit(Conditional conditional) {
        conditional.getCondition().accept(this);
        currentScope = new Scope(currentScope,
                                 conditional.getTrueConditionBody(), false);
        conditional.getTrueConditionBody().accept(this);
        currentScope = currentScope.getParent();
        currentScope = new Scope(currentScope,
                                 conditional.getFalseConditionBody(), false);
        conditional.getFalseConditionBody().accept(this);
        currentScope = currentScope.getParent();
    }

    public void visit(Loop loop) {
        loop.getCondition().accept(this);
        Invariant[] invariants = loop.getInvariants();
        for (Invariant invariant : invariants) {
            invariant.accept(this);
        }
        currentScope = new Scope(currentScope, loop.getLoopBody(), false);
        loop.getLoopBody().accept(this);
        currentScope = currentScope.getParent();
    }
    
    public void visit(ArrayAssignment arrayAssignment) {
        HashMap<Identifier, Value> vars = currentScope.getVariables();
        Identifier identifier = arrayAssignment.getIdentifier();
        Value value = vars.get(identifier);
        ArithmeticExpression[] indexes = arrayAssignment.getIndexes();
        for (ArithmeticExpression index : indexes) {
            index.accept(this);
        }
        arrayAssignment.getValue().accept(this);
        Type type = baseType(value.getType(), indexes.length,
                     arrayAssignment.getPosition());
        if (type instanceof ArrayType) {
            throw new IllegalTypeException("Cannot assign a value to an array "
                                           + "that is not fully indexed!",
                                            arrayAssignment.getPosition());        
        }
        if (!type.equals(tempType)) {
            throw new IllegalTypeException("Base type of the array does not "
                                           + "match the type of assigned value",
                                           arrayAssignment.getPosition());
        }
    }

    public void visit(ArithmeticExpression arithmeticExpression) {
        arithmeticExpression.getSubexpression1().accept(this);
        ArithmeticOperator operator =
                arithmeticExpression.getArithmeticOperator();
        if (operator.isBinary()) {
            Type tempType1 = tempType;
            arithmeticExpression.getSubexpression2().accept(this);
            if (!(tempType instanceof IntegerType)
               || !(tempType1 instanceof IntegerType)) {
                throw new IllegalTypeException("Operands must be arithmetic "
                                               + "expressions!",
                                            arithmeticExpression.getPosition());
            }
        } else {
            //UnaryMinus
            if (!(tempType instanceof BooleanType)) {
                throw new
                  IllegalTypeException("Operand must be a logical expression!",
                                       arithmeticExpression.getPosition());
            }
        }
        tempType = new IntegerType();
    }

    public void visit(NumericLiteral number) {
        tempType = new IntegerType();
    }

    public void visit(LogicalExpression logicalExpression) {
        Position position = logicalExpression.getPosition();
        logicalExpression.getSubexpression1().accept(this);
        LogicalOperator operator = logicalExpression.getLogicalOperator();
        if (operator.isBinary()) {
            Type tempType1 = tempType;
            logicalExpression.getSubexpression2().accept(this);
            if (operator instanceof Conjunction
                    || operator instanceof Disjunction) {
                if (!(tempType instanceof IntegerType)
                        || !(tempType1 instanceof IntegerType)) {
                    throw new IllegalTypeException("Operands must be "
                                                    + "integer expressions!",
                                                    position);
                }
            } else if (operator instanceof Equal
                       || operator instanceof NotEqual) {
                if (!tempType.equals(tempType1)) {
                    throw new IllegalTypeException("Operands must be of "
                                                    + "equal types!",
                                                    position);
                }
            } else {
                //greater, greater equal, less, less equal
                if(!(tempType instanceof IntegerType)
                        || !(tempType1 instanceof IntegerType)) {
                    throw new IllegalTypeException("Operands must be "
                                                   + "integer expressions!",
                                                    position);
                }
            }
        } else {
            //Negation
            if (!(tempType instanceof BooleanType)) {
                throw new
                  IllegalTypeException("Operand must be a logical expression!",
                                       position);
            }
        }
        tempType = new BooleanType();
    }

    public void visit(BooleanLiteral bool) {
        tempType = new BooleanType();
    }

    public void visit(FunctionCall functionCall) {
        //TODO
    }

    public void visit(VariableRead variableRead) {
        HashMap<Identifier, Value> vars = currentScope.getVariables();
        Identifier identifier = variableRead.getVariable();
        Value value = vars.get(identifier);
        if (value == null) {
            throw new IllegalTypeException("Variable " + identifier.getName()
                                           + " was read but not declared!",
                                           variableRead.getPosition());
        }
        tempType = value.getType();
    }

    public void visit(ArrayRead arrayRead) {
        HashMap<Identifier, Value> vars = currentScope.getVariables();
        Identifier identifier = arrayRead.getVariable();
        Value value = vars.get(identifier);
        if (value == null) {
            throw new IllegalTypeException("Variable " + identifier.getName()
                                           + " was read but not declared!",
                                           arrayRead.getPosition());
        }
        ArithmeticExpression[] indexes = arrayRead.getIndexes();
        for (ArithmeticExpression index : indexes) {
            index.accept(this);
        }
        tempType =
             baseType(value.getType(), indexes.length, arrayRead.getPosition());
    }

    public void visit(Function function) {
        currentReturnType = function.getReturnType();
        currentScope = new Scope(null, function.getFunctionBlock(), true);
        if (currentReturnType instanceof ArrayType) {
            throw new IllegalTypeException("Functions must not return arrays.",
                                           function.getPosition());
        }
        Assumption[] assumptions = function.getAssumptions();
        for (Assumption assumption : assumptions) {
            assumption.accept(this);
        }
        Ensure[] ensures = function.getEnsures();
        for (Ensure ensure : ensures) {
            ensure.accept(this);
        }
        function.getFunctionBlock().accept(this);
    }

    public void visit(Program program) {
        Function[] functions = program.getFunctions();
        for (Function function : functions) {
            function.accept(this);
        }
        program.getMainFunction().accept(this);
    }

    public void visit(Assignment assignment) {
        assignment.getValue().accept(this);
        HashMap<Identifier, Value> vars = currentScope.getVariables();
        Identifier identifier = assignment.getIdentifier();
        Value value = vars.get(identifier);
        if (value.getType() instanceof ArrayType) {
            throw new IllegalTypeException("Cannot assign a value to an array "
                                           + "that is not fully indexed!",
                                           assignment.getPosition());
        }
        if (!value.getType().equals(tempType)) {
            throw new IllegalTypeException("Type of variable does not "
                                           + "match the type of assigned value",
                                           assignment.getPosition());
        }
    }

    public void visit(Assertion assertion) {
        assertion.getExpression().accept(this);
    }

    public void visit(Assumption assumption) {
        assumption.getExpression().accept(this);
    }

    public void visit(Axiom axiom) {
        axiom.getExpression().accept(this);
    }

    public void visit(Ensure ensure) {
        ensure.getExpression().accept(this);
    }

    public void visit(Invariant invariant) {
        invariant.getExpression().accept(this);
    }

    public void visit(ReturnStatement returnStatement) {
        if (currentReturnType == null) {
            throw new IllegalTypeException("Main must not have a "
                           + "return statement", returnStatement.getPosition());
        }
        returnStatement.getReturnValue().accept(this);
        if (!currentReturnType.equals(tempType)) {
            throw new IllegalTypeException("Type of returned expression does "
                                + "not match type that the function returns!",
                                returnStatement.getPosition());
        }
    }

    public void visit(VariableDeclaration varDec) {
        currentScope.createVar(varDec.getName(), null, varDec.getType());
        varDec.getValue().accept(this);
        if (!varDec.getType().equals(tempType)) {
            throw new IllegalTypeException("Type of variable does not match "
                                           + "the type of initialized value",
                                           varDec.getPosition());
        }
    }

    public void visit(ArrayDeclaration arrDec) {
        ArithmeticExpression[] indexes = arrDec.getIndexes();
        for (ArithmeticExpression index : indexes) {
            index.accept(this);
        }
        int[] lengths = new int[indexes.length];
        for (int i = 0; i < lengths.length; i++) {
            lengths[i] = 1;
        }
        currentScope.createArray(arrDec.getName(), arrDec.getType(), lengths);
    }

    public void visit(ExistsQuantifier existsQuantifier) {
        currentScope = new Scope(currentScope, null, false);
        if (existsQuantifier.getExpression() != null) {

        } else {
            //existsQuantifier.getSubexpression() != null
        }
        //TODO
    }

    public void visit(ForAllQuantifier forAllQuantifier) {
        //TODO
    }

    public void visit(StatementBlock statementBlock) {
        Statement currentStatement = statementBlock.getNextStatement();
        while (currentStatement != null) {
            currentStatement.accept(this);
            currentStatement = statementBlock.getNextStatement();
        }
    }

    public void visit(Length length) {
        length.getArray().accept(this);
        if (!(tempType instanceof ArrayType)) {
            throw new IllegalTypeException("Parameter of 'length' must be an "
                                           + "array!", length.getPosition());
        }
        tempType = new IntegerType();
    }

    /**
     * Returns the type of the array in the specified depth.
     * For example, if i has type t, then baseType(t, 1, ...) returns the
     * type of i[], baseType(t, 2, ...) the type of i[][], ...
     * 
     * An IllegalTypeException if thrown if the deconstruction of
     * the type goes too far and there is no array left.
     * 
     * @param arrayType the original array type
     * @param depth specified depth
     * @param position position for the IllegalTypeException
     * @return type of the array in the specified depth
     */
    private static Type baseType(Type arrayType, int depth, Position position) {
        Type type = arrayType;
        for (int i = 0; i < depth; i++) {
            if (!(type instanceof ArrayType)) {
                throw new IllegalTypeException("Variable was indexed although "
                                                + "not an array!", position);
            }
            type = ((ArrayType) type).getType();    
        }
        return type;
    }
}
