package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class VariableRead extends Expression {
    private Identifier variable;

    public VariableRead(Position position, Identifier variable) {
        super(position);
        this.variable = variable;
    }

    public Identifier getVariable() {
        return variable;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
