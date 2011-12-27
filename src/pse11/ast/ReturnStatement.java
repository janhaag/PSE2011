package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class ReturnStatement extends Statement {
    private Expression returnValue;

    public ReturnStatement(Position position, Expression returnValue) {
        super(position);
        this.returnValue = returnValue;
    }

    public Expression getReturnValue() {
        return returnValue;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
