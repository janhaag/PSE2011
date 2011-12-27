package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class ExistsQuantifier extends QuantifiedExpression {
    public ExistsQuantifier(Position position, QuantifiedExpression subexpression, LogicalExpression expression) {
        super(position, subexpression, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
