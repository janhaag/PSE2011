package ast;

/**
 * This class represents a quantified expression
 * (i.e. a formula with a quantifier).
 * It contains either a quantified expression itself or
 * a quantifier-free logical expression.
 */
public abstract class QuantifiedExpression extends Expression {
    /**
     * quantified subexpression to be satisfied (if not null)
     */
    QuantifiedExpression subexpression;
    /**
     * quantifier-free expression to be satisfied (if not null)
     */
    LogicalExpression expression;
    /**
     * identifier that is varied in the quantified expression
     */
    private Identifier identifier;

    /**
     * Constructor.
     * Either parameter subexpression or expression has to be null.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param identifier identifier that is varied in the formula
     * @param subexpression quantified subexpression to be satisfied
     *                      (if not null)
     * @param expression quantifier-free expression to be satisfied
     *                   (if not null)
     */
    public QuantifiedExpression(Position position, Identifier identifier,
                                QuantifiedExpression subexpression,
                                LogicalExpression expression) {
        super(position);
        this.identifier = identifier;
        this.subexpression = subexpression;
        this.expression = expression;
    }

    /**
     * Returns the quantified subexpression.
     * @return quantified subexpression
     */
    public QuantifiedExpression getSubexpression() {
        return subexpression;
    }

    /**
     * Returns the quantifier-free subexpression.
     * @return quantifier-free subexpression
     */
    public LogicalExpression getExpression() {
        return expression;
    }

    /**
     * Returns the identifier that is varied in the formula.
     * @return identifier that is varied in the formula
     */
    public Identifier getIdentifier() {
        return identifier;
    }
}