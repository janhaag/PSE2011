package ast;

import interpreter.ASTVisitor;

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
    public Assertion(Position position, LogicalExpression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
