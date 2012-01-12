package ast;

/**
 * This class encapsulates the less ('<') operator
 * in @see{LogicalExpressions}.
 */
public class Less extends BinaryOperator implements LogicalOperator {
    @Override
    public String toString() {
        return "<";
    }
}
