package ast;

/**
 * This class encapsulates the 'not equal' ('!=') operator
 * in @see{LogicalExpressions}.
 */
public class NotEqual extends LogicalOperator {
    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public String toString() {
        return "!=";
    }
}
