package ast;

/**
 * This class is a superclass of all classes representing expressions.
 */
public abstract class Expression extends Statement {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     */
    protected Expression(Position position) {
        super(position);
    }
}
