package ast;

import interpreter.ASTVisitor;

/**
 * This class symbolizes an axiom, i.e. a formula that is given as true
 * and therefore, it does not have to be proved.
 */
public class Axiom extends Specification {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param expression the expression that is given to be true
     */
    public Axiom(Position position, LogicalExpression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
