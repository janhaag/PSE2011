package ast;

/**
 * This class encapsulates the or ('|') operator
 * in @see{LogicalExpressions}.
 */
public class Disjunction extends BinaryOperator implements LogicalOperator {
    @Override
    public String toString() {
        return "|";
    }
}
