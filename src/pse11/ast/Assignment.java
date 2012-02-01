package ast;

/**
 * This class symbolizes an assignment of a value to a variable.
 * For assignments to arrays there is a subclass @see{ArrayAssignment}.
 */
public class Assignment extends Statement {
    /**
     * value that should be assigned to the variable
     */
    private final Expression value;
    /**
     * name of the variable
     */
    private final Identifier identifier;
    /**
     * depth of declaration of this variable
     */
    private int depth;
    /**
     * type of this variable
     */
    private Type type;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param value the value to be assigned
     * @param identifier the variable to be assigned to
     */
    public Assignment(Position position, Expression value,
                      Identifier identifier) {
        super(position);
        this.value = value;
        this.identifier = identifier;
        depth = 0;
    }

    /**
     * Returns the expression that is assigned to the variable
     * @return expression that is assigned to the variable
     */
    public Expression getValue() {
        return value;
    }

    /**
     * Returns the identifier that the value is assigned to
     * @return identifier that the value is assigned to
     */
    public Identifier getIdentifier() {
        return identifier;
    }

    /**
     * Returns the depth of the scope in which
     * the variable assigned to was declared.
     * @return depth of declaration of this variable
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Sets the depth of the scope in which
     * the variable assigned to was declared.
     * @param depth depth of declaration of this variable
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Returns the type of this variable.
     * @return type of this variable
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the type of this variable
     * @param type type of this variable
     */
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(identifier.toString());
        sb.append(" = ").append(value.toString());
        sb.append(";\n");
        return sb.toString();
    }
}
