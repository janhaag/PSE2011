package ast;

import interpreter.ASTVisitor;

/**
 * This class symbolizes an assignment of a value to a variable.
 * For assignments to arrays there is a subclass @see{ArrayAssignment}.
 */
public class Assignment extends Statement {
    /**
     * value that should be assigned to the variable
     */
    private Expression value;
    /**
     * name of the variable
     */
    private Identifier identifier;

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

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
