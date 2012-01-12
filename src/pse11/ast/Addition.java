package ast;

/**
 *  This class encapsulates the addition (binary '+') operator
 *  in @see{ArithmeticExpressions}.
 */
public class Addition extends BinaryOperator implements ArithmeticOperator {
    @Override
    public String toString() {
        return "+";
    }
}
