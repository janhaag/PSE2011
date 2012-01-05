package ast;

import interpreter.ASTVisitor;

/**
 * This class symbolizes an invariant, i.e. a condition that stays
 * true during different loop cycles.
 */
public class Invariant extends Specification {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param expression expression that must hold true
     */
    public Invariant(Position position, Expression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
