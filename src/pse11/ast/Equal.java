package ast;

/**
 * This class encapsulates the equal ('==') operator
 * in @see{LogicalExpressions}.
 */
public class Equal extends LogicalOperator {
    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public String toString() {
        return "==";
    }
}
