package interpreter;

/**
 * This class represents a statement that pauses the execution
 * of a program if it reaches the current line.
 */
public class StatementBreakpoint extends Breakpoint {
    /**
     * line to be watched
     */
    private final int line;

    /**
     * Constructor.
     *
     * @param line line to be watched
     */
    public StatementBreakpoint(int line) {
        this.line = line;
    }

    /**
     * Returns the line to be watched.
     * @return line to be watched
     */
    public int getLine() {
        return line;
    }
}
