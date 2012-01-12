package ast;

/**
 * This class encapsulates the and ('&') operator
 * in @see{LogicalExpressions}.
 */
public class Conjunction extends BinaryOperator implements LogicalOperator {
    @Override
    public String toString() {
        return "&";
    }
}
