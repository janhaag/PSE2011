package ast;

/**
 *  This class encapsulates the division ('/') operator
 *  in @see{ArithmeticExpressions}.
 */
public class Division extends BinaryOperator implements ArithmeticOperator {
    @Override
    public String toString() {
        return "/";
    }
}
