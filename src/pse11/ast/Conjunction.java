package ast;

/**
 * This class encapsulates the and ('&') operator
 * in @see{LogicalExpressions}.
 */
public class Conjunction extends LogicalOperator {
    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public String toString() {
        return "&";
    }
}
