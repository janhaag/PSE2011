package ast;

/**
 * This class represent a single statement in the program.
 */
public abstract class Statement extends ASTRoot {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     */
    protected Statement(Position position) {
        super(position);
    }
}
