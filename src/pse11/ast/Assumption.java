package ast;

import interpreter.ASTVisitor;

/**
 * This class symbolizes an assumption at the beginning of a method,
 * i.e. it indicates that a method only has to be correct
 * if the formula holds.
 */
public class Assumption extends Specification {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param expression expression that is evaluated to see whether the method
     *                   has to be correct
     */
    public Assumption(Position position, LogicalExpression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
