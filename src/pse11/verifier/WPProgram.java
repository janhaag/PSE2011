package verifier;

/**
 * This class represents the Program for the theorem prover.
 * It consists of an S-Expression.
 */
public class WPProgram {
    /**
     * The S-Expression.
     */
    private S_Expression[] expressions;
    /**
     * Constructor.
     * @param expression The S-Expression
     */
    public WPProgram(S_Expression[] expressions) {
        this.expressions = expressions;
    }
    /**
     * To String Method.
     * @see S_Expression#toString()
     * @return the String of the S-Expression.
     */
    @Override
    public String toString() {
       StringBuilder output = new StringBuilder();
       for(int i = 0; i < expressions.length; i++) {
           output.append(expressions[i].toString());
       }
       return output.toString();
    }
}
