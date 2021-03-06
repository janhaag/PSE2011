package ast;

/**
 * This class symbolizes a declaration of a new variable.
 * For declaration of arrays there is a subclass @see{ArrayDeclaration}.
 */
public class VariableDeclaration extends Statement {
    /**
     * Type of the new variable
     */
    private final Type type;
    /**
     * Value to initialize the variable with
     */
    private final Expression value;
    /**
     * name of the new variable
     */
    private final String name;
    private int depth;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param name name of the new variable
     * @param value initial value of the variable
     * @param type type of the new variable
     */
    public VariableDeclaration(Position position, String name,
                               Expression value, Type type) {
        super(position);
        this.name = name;
        this.value = value;
        this.type = type;
    }

    /**
     * Returns the type of the new variable.
     * @return type of the new variable
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns the initial value of the new variable.
     * @return initial value of the new variable
     */
    public Expression getValue() {
        return value;
    }

    /**
     * Returns the name of the new variable.
     * @return name of the new variable
     */
    public String getName() {
        return name;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(type.toString());
        sb.append(' ').append(name);
        if (value != null) {
            sb.append(" = ").append(value.toString());
        }
        sb.append(";\n");
        return sb.toString();
    }
}
