package ast;

import interpreter.ASTVisitor;
import interpreter.IntegerValue;
import interpreter.Value;

/**
 * This class represents a single, constant value of IntegerType.
 */
public class NumericLiteral extends ArithmeticExpression {
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
    public NumericLiteral(Position position, String value) {
        super(position, null, null, null);
        this.value = new IntegerValue(value);
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
