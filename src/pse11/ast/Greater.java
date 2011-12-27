package ast;

/**
 * This class encapsulates the greater ('>') operator
 * in @see{LogicalExpressions}.
 */
public class Greater extends LogicalOperator {
    @Override
    public boolean isBinary() {
        return true;
    }
}
