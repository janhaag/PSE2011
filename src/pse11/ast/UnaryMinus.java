package ast;

/**
 *
 */
public class UnaryMinus extends ArithmeticOperator {
    @Override
    public boolean isBinary() {
        return false;
    }
}
