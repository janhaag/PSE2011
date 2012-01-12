package ast;

/**
 * This class encapsulates the negation (unary '!') operator
 * in @see{LogicalExpressions}.
 */
public class Negation extends UnaryOperator implements LogicalOperator {
    @Override
    public String toString() {
        return "!";
    }
}
