package ast;

import interpreter.ASTVisitor;
import interpreter.BooleanValue;
import interpreter.Value;

/**
 * This class symbolizes a single, constant value of BooleanType.
 */
public class BooleanLiteral extends LogicalExpression {
    /**
     * Value represented by this literal
     */
    private final Value value;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param value value of this literal (as String)
     */
    public BooleanLiteral(Position position, String value) {
        super(position, null, null, null);
        this.value = new BooleanValue(value);
    }

    /**
     * Returns the value of this literal.
     * @return value of this literal
     */
    public Value getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
