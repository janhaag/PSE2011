package interpreter;

import ast.*;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 */
public class Interpreter implements ast.ASTVisitor {
    private Value tempValue;
    private State currentState;
    private Value returnValue;
    private Value[] parameters;
    
    private static class StopStatementException extends RuntimeException {
    }
    
    public State step(State state) {
        currentState = state;
        try {
            state.getCurrentStatement().accept(this);
        } catch (StopStatementException ignored) {
            //nothing to do
        }
        return state;
    }

    @Override
    public void visit(Conditional conditional) {
        conditional.getCondition().accept(this);
        if (((BooleanValue) tempValue).getValue()) {
            currentState.createScope(conditional.getTrueConditionBody(),
                    null);
        } else if (conditional.getFalseConditionBody() != null) {
            currentState.createScope(conditional.getFalseConditionBody(),
                    null);
        }
        adjustStatement();
    }

    @Override
    public void visit(Loop loop) {
        loop.getCondition().accept(this);
        boolean condition = ((BooleanValue) tempValue).getValue();
        if (condition) {
            currentState.createScope(loop.getLoopBody(),
                                     null);
            adjustStatement();
        }
        Invariant[] invariants = loop.getInvariants();
        for (Invariant invariant : invariants) {
            invariant.accept(this);
        }
        if (!condition) {
            Ensure[] ensures = loop.getPostconditions();
            for (Ensure ensure : ensures) {
                ensure.accept(this);
            }
            adjustStatement();
        }
    }

    @Override
    public void visit(ArrayAssignment arrayAssignment) {
        Expression[] indexes = arrayAssignment.getIndexes();
        ArrayList<Integer> lengths = new ArrayList<Integer>();
        for (Expression index : indexes) {
            index.accept(this);
            int pos = ((IntegerValue) tempValue).getValue().intValue();
            lengths.add(pos);
        }
        arrayAssignment.getValue().accept(this);
        currentState.setArray(arrayAssignment.getIdentifier().toString(),
                              tempValue.toString(), lengths);
        adjustStatement();
    }

    @Override
    public void visit(ArithmeticExpression arithmeticExpression) {
        arithmeticExpression.getSubexpression1().accept(this);
        ArithmeticOperator operator =
                arithmeticExpression.getArithmeticOperator();
        if (operator instanceof BinaryOperator) {
            BigInteger value1 = ((IntegerValue) tempValue).getValue();
            arithmeticExpression.getSubexpression2().accept(this);
            BigInteger value2 = ((IntegerValue) tempValue).getValue();
            if (operator instanceof Addition) {
                BigInteger newValue = value1.add(value2);
                tempValue = new IntegerValue(newValue.toString());
            }
            if (operator instanceof Subtraction) {
                BigInteger newValue = value1.subtract(value2);
                tempValue = new IntegerValue(newValue.toString());
            }
            if (operator instanceof Multiplication) {
                BigInteger newValue = value1.multiply(value2);
                tempValue = new IntegerValue(newValue.toString());
            }
            if (operator instanceof Division) {
                BigInteger newValue;
                if (value2.equals(BigInteger.ZERO)) {
                    newValue = BigInteger.ZERO;
                } else {
                    newValue = value1.divide(value2);
                }
                tempValue = new IntegerValue(newValue.toString());
            }
            if (operator instanceof Modulo) {
                BigInteger newValue;
                if (value2.equals(BigInteger.ZERO)) {
                    newValue = value1;
                } else {
                    newValue = value1.remainder(value2);
                }
                tempValue = new IntegerValue(newValue.toString());
            }
        } else {
            //Unary minus
            BigInteger newValue =
                    ((IntegerValue) tempValue).getValue().negate();
            tempValue = new IntegerValue(newValue.toString());
        }
    }

    @Override
    public void visit(NumericLiteral number) {
        tempValue = number.getValue();
    }

