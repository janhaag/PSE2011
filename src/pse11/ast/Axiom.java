package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class Axiom extends Specification {
    public Axiom(Position position, LogicalExpression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
