package ast;

/**
 *  This class symbolizes an expression in the user program which result
 *  is from type IntegerType.
 */
public class ArithmeticExpression extends Expression {
    /**
     *  The first operand of the expression (may only be null if
     *  this instanceof NumericLiteral), which may be an expression itself.
     */
    private final Expression subexpression1;
    /**
     *  The second operand of the expression (may only be null if
     *  this instanceof NumericLiteral or in case of a unary operator),
     *  which may be an expression itself.
     */
    private final Expression subexpression2;
    /**
     *  The operator of this calculation (may only be null if
     *  this instanceof NumericLiteral).
     */
    private final ArithmeticOperator arithmeticOperator;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param subexpression1 the first operand
     * @param subexpression2 the second operand
     * @param arithmeticOperator the operator
     */
    public ArithmeticExpression(Position position,
                                Expression subexpression1,
                                Expression subexpression2,
                                ArithmeticOperator arithmeticOperator) {
        super(position);
        this.subexpression1 = subexpression1;
        this.subexpression2 = subexpression2;
        this.arithmeticOperator = arithmeticOperator;
    }

    /**
     * Returns the first operand of this expression.
     * @return the first operand
     */
    public Expression getSubexpression1() {
        return subexpression1;
    }

    /**
     * Returns the second operand of this expression.
     * @return the second operand
     */
    public Expression getSubexpression2() {
        return subexpression2;
    }

    /**
     * Returns the operator of this expression.
     * @return the operator of this expression
     */
    public ArithmeticOperator getArithmeticOperator() {
        return arithmeticOperator;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        if (arithmeticOperator instanceof BinaryOperator) {
            sb.append(subexpression1.toString()).append(' ');
            sb.append(arithmeticOperator.toString());
            sb.append(' ').append(subexpression2.toString());
        } else {
            sb.append(arithmeticOperator.toString());
            sb.append(' ').append(subexpression1.toString());
        }
        sb.append(')');
        return sb.toString();
    }
}
