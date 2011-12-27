package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class ForAllQuantifier extends QuantifiedExpression {
    public ForAllQuantifier(Position position, QuantifiedExpression subexpression, LogicalExpression expression) {
        super(position, subexpression, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
