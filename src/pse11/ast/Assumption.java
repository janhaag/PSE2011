package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class Assumption extends Specification {
    public Assumption(Position position, LogicalExpression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
