package ast;

/**
 *  This class encapsulates the subtraction (binary '-') operator
 *  in @see{ArithmeticExpressions}.
 */
public class Subtraction extends BinaryOperator implements ArithmeticOperator {
    @Override
    public String toString() {
        return "-";
    }
}
