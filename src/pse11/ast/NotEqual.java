package ast;

/**
 * This class encapsulates the 'not equal' ('!=') operator
 * in @see{LogicalExpressions}.
 */
public class NotEqual extends BinaryOperator implements LogicalOperator {
    @Override
    public String toString() {
        return "!=";
    }
}
