package interpreter;

import ast.ASTRoot;
import ast.Expression;
import ast.Identifier;
import ast.Statement;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class ProgramExecution {
    private final State currentState;
    private final ArrayList<StatementBreakpoint> statementBreakpoints;
    private final ArrayList<GlobalBreakpoint> globalBreakpoints;

    public ProgramExecution(ASTRoot ast) {
        this.statementBreakpoints = new ArrayList<StatementBreakpoint>();
        this.globalBreakpoints = new ArrayList<GlobalBreakpoint>();
        currentState = new State(ast);
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
            //TODO: typecheck
            //TODO: evaluate
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
