package ast;

/**
 * This class encapsulates the greater ('>') operator
 * in @see{LogicalExpressions}.
 */
public class Greater extends BinaryOperator implements LogicalOperator {
    @Override
    public String toString() {
        return ">";
    }
}
