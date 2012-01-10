package interpreter;

import ast.*;

import java.util.ArrayList;

/**
 *
 */
public class Interpreter implements ASTVisitor {
    private Value tempValue;
    private State currentState;
    
    public State step(State state) {
        currentState = state;
        state.getCurrentStatement().accept(this);
        state.adjustStatement();
        return state;
    }

    public void visit(Conditional conditional) {
        conditional.getCondition().accept(this);
        if (((BooleanValue) tempValue).getValue()) {
            currentState.createScope(conditional.getTrueConditionBody(),
                                     false);
        } else {
            currentState.createScope(conditional.getFalseConditionBody(),
                                     false);
        }
    }

    public void visit(Loop loop) {
        //TODO: reset loop somehow
    }

    public void visit(ArrayAssignment arrayAssignment) {
        Expression[] indexes = arrayAssignment.getIndexes();
        ArrayList<Integer> lengths = new ArrayList<Integer>();
        for (int i = 0; i < indexes.length; i++) {
            indexes[i].accept(this);
            int pos = ((IntegerValue) tempValue).getValue().intValue();
            lengths.add(pos);
        }
        arrayAssignment.getValue().accept(this);
        currentState.setArray(arrayAssignment.getIdentifier().toString(),
                              tempValue.toString(), lengths);
    }

    public void visit(ArithmeticExpression arithmeticExpression) {
    }

    public void visit(NumericLiteral number) {
        tempValue = number.getValue();
    }

    public void visit(LogicalExpression logicalExpression) {
        logicalExpression.getSubexpression1().accept(this);
        if (logicalExpression.getLogicalOperator().isBinary()) {
            Value tempValue1 = tempValue;
            logicalExpression.getSubexpression2().accept(this);
            Value tempValue2 = tempValue;
            LogicalOperator operator = logicalExpression.getLogicalOperator();
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

    public void visit(BooleanLiteral bool) {
        tempValue = bool.getValue();
    }

    public void visit(FunctionCall functionCall) {
    }

    public void visit(VariableRead variableRead) {
        tempValue = currentState.getVariables().get(variableRead.getVariable());
    }

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

    public void visit(Function function) {
        //TODO: maybe single step through assumptions
        Assumption[] assumptions = function.getAssumptions();
        for (Assumption assumption : assumptions) {
            assumption.accept(this);
        }
        FunctionParameter[] params = function.getParameters();
        for (FunctionParameter param : params) {
            //TODO: read params
        }
    }

    public void visit(Program program) {
        //TODO: is this needed?
        program.getMainFunction().accept(this);
    }

    public void visit(Assignment assignment) {
        assignment.getValue().accept(this);
        currentState.setVar(assignment.getIdentifier().getName(),
                tempValue.toString());
    }

    public void visit(Assertion assertion) {
        assertion.getExpression().accept(this);
        if (!((BooleanValue) tempValue).getValue()) {
            throw new AssertionFailureException("Assertion failed!",
                                                assertion.getPosition());
        }
    }

    public void visit(Assumption assumption) {
        assumption.getExpression().accept(this);
        if (!((BooleanValue) tempValue).getValue()) {
            throw new AssertionFailureException("Assumption failed!",
                                                assumption.getPosition());
        }
    }

    public void visit(Axiom axiom) {
    }

    public void visit(Ensure ensure) {
        ensure.getExpression().accept(this);
        if (!((BooleanValue) tempValue).getValue()) {
            throw new AssertionFailureException("Ensure failed!",
                                                ensure.getPosition());
        }
    }

    public void visit(Invariant invariant) {
        invariant.getExpression().accept(this);
        if (!((BooleanValue) tempValue).getValue()) {
            throw new AssertionFailureException("Invariant failed!",
                                                invariant.getPosition());
        }
    }

    public void visit(ReturnStatement returnStatement) {
    }

    public void visit(VariableDeclaration varDec) {
        if (varDec.getValue() == null) {
            currentState.createVar(varDec.getName(), null, varDec.getType());
        } else {
            varDec.getValue().accept(this);
            currentState.createVar(varDec.getName(),
                        tempValue.toString(), varDec.getType());
        }
    }

    public void visit(ArrayDeclaration arrDec) {
        Expression[] indexes = arrDec.getIndexes();
        int[] lengths = new int[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i].accept(this);
            int length = ((IntegerValue) tempValue).getValue().intValue();
            lengths[i] = (length > 0) ? length : 1;
        }
        currentState.createArray(arrDec.getName(), arrDec.getType(), lengths);
    }

    public void visit(ExistsQuantifier existsQuantifier) {
        Range range = existsQuantifier.getRange();
        if (range != null) {
            range.getLowerBound().accept(this);
            int lower = ((IntegerValue) tempValue).getValue().intValue();
            range.getUpperBound().accept(this);
            int upper = ((IntegerValue) tempValue).getValue().intValue();
            currentState.createScope(null, false);
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
            //TODO
        }
    }

    public void visit(ForAllQuantifier forAllQuantifier) {
        Range range = forAllQuantifier.getRange();
        if (range != null) {
            range.getLowerBound().accept(this);
            int lower = ((IntegerValue) tempValue).getValue().intValue();
            range.getUpperBound().accept(this);
            int upper = ((IntegerValue) tempValue).getValue().intValue();
            currentState.createScope(null, false);
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
            //TODO
        }
    }

    public void visit(StatementBlock statementBlock) {
    }

    public void visit(Length length) {
        length.getArray().accept(this);
        int arrayLength = ((ArrayValue) tempValue).getValues().length;
        tempValue = new IntegerValue(Integer.toString(arrayLength));
    }
}
