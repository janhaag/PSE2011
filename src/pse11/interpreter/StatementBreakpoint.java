package interpreter;

/**
 *
 */
public class StatementBreakpoint extends Breakpoint {
    private final int line;
    
    public StatementBreakpoint(int line) {
        this.line = line;
    }

    public int getLine() {
        return line;
    }
}
