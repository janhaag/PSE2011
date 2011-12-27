package ast;

/**
 * This class encapsulates the less ('<') operator
 * in @see{LogicalExpressions}.
 */
public class Less extends LogicalOperator {
    @Override
    public boolean isBinary() {
        return true;
    }
}
