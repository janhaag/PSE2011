package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 *
 */
public class ArrayRead extends VariableRead {
    private ArrayList<ArithmeticExpression> indexes;

    public ArrayRead(Position position, Identifier variable, ArrayList<ArithmeticExpression> indexes) {
        super(position, variable);
        this.indexes = indexes;
    }

    public ArrayList<ArithmeticExpression> getIndexes() {
        return indexes;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
