package ast;

/**
 * This class encapsulates the equal ('==') operator
 * in @see{LogicalExpressions}.
 */
public class Equal extends BinaryOperator implements LogicalOperator {
    @Override
    public String toString() {
        return "==";
    }
}
