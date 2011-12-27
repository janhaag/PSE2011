package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class Length extends Expression {
    public Length(Position position) {
        super(position);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
