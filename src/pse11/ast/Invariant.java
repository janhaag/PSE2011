package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class Invariant extends Specification{
    public Invariant(Position position, LogicalExpression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
