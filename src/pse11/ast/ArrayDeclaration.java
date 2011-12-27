package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 *
 */
public class ArrayDeclaration extends VariableDeclaration {
    private ArrayList<ArithmeticExpression> indexes;

    public ArrayDeclaration(Position position, String name,
                            Expression value, Type type, ArrayList<ArithmeticExpression> indexes) {
        super(position, name, value, type);
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
