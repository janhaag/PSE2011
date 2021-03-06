package ast;

/**
 * This class symbolizes a reading access to an array element
 * with the provided position.
 */
public class ArrayRead extends VariableRead {
    /**
     * Indexes used to determine the position of the read array element.
     */
    private final Expression[] indices;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param variable name of the array that is read
     * @param indices position from which the element is read
     */
    public ArrayRead(Position position, Identifier variable,
                     Expression[] indices) {
        super(position, variable);
        this.indices = indices;
    }

    /**
     * Returns the list of array indices for the element to be read
     * @return list of array indices
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
        StringBuilder sb = new StringBuilder(getVariable().toString());
        for (Expression index : indices) {
            sb.append('[');
            sb.append(index.toString());
            sb.append(']');
        }
        return sb.toString();
    }
}
