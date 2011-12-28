package verifier;

/**
 * This class represents the Program for the theorem prover.
 * It consists of an S-Expression.
 */
public class WPProgram {
    /**
     * The S-Expression.
     */
    private S_Expression expression;
    /**
     * Constructor.
     * @param expression The S-Expression
     */
    public WPProgram(S_Expression expression) {
        this.expression = expression;
    }
    /**
     * To String Method.
     * @see S_Expression#toString()
     * @return the String of the S-Expression.
     */
    @Override
    public String toString() {
       return expression.toString();
    }
}
