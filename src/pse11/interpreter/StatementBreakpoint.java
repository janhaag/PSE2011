package interpreter;

import ast.Statement;

/**
 *
 */
public class StatementBreakpoint extends Breakpoint {
    private final Statement statement;
    
    public StatementBreakpoint(Statement statement) {
        this.statement = statement;
    }

    public Statement getStatement() {
        return statement;
    }
}