    @Override
    public void visit(LogicalExpression logicalExpression) {
        logicalExpression.getSubexpression1().accept(this);
        LogicalOperator operator = logicalExpression.getLogicalOperator();
        if (operator instanceof BinaryOperator) {
            Value tempValue1 = tempValue;
            logicalExpression.getSubexpression2().accept(this);
            Value tempValue2 = tempValue;
            if (operator instanceof Disjunction) {
                boolean newValue = ((BooleanValue) tempValue1).getValue()
                        || ((BooleanValue) tempValue2).getValue();
                tempValue = new BooleanValue(Boolean.toString(newValue));
            }
            if (operator instanceof Conjunction) {
                boolean newValue = ((BooleanValue) tempValue1).getValue()
                        && ((BooleanValue) tempValue2).getValue();
                tempValue = new BooleanValue(Boolean.toString(newValue));
            }
            if (operator instanceof Greater) {
                boolean newValue =
                        ((IntegerValue) tempValue1).getValue().intValue()
                            > ((IntegerValue) tempValue2).getValue().intValue();
                tempValue = new BooleanValue(Boolean.toString(newValue));
            }
            if (operator instanceof GreaterEqual) {
                boolean newValue =
                        ((IntegerValue) tempValue1).getValue().intValue()
                           >= ((IntegerValue) tempValue2).getValue().intValue();
                tempValue = new BooleanValue(Boolean.toString(newValue));
            }
            if (operator instanceof Less) {
                boolean newValue =
                        ((IntegerValue) tempValue1).getValue().intValue()
                            < ((IntegerValue) tempValue2).getValue().intValue();
                tempValue = new BooleanValue(Boolean.toString(newValue));
            }
            if (operator instanceof LessEqual) {
                boolean newValue =
                        ((IntegerValue) tempValue1).getValue().intValue()
                           <= ((IntegerValue) tempValue2).getValue().intValue();
                tempValue = new BooleanValue(Boolean.toString(newValue));
            }
            if (operator instanceof Equal) {
                boolean newValue = tempValue1.equals(tempValue2);
                tempValue = new BooleanValue(Boolean.toString(newValue));
            }
            if (operator instanceof NotEqual) {
                boolean newValue = !tempValue1.equals(tempValue2);
                tempValue = new BooleanValue(Boolean.toString(newValue));
            }
        } else {
            //Negation
            boolean newValue = !((BooleanValue) tempValue).getValue();
            tempValue = new BooleanValue(Boolean.toString(newValue));
        }
    }

    @Override
    public void visit(BooleanLiteral bool) {
        tempValue = bool.getValue();
    }

    @Override
    public void visit(FunctionCall functionCall) {
        if (returnValue != null) {
            currentState.createFunctionResult(functionCall, returnValue);
        }
        Value value = currentState.getReturnValues().get(functionCall);
        if (value == null) {
            //result not calculated yet
            Expression[] parameterExpressions = functionCall.getParameters();
            parameters = new Value[parameterExpressions.length];
            for (int i = 0; i < parameters.length; i++) {
                parameterExpressions[i].accept(this);
                parameters[i] = tempValue;
            }
            functionCall.getFunction().accept(this);
            //statement must be started again
            throw new StopStatementException();
        } else {
            tempValue = value;
        }
    }

    @Override
    public void visit(VariableRead variableRead) {
        tempValue = currentState.getVariables().get(variableRead.getVariable());
    }

    @Override
    public void visit(ArrayRead arrayRead) {
        Expression[] indexes = arrayRead.getIndexes();
        tempValue = currentState.getVariables().get(arrayRead.getVariable());
        for (Expression index : indexes) {
            index.accept(this);
            int pos = ((IntegerValue) tempValue).getValue().intValue();
            Value[] values = ((ArrayValue) tempValue).getValues();
            if (pos < 0 || pos >= values.length) {
                pos = 0;
            }
            tempValue = values[pos];
        }
    }

    @Override
    public void visit(Function function) {
        currentState.createScope(function.getFunctionBlock(), function);
        FunctionParameter[] params = function.getParameters();
        for (int i = 0; i < params.length; i++) {
            Value value = parameters[i];
            String varName = params[i].getName();
            if (value instanceof ArrayValue) {
                //TODO
            } else {
                currentState.createVar(varName, value.toString(),
                                       value.getType());
            }
        }
        Assumption[] assumptions = function.getAssumptions();
        for (Assumption assumption : assumptions) {
            assumption.accept(this);
        }
        adjustStatement();
    }

    @Override
    public void visit(Program program) {
        //TODO: is this needed?
        program.getMainFunction().accept(this);
    }

    @Override
    public void visit(Assignment assignment) {
        assignment.getValue().accept(this);
        currentState.setVar(assignment.getIdentifier().getName(),
                tempValue.toString());
        adjustStatement();
    }

    @Override
    public void visit(Assertion assertion) {
        assertion.getExpression().accept(this);
        if (!((BooleanValue) tempValue).getValue()) {
            throw new AssertionFailureException("Assertion failed!",
                                                assertion.getPosition());
        }
        adjustStatement();
    }

    @Override
    public void visit(Assumption assumption) {
        assumption.getExpression().accept(this);
        if (!((BooleanValue) tempValue).getValue()) {
            throw new AssertionFailureException("Assumption failed!",
                                                assumption.getPosition());
        }
    }

    @Override
    public void visit(Axiom axiom) {
        //TODO: is this needed in interpreter?
    }

