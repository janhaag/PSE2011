package verifier.smtlib;


import java.util.LinkedList;

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
    public S_Expression(String op, S_Expression... subexpressions) {
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
            output.append(' ').append(subexpressions[i].toString());
        }
        output.append(")");
        return output.toString();
    }

    public S_Expression deepCopy() {
        S_Expression[] newSubExpressions
                = new S_Expression[subexpressions.length];
        for (int i = 0; i < subexpressions.length; i++) {
            newSubExpressions[i] = subexpressions[i].deepCopy();
        }
        return new S_Expression(op, newSubExpressions);
    }

    public void replace(VarDef varDef, S_Expression newValue) {
        if (subexpressions == null) {
            return;
        }
        for (int i = 0; i < subexpressions.length; i++) {
            if (subexpressions[i] instanceof VarDef) {
                if (subexpressions[i].equals(varDef)) {
                    subexpressions[i] = newValue.deepCopy();
                }
            } else if (!(subexpressions[i] instanceof Constant)) {
                subexpressions[i].replace(varDef, newValue);
            }
        }
    }

    public LinkedList<String> getUndefinedVars() {
        LinkedList<String> result = new LinkedList<String>();
        addVars(result);
        return result;
    }

    public void addVars(LinkedList<String> varList) {
        if (subexpressions != null) {
            for (S_Expression expression : subexpressions) {
                expression.addVars(varList);
            }
        }
    }
}
