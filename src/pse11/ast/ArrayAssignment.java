package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 *
 */
public class ArrayAssignment extends Assignment {
    private ArrayList<ArithmeticExpression> indexes;

    public ArrayAssignment(Position position, Expression value, Identifier identifier, ArrayList<ArithmeticExpression> indexes) {
        super(position, value, identifier);
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
