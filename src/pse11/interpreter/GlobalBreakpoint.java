package interpreter;

import ast.Expression;

/**
 *
 */
public class GlobalBreakpoint extends Breakpoint {
    private final Expression expression;

    public GlobalBreakpoint(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
