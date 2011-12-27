package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 *  This class symbolizes the assignment of a value to an array.
 */
public class ArrayAssignment extends Assignment {
    /**
     * Indexes used to determine the position of the assigned array element.
     */
    private ArrayList<ArithmeticExpression> indexes;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param value the value which is stored into the array
     * @param identifier name of the array to which the value is assigned
     * @param indexes position to which the new value is stored
     */
    public ArrayAssignment(Position position, Expression value,
                           Identifier identifier,
                           ArrayList<ArithmeticExpression> indexes) {
        super(position, value, identifier);
        this.indexes = indexes;
    }

    /**
     * Returns the list of indexes for this assignment.
     * @return the indexes for this assignment
     */
    public ArrayList<ArithmeticExpression> getIndexes() {
        return indexes;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
