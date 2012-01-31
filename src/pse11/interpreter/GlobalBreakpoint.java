package interpreter;

import ast.Expression;

/**
 * This class represents a global breakpoint that pauses the execution
 * of a program if its expression is true.
 */
public class GlobalBreakpoint extends Breakpoint {
    /**
     * expression to be watched
     */
    private final Expression expression;
    /**
     * Indicates whether this breakpoint is active.
     */
    private boolean active;

    /**
     * Constructor.
     *
     * @param expression expression to be watched
     */
    public GlobalBreakpoint(Expression expression) {
        this.expression = expression;
        active = true;
    }

    /**
     * Returns the expression that is watched.
     * @return expression to be watched
     */
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
