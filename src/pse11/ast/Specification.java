package ast;

/**
 *
 */
public abstract class Specification extends Statement {
    private LogicalExpression expression;

    protected Specification(Position position, LogicalExpression expression) {
        super(position);
        this.expression = expression;
    }

    public LogicalExpression getExpression() {
        return expression;
    }
}
