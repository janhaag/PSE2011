package ast;

/**
 * This class symbolizes a single, constant value of BooleanType.
 */
public class BooleanLiteral extends LogicalExpression {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     */
    public BooleanLiteral(Position position) {
        super(position, null, null, null);
    }
}
