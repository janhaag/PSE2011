package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class Assertion extends Specification {
    public Assertion(Position position, LogicalExpression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
