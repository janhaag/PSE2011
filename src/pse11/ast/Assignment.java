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
    private int depth;

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

    public String toString() {
        StringBuilder sb = new StringBuilder(identifier.toString());
        sb.append(" = ").append(value.toString());
        sb.append(";\n");
        return sb.toString();
    }
}
