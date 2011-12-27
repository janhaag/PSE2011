package ast;

/**
 *
 */
public class UnaryPlus extends ArithmeticOperator {
    @Override
    public boolean isBinary() {
        return false;
    }
}
