package ast;

import interpreter.ASTVisitor;

public abstract class ASTRoot {
    private Position position;

    protected ASTRoot(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract void accept(ASTVisitor visitor);
}