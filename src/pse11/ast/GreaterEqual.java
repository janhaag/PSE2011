package ast;

/**
 * This class encapsulates the 'greater or equal' ('>=') operator
 * in @see{LogicalExpressions}.
 */
public class GreaterEqual extends BinaryOperator implements LogicalOperator {
    @Override
    public String toString() {
        return ">=";
    }
}
