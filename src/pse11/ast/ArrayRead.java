package ast;

/**
 * This class symbolizes a reading access to an array element
 * with the provided position.
 */
public class ArrayRead extends VariableRead {
    /**
     * Indexes used to determine the position of the read array element.
     */
    private final Expression[] indexes;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param variable name of the array that is read
     * @param indexes position from which the element is read
     */
    public ArrayRead(Position position, Identifier variable,
                     Expression[] indexes) {
        super(position, variable);
        this.indexes = indexes;
    }

    /**
     * Returns the list of array indexes for the element to be read
     * @return list of array indexes
     */
    public Expression[] getIndexes() {
        return indexes;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getVariable().toString());
        for (Expression index : indexes) {
            sb.append('[');
            sb.append(index.toString());
            sb.append(']');
        }
        return sb.toString();
    }
}
