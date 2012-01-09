package ast;

/**
 * A range for bounded quantifiers.
 */
public class Range {
    /**
     * the lower bound for the quantifier.
     */
    private final Expression lower;

    /**
     * the upper bound for the quantifier.
     */
    private final Expression upper;

    /**
     * Create a new Range.
     * @param lowerBound the lower bound for the quantifier
     * @param upperBound the upper bound for the quantifier
     */
    public Range(Expression lowerBound, Expression upperBound) {
        lower = lowerBound;
        upper = upperBound;
    }

    /**
     * Get the lower bound of this range.
     * @return the lower bound
     */
    public Expression getLowerBound() {
        return lower;
    }

    /**
     * Get the upper bound of this range.
     * @return the upper bound
     */
    public Expression getUpperBound() {
        return upper;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(lower.toString());
        sb.append(", ").append(upper);
        return sb.toString();
    }
}
