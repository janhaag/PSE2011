/**
 * A range for bounded quantifiers.
 */
public class Range {
    /**
     * the lower bound for the quantifier.
     */
    private ArithmeticExpression lower;

    /**
     * the upper bound for the quantifier.
     */
    private ArithmeticExpression upper;

    /**
     * Create a new Range.
     * @param lowerBound the lower bound for the quantifier
     * @param upperBound the upper bound for the quantifier
     */
    public Range(ArithmeticExpression lowerBound,
                 ArithmeticExpression upperBound) {
        lower = lowerBound;
        upper = upperBound;
    }

    /**
     * Get the lower bound of this range.
     * @return the lower bound
     */
    public ArithmeticExpression getLowerBound() {
        return lower;
    }

    /**
     * Get the upper bound of this range.
     * @return the upper bound
     */
    public ArithmeticExpression getUpperBound() {
        return upper;
    }
