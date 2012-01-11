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
    private final ArrayList<StatementBreakpoint> statementBreakpoints;
    /**
     * list of this program's global breakpoints
     */
    private final ArrayList<GlobalBreakpoint> globalBreakpoints;
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
    public ProgramExecution(ASTRoot ast, Interpreter interpreter) {
        this.statementBreakpoints = new ArrayList<StatementBreakpoint>();
        this.globalBreakpoints = new ArrayList<GlobalBreakpoint>();
        currentState = new State(ast);
        typeChecker = new TypeChecker();
        this.interpreter = interpreter;
    }

    public boolean checkBreakpoints() {
        for (StatementBreakpoint statementBreakpoint : statementBreakpoints) {
            if ((statementBreakpoint.getStatement()
                                        == currentState.getCurrentStatement())
                    && statementBreakpoint.isActive()) {
                return true;
            }
        }
        for (GlobalBreakpoint globalBreakpoint : globalBreakpoints) {
            typeChecker.setCurrentScope(currentState.getCurrentScope());
            try {
                Expression condition = globalBreakpoint.getExpression();
                Assertion assertion = new Assertion(new Position(), condition);
                assertion.accept(typeChecker);
                assertion.accept(interpreter);
                return true;
            } catch (IllegalTypeException e) {
            } catch (AssertionFailureException e) {
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

    public void createStatementBreakpoint(Statement statement) {
        statementBreakpoints.add(new StatementBreakpoint(statement));
    }

    public void createGlobalBreakpoint(Expression expression) {
        globalBreakpoints.add(new GlobalBreakpoint(expression));
    }
    
    public HashMap<Identifier, Value> getVariables() {
        return currentState.getVariables();
    }
}
