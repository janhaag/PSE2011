package ast;

/**
 * This class represents a single, constant value of IntegerType.
 */
public class NumericLiteral extends ArithmeticExpression {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     */
    public NumericLiteral(Position position) {
        super(position, null, null, null);
    }
}
