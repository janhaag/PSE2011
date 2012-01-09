package ast;

/**
 * This class symbolizes an assertion, i.e. a condition that the
 * user specifies and that must hold during execution of this statement.
 */
public class Assertion extends Specification {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param expression expression that must be true for the assertion
     *                   to be correct
     */
    public Assertion(Position position, Expression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("assert ");
        sb.append(getExpression().toString());
        sb.append(";\n");
        return sb.toString();
    }
}
