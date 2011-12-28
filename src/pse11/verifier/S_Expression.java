package verifier;


/**
 * This class represents a S-Expression.
 * It is identified by its operator.
 */
public class S_Expression {
    /**
     * Its operator,e.g. "+" or "-".
     */
    private String op;
    /**
     * Its operands.
     */
    private S_Expression[] subexpressions;
    /**
     * Constructor
     * @param op The operator.
     * @param subexpressions The operands.
     */
    public S_Expression(String op, S_Expression[] subexpressions) {
        this.op = op;
        this.subexpressions = subexpressions;
    }
/**
 * To String method.
 * @return Operator and operands in brackets.
 */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("(" + op);
        for (int i = 0; i < subexpressions.length; i++) {
            output.append(subexpressions[i].toString());
        }
        output.append(")");
        return output.toString();
    }


}
