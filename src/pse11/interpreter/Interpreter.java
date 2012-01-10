package interpreter;

import ast.*;

/**
 *
 */
public class Interpreter implements ASTVisitor {
    private Value tempValue;
    private State currentState;
    
    public State step(State state) {
        //TODO: make something sensible in here
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
    }

    public void visit(ArrayAssignment arrayAssignment) {
    }

    public void visit(ArithmeticExpression arithmeticExpression) {
    }

    public void visit(NumericLiteral number) {
        tempValue = number.getValue();
    }

    public void visit(LogicalExpression logicalExpression) {
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
    }

    public void visit(Assumption assumption) {
    }

    public void visit(Axiom axiom) {
    }

    public void visit(Ensure ensure) {
    }

    public void visit(Invariant invariant) {
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
    }

    public void visit(ExistsQuantifier existsQuantifier) {
    }

    public void visit(ForAllQuantifier forAllQuantifier) {
    }

    public void visit(StatementBlock statementBlock) {
    }

    public void visit(Length length) {
    }
}
