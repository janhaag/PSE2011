package Verifier;


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
     * Its operants.
     */
    private S_Expression[] subexpressions;
    /**
     * Constructor
     * @param op The operator.
     * @param subexpressions The operants.
     */
    public S_Expression(String op, S_Expression[] subexpressions) {
        this.op = op;
        this.subexpressions = subexpressions;
    }
/**
 * To String method.
 * @return Operator and operants in brackets.
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
