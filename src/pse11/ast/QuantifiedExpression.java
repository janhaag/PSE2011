package ast;

/**
 *
 */
public abstract class QuantifiedExpression extends Expression {
    QuantifiedExpression subexpression;
    LogicalExpression expression;

    public QuantifiedExpression(Position position, QuantifiedExpression subexpression, LogicalExpression expression) {
        super(position);
        this.subexpression = subexpression;
        this.expression = expression;
    }

    public QuantifiedExpression getSubexpression() {
        return subexpression;
    }

    public LogicalExpression getExpression() {
        return expression;
    }
}
