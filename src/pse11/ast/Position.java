package ast;

/**
 * This class encapsulates the position of AST elements
 * in the original source code.
 */
public class Position {
    /**
     * the line in which the element begins
     */
    private final int line;
    /**
     * the column in which the element begins
     */
    private final int column;

    /**
     * Constructor.
     *
     * @param line line the element begins
     * @param column column the element begins
     */
    public Position(int line, int column) {
        this.line = line;
        this.column = column;
    }
     public Position() {
         this(0, 0);
     }

    /**
     * Returns the line of the element.
     * @return line of the element
     */
    public int getLine() {
        return line;
    }

    /**
     * Returns the column of the element.
     * @return column of the element
     */
    public int getColumn() {
        return column;
    }

}
