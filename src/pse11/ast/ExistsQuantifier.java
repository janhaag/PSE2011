package ast;

/**
 * This class symbolizes a quantified expression with an exists quantifier,
 * so that there must be a value to satisfy the expression.
 */
public class ExistsQuantifier extends QuantifiedExpression {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param range the range for bounded quantification
     * @param identifier identifier that is varied in the formula
     * @param subexpression subexpression to be satisfied
     */
    public ExistsQuantifier(Position position, Range range,
                            Identifier identifier,
                            Expression subexpression) {
        super(position, range, identifier, subexpression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(exists ");
        sb.append(getIdentifier()).append('(');
        if (getRange() != null) {
            sb.append(getRange());
        }
        sb.append(") ").append(getSubexpression1());
        return sb.append(')').toString();
    }
}
