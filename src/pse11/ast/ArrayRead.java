package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 * This class symbolizes a reading access to an array element
 * with the provided position.
 */
public class ArrayRead extends VariableRead {
    /**
     * Indexes used to determine the position of the read array element.
     */
    private ArrayList<ArithmeticExpression> indexes;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param variable name of the array that is read
     * @param indexes position from which the element is read
     */
    public ArrayRead(Position position, Identifier variable,
                     ArrayList<ArithmeticExpression> indexes) {
        super(position, variable);
        this.indexes = indexes;
    }

    /**
     * Returns the list of array indexes for the element to be read
     * @return list of array indexes
     */
    public ArrayList<ArithmeticExpression> getIndexes() {
        return indexes;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
