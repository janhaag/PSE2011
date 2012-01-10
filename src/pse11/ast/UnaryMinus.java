package ast;

/**
 *  This class encapsulates the minus (unary '-') operator
 *  in @see{ArithmeticExpressions}.
 */
public class UnaryMinus extends ArithmeticOperator {
    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public String toString() {
        return "-";
    }
}
