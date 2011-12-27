package ast;

import interpreter.ASTVisitor;

/**
 *  This class symbolizes an expression in the user program which result
 *  is from type BooleanType.
 */
public class LogicalExpression extends Expression {
    /**
     *  The first operand of the expression (may only be null if
     *  this instanceof BooleanLiteral), which may be an expression itself.
     */
    private Expression subexpression1;
    /**
     *  The second operand of the expression (may only be null if
     *  this instanceof BooleanLiteral or in case of a unary operator),
     *  which may be an expression itself.
     */
    private Expression subexpression2;
    /**
     *  The operator of this calculation (may only be null if
     *  this instanceof BooleanLiteral).
     */
    private LogicalOperator logicalOperator;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param subexpression1 the first operand
     * @param subexpression2 the second operand
     * @param logicalOperator the operator
     */
    public LogicalExpression(Position position, Expression subexpression1,
                             Expression subexpression2,
                             LogicalOperator logicalOperator) {
        super(position);
        this.subexpression1 = subexpression1;
        this.subexpression2 = subexpression2;
        this.logicalOperator = logicalOperator;
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
    public LogicalOperator getLogicalOperator() {
        return logicalOperator;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
