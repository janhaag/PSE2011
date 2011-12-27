package ast;

import interpreter.ASTVisitor;

/**
 * This class is the inheritance root for all the classes in the AST.
 * For every logical part of the program there is a dedicates
 * subclass of ASTRoot.
 * All its subclasses can be visited by an ASTVisitor.
 */
public abstract class ASTRoot {
    /**
     * indicates the position of the element
     * in the original source code
     */
    private Position position;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     */
    protected ASTRoot(Position position) {
        this.position = position;
    }

    /**
     * Returns the position of this element.
     * @return position of this element
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Accepts a visitor that encapsulates calculations on an AST.
     * @param visitor the visitor visiting this element
     */
    public abstract void accept(ASTVisitor visitor);
}