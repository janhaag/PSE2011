package ast;

import interpreter.ASTVisitor;

/**
 * This class represents a special cased function:
 * the length calculation of an array.
 */
public class Length extends Expression {
    /**
     * array which length should be calculated
     */
    private final VariableRead array;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param array array which length should be calculated
     */
    public Length(Position position, VariableRead array) {
        super(position);
        this.array = array;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Returns the array parameter of the length function
     * @return array parameter of the length function
     */
    public VariableRead getArray() {
        return array;
    }
}
