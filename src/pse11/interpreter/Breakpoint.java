package interpreter;

/**
 * This class is a superclass of all breakpoints. If an active breakpoint
 * is hit, execution of the user program stops. An inactive breakpoint
 * is ignored.
 */
public abstract class Breakpoint {
    /**
     * Indicates whether this breakpoint is active.
     */
    private boolean active;

    /**
     * Constructor.
     * The breakpoint is set inactive by default.
     */
    protected Breakpoint() {
        active = false;
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
