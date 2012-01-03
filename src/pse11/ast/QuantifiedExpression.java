package ast;

/**
 * This class represents a quantified expression
 * (i.e. a formula with a quantifier).
 * It contains either a quantified expression itself or
 * a quantifier-free logical expression.
 */
public abstract class QuantifiedExpression extends Expression {
    /**
     * The range of this quantifier (null if unbounded)
     */
    private Range range;

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
     * @param range The range for bounded quantification
     *              (null if this quantifier is unbounded)
     * @param identifier identifier that is varied in the formula
     * @param subexpression quantified subexpression to be satisfied
     *                      (if not null)
     * @param expression quantifier-free expression to be satisfied
     *                   (if not null)
     */
    public QuantifiedExpression(Position position, Identifier identifier,
                                Range range,
                                QuantifiedExpression subexpression,
                                LogicalExpression expression) {
        super(position);
        if (!(expression == null ^ subexpression == null)) {
            throw new IllegalArgumentException(
                    "Either expresion or subexpressuion must be null."
            );
        }
        this.identifier = identifier;
        this.range = range;
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

    /**
     * Get the range for this quantifier.
     * @return the range
     */
    public Range getRange() {
        return range;
    }
}