    @Override
    public void visit(Ensure ensure) {
        ensure.getExpression().accept(this);
        if (!((BooleanValue) tempValue).getValue()) {
            throw new AssertionFailureException("Ensure failed!",
                                                ensure.getPosition());
        }
    }

    @Override
    public void visit(Invariant invariant) {
        invariant.getExpression().accept(this);
        if (!((BooleanValue) tempValue).getValue()) {
            throw new AssertionFailureException("Invariant failed!",
                                                invariant.getPosition());
        }
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
        returnStatement.getReturnValue().accept(this);
        returnValue = tempValue;
        Ensure[] ensures = currentState.getCurrentFunction().getEnsures();
        currentState.adjustStatement();
        try {
            for (Ensure ensure : ensures) {
                ensure.accept(this);
            }
        } finally {
            while (!currentState.isFunctionScope()) {
                currentState.destroyScope();
            }
            currentState.destroyScope();
        }
    }

    @Override
    public void visit(VariableDeclaration varDec) {
        if (varDec.getValue() == null) {
            currentState.createVar(varDec.getName(), null, varDec.getType());
        } else {
            varDec.getValue().accept(this);
            currentState.createVar(varDec.getName(),
                        tempValue.toString(), varDec.getType());
        }
        adjustStatement();
    }

    @Override
    public void visit(ArrayDeclaration arrDec) {
        Expression[] indexes = arrDec.getIndexes();
        int[] lengths = new int[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i].accept(this);
            int length = ((IntegerValue) tempValue).getValue().intValue();
            lengths[i] = (length > 0) ? length : 1;
        }
        currentState.createArray(arrDec.getName(), arrDec.getType(), lengths);
        adjustStatement();
    }

    @Override
    public void visit(ExistsQuantifier existsQuantifier) {
        Range range = existsQuantifier.getRange();
        if (range != null) {
            range.getLowerBound().accept(this);
            int lower = ((IntegerValue) tempValue).getValue().intValue();
            range.getUpperBound().accept(this);
            int upper = ((IntegerValue) tempValue).getValue().intValue();
            currentState.createScope(null, null);
            String varName = existsQuantifier.getIdentifier().toString();
            currentState.createVar(varName, null, new IntegerType());
            boolean satisfied = false;
            for (int i = lower; i <= upper; i++) {
                currentState.setVar(varName, Integer.toString(i));
                existsQuantifier.getSubexpression1().accept(this);
                if (((BooleanValue) tempValue).getValue()) {
                    //found a satisfying value
                    satisfied = true;
                }
            }
            tempValue = new BooleanValue(Boolean.toString(satisfied));
            currentState.destroyScope();
        } else {
            //TODO: give to verifier
        }
    }

    @Override
    public void visit(ForAllQuantifier forAllQuantifier) {
        Range range = forAllQuantifier.getRange();
        if (range != null) {
            range.getLowerBound().accept(this);
            int lower = ((IntegerValue) tempValue).getValue().intValue();
            range.getUpperBound().accept(this);
            int upper = ((IntegerValue) tempValue).getValue().intValue();
            currentState.createScope(null, null);
            String varName = forAllQuantifier.getIdentifier().toString();
            currentState.createVar(varName, null, new IntegerType());
            boolean valid = true;
            for (int i = lower; i <= upper; i++) {
                currentState.setVar(varName, Integer.toString(i));
                forAllQuantifier.getSubexpression1().accept(this);
                if (!((BooleanValue) tempValue).getValue()) {
                    //found a counterexample
                    valid = false;
                }
            }
            tempValue = new BooleanValue(Boolean.toString(valid));
            currentState.destroyScope();
        } else {
            //TODO: give to verifier
        }
    }

    @Override
    public void visit(StatementBlock statementBlock) {
        //TODO: is this needed?
    }

    @Override
    public void visit(Length length) {
        length.getArray().accept(this);
        int arrayLength = ((ArrayValue) tempValue).getValues().length;
        tempValue = new IntegerValue(Integer.toString(arrayLength));
    }

    private void adjustStatement() {
        returnValue = null;
        Function currentFunction = currentState.getCurrentFunction();
        currentState.adjustStatement();
        if (currentState.getCurrentStatement() == null) {
            if (currentState.isFunctionScope()) {
                 returnValue = (currentFunction.getReturnType()
                                    instanceof BooleanType)
                              ? new BooleanValue(null) : new IntegerValue(null);
                Ensure[] ensures = currentFunction.getEnsures();
                try {
                    for (Ensure ensure : ensures) {
                        ensure.accept(this);
                    }
                } finally {
                    currentState.destroyScope();
                }
            } else {
                currentState.destroyScope();
                if (currentState.getCurrentStatement() instanceof Conditional) {
                    adjustStatement();
                }
            }
        }
    }
}
