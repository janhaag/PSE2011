package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class VariableDeclaration extends Statement {
    private Type type;
    private Expression value;
    private String name;

    public VariableDeclaration(Position position, String name, Expression value, Type type) {
        super(position);
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public Expression getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
