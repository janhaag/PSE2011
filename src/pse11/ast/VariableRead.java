package ast;

/**
 * This class symbolizes a reading access to a variable.
 * For reading access from arrays there is a subclass @see{ArrayRead}.
 */
public class VariableRead extends Expression {
    /**
     * identifier belonging to the variable to be read
     */
    private final Identifier variable;
    /**
     * variable type
     */
    private Type type;
    /**
     * depth of the declaration of this variable
     */
    private int depth;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param variable identifier to be read from
     */
    public VariableRead(Position position, Identifier variable) {
        super(position);
        this.variable = variable;
    }

    /**
     * Returns the identifier belonging to the variable to be read.
     * @return identifier to be read from
     */
    public Identifier getVariable() {
        return variable;
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

    public String toString() {
        return variable.toString();
    }
}
