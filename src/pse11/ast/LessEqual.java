package ast;

/**
 * This class encapsulates the 'less or equal' ('<=') operator
 * in @see{LogicalExpressions}.
 */
public class LessEqual extends BinaryOperator implements LogicalOperator {
    @Override
    public String toString() {
        return "<=";
    }
}
