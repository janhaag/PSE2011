package ast;

/**
 *  This class encapsulates the minus (unary '-') operator
 *  in @see{ArithmeticExpressions}.
 */
public class UnaryMinus extends UnaryOperator implements ArithmeticOperator {
    @Override
    public String toString() {
        return "-";
    }
}
