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
    private Type type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
        return variable.toString();
    }
}
