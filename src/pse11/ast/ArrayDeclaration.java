package ast;

/**
 * This class symbolizes a declaration of a new array
 * with specified dimensions.
 */
public class ArrayDeclaration extends VariableDeclaration {
    /**
     * List of the lengths of the different array dimensions.
     * The length of this list is the dimension of the array.
     */
    private final Expression[] indices;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param name name of the array identifier
     * @param type type of the array declared
     * @param indices length of the array dimensions
     */
    public ArrayDeclaration(Position position, String name, Type type,
                            Expression[] indices) {
        super(position, name, null, type);
        this.indices = indices;
    }

    /**
     * Returns the list of the array lengths.
     * @return list of array lengths
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
        StringBuilder sb = new StringBuilder(getType().toString());
        sb.append(' ').append(getName());
        for (Expression index : indices) {
            sb.append('[');
            sb.append(index.toString());
            sb.append(']');
        }
        sb.append(";\n");
        return sb.toString();
    }
}
