package interpreter;

import ast.*;
import parser.IllegalTypeException;
import parser.TypeChecker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class encapsulates the context of a program execution.
 */
public class ProgramExecution {
    /**
     * state the program currently is in
     */
    private final State currentState;
    /**
     * list of this program's statement breakpoints
     */
    private ArrayList<StatementBreakpoint> statementBreakpoints;
    /**
     * list of this program's global breakpoints
     */
    private ArrayList<GlobalBreakpoint> globalBreakpoints;
    
    private int[] parameterValues;
    
    //TODO: delete typeChecker if necessary
    /**
     * type checker to evaluate the type correctness of global statements
     */
    private final TypeChecker typeChecker;
    /**
     * interpreter to evaluate breakpoint expressions 
     */
    private final Interpreter interpreter;

    /**
     * Constructor.
     * 
     * @param ast program whose execution context is saved
     * @param interpreter interpreter to evaluate breakpoint expressions
     */
    public ProgramExecution(ASTRoot ast, Interpreter interpreter, ArrayList<StatementBreakpoint> sbreakpoints,
    		ArrayList<GlobalBreakpoint> gbreakpoints, int[] parameterValues) {
        this.statementBreakpoints = sbreakpoints;
        this.globalBreakpoints = gbreakpoints;
        this.parameterValues = parameterValues;
        currentState = new State(ast);
        typeChecker = new TypeChecker();
        this.interpreter = interpreter;
        Value[] values = new Value[parameterValues.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = new IntegerValue(Integer.toString(parameterValues[i]));
        }
        initParams(values);
    }

    private void initParams(Value[] values) {
        FunctionParameter[] parameters = currentState.getCurrentFunction().getParameters();
        for (int i = 0; i < parameters.length; i++) {
            currentState.createVar(parameters[i].getName(),
                    values[i].toString(), values[i].getType());
        }
    }

    public boolean checkBreakpoints() {
        for (StatementBreakpoint statementBreakpoint : statementBreakpoints) {
            if ((currentState.getCurrentStatement().getPosition().getLine()
                            == statementBreakpoint.getLine())
                    && statementBreakpoint.isActive()) {
                return true;
            }
        }
        for (GlobalBreakpoint globalBreakpoint : globalBreakpoints) {
            if (globalBreakpoint.isActive()) {
                typeChecker.setCurrentScope(currentState.getCurrentScope());
                try {
                    Expression condition = globalBreakpoint.getExpression();
                    Assertion assertion = new Assertion(new Position(), condition);
                    typeChecker.setFunctionCallAllowed(false);
                    assertion.accept(typeChecker);
                    typeChecker.setFunctionCallAllowed(true);
                    assertion.accept(interpreter);
                    return true;
                } catch (IllegalTypeException ignored) {
                } catch (AssertionFailureException ignored) {
                }
            }
        }
        return false;
    }

    public State getCurrentState() {
        return currentState;
    }

    public ArrayList<StatementBreakpoint> getStatementBreakpoints() {
        return statementBreakpoints;
    }

    public ArrayList<GlobalBreakpoint> getGlobalBreakpoints() {
        return globalBreakpoints;
    }

    public void setStatementBreakpoints(
            ArrayList<StatementBreakpoint> statementBreakpoints) {
        this.statementBreakpoints = statementBreakpoints;
    }

    public void setGlobalBreakpoints(
            ArrayList<GlobalBreakpoint> globalBreakpoints) {
        this.globalBreakpoints = globalBreakpoints;
    }
    
    public HashMap<Identifier, Value> getVariables() {
        return currentState.getVariables();
    }
}
