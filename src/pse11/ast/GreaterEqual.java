package ast;

/**
 * This class encapsulates the 'greater or equal' ('>=') operator
 * in @see{LogicalExpressions}.
 */
public class GreaterEqual extends LogicalOperator {
    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public String toString() {
        return ">=";
    }
}
