package ast;

import interpreter.ASTVisitor;

/**
 * This class represents a special cased function:
 * the length calculation of an array.
 */
public class Length extends Expression {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     */
    public Length(Position position) {
        super(position);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
