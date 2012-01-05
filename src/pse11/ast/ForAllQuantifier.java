package ast;

import interpreter.ASTVisitor;

/**
 * This class symbolizes a quantified expression with an exists quantifier,
 * so that all values must satisfy the expression.
 */
public class ForAllQuantifier extends QuantifiedExpression {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param range the range for bounded quantification
     * @param identifier identifier that is varied in the formula
     * @param subexpression subexpression to be satisfied
     */
    public ForAllQuantifier(Position position, Range range,
                            Identifier identifier,
                            Expression subexpression) {
        super(position, range, identifier, subexpression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
