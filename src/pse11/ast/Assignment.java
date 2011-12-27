package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class Assignment extends Statement {
    private Expression value;
    private Identifier identifier;

    public Assignment(Position position, Expression value, Identifier identifier) {

        super(position);
        this.value = value;
        this.identifier = identifier;
    }

    public Expression getValue() {
        return value;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
