package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 * This class symbolizes a declaration of a new array
 * with specified dimensions.
 */
public class ArrayDeclaration extends VariableDeclaration {
    /**
     * List of the lengths of the different array dimensions.
     * The length of this list is the dimension of the array.
     */
    private ArrayList<ArithmeticExpression> indexes;

    /**
     * Constructor.
     *
     * @param position indicates the position of this expression
     *                 in the original source code
     * @param name name of the array identifier
     * @param type type of the array declared
     * @param indexes length of the array dimensions
     */
    public ArrayDeclaration(Position position, String name, Type type,
                            ArrayList<ArithmeticExpression> indexes) {
        super(position, name, null, type);
        this.indexes = indexes;
    }

    /**
     * Returns the list of the array lengths.
     * @return list of array lengths
     */
    public ArrayList<ArithmeticExpression> getIndexes() {
        return indexes;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
