package interpreter;

import ast.Expression;

/**
 *
 */
public class GlobalBreakpoint extends Breakpoint {
    private final Expression expression;
    /**
     * Indicates whether this breakpoint is active.
     */
    private boolean active;

    public GlobalBreakpoint(Expression expression) {
        this.expression = expression;
        active = false;
    }

    public Expression getExpression() {
        return expression;
    }

    /**
     * Returns whether this breakpoint is active.
     * @return whether this breakpoint is active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the breakpoint inactive/active, depending on parameter active.
     * @param active indicates whether this breakpoint is set active
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
