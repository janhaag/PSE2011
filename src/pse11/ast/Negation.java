package ast;

/**
 * This class encapsulates the negation (unary '!') operator
 * in @see{LogicalExpressions}.
 */
public class Negation extends LogicalOperator {
    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public String toString() {
        return "!";
    }
}
