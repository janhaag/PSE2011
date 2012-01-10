package ast;

/**
 * This class is superclass to different types of specifications.
 * Specifications are given by the user to check the correctness
 * of their program.
 */
public abstract class Specification extends Statement {
    /**
     * expression to be evaluated
     */
    private final Expression expression;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param expression expression to be evaluated
     */
    protected Specification(Position position, Expression expression) {
        super(position);
        this.expression = expression;
    }

    /**
     * Returns the expression belonging to this specification.
     * @return expression belonging to this specification
     */
    public Expression getExpression() {
        return expression;
    }
}
