package ast;

/**
 *
 */
public class NotEqual extends LogicalOperator {
    @Override
    public boolean isBinary() {
        return true;
    }
}
