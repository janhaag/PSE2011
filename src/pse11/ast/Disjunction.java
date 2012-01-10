package ast;

/**
 * This class encapsulates the or ('|') operator
 * in @see{LogicalExpressions}.
 */
public class Disjunction extends LogicalOperator {
    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public String toString() {
        return "|";
    }
}
