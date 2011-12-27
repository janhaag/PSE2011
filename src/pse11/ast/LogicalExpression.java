package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class LogicalExpression extends Expression {
    private Expression subexpression1;
    private Expression subexpression2;
    private LogicalOperator logicalOperator;

    public LogicalExpression(Position position, Expression subexpression1,
                             Expression subexpression2, LogicalOperator logicalOperator) {
        super(position);
        this.subexpression1 = subexpression1;
        this.subexpression2 = subexpression2;
        this.logicalOperator = logicalOperator;
    }

    public Expression getSubexpression1() {
        return subexpression1;
    }

    public Expression getSubexpression2() {
        return subexpression2;
    }

    public LogicalOperator getLogicalOperator() {
        return logicalOperator;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
