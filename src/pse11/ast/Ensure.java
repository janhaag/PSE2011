package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class Ensure extends Specification {
    public Ensure(Position position, LogicalExpression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
