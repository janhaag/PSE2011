package ast;

/**
 *  This class encapsulates the plus (unary '+') operator
 *  in @see{ArithmeticExpressions}.
 */
public class UnaryPlus extends ArithmeticOperator {
    @Override
    public boolean isBinary() {
        return false;
    }
}
