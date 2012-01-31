package verifier.smtlib;

/**
 * This class represents the Program for the theorem prover.
 * It consists of S-Expressions.
 */
public class WPProgram {
    /**
     * The S-Expression.
     */
    private final S_Expression[] expressions;
    /**
     * Constructor.
     * @param expressions The S-Expression
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
       StringBuilder output = new StringBuilder("");
       for (int i = 0; i < expressions.length; i++) {
           output.append(expressions[i].toString());
       }
       return output.toString();
    }
}
