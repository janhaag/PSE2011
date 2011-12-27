package ast;

/**
 * This class encapsulates the 'less or equal' ('<=') operator
 * in @see{LogicalExpressions}.
 */
public class LessEqual extends LogicalOperator {
    @Override
    public boolean isBinary() {
        return true;
    }
}
