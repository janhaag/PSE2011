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
     * @param subexpression quantified subexpression to be satisfied
     *                      (if not null)
     * @param expression quantifier-free expression to be satisfied
     *                   (if not null)
     */
    public ForAllQuantifier(Position position, Range range,
                            Identifier identifier,
                            QuantifiedExpression subexpression,
                            LogicalExpression expression) {
        super(position, range, identifier, subexpression, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
