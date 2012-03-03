package ast;

/**
 * This class represents a quantified expression
 * (i.e. a formula with a quantifier).
 * It contains either a quantified expression itself or
 * a quantifier-free logical expression.
 */
public abstract class QuantifiedExpression extends LogicalExpression {
    /**
     * The range of this quantifier (null if unbounded)
     */
    private final Range range;
    /**
     * identifier that is varied in the quantified expression
     */
    private final Identifier identifier;
    private int depth;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param identifier identifier that is varied in the formula
     * @param range The range for bounded quantification
     *              (null if this quantifier is unbounded)
     * @param subexpression subexpression to be satisfied
     */
    protected QuantifiedExpression(Position position, Range range,
                                Identifier identifier,
                                Expression subexpression) {
        super(position, subexpression, null, null);
        this.identifier = identifier;
        this.range = range;
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

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
