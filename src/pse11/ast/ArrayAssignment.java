package ast;

/**
 *  This class symbolizes the assignment of a value to an array.
 */
public class ArrayAssignment extends Assignment {
    /**
     * Indexes used to determine the position of the assigned array element.
     */
    private final Expression[] indices;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param value the value which is stored into the array
     * @param identifier name of the array to which the value is assigned
     * @param indices position to which the new value is stored
     */
    public ArrayAssignment(Position position, Expression value,
                           Identifier identifier, Expression[] indices) {
        super(position, value, identifier);
        this.indices = indices;
    }

    /**
     * Returns the list of indices for this assignment.
     * @return the indices for this assignment
     */
    public Expression[] getIndices() {
        return indices;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getIdentifier().toString());
        for (Expression index : indices) {
            sb.append('[');
            sb.append(index.toString());
            sb.append(']');
        }
        sb.append(" = ").append(getValue().toString());
        sb.append(";\n");
        return sb.toString();
    }
}
