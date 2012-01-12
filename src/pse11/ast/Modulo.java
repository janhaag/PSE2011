package ast;

/**
 *  This class encapsulates the modulo ('%') operator
 *  in @see{ArithmeticExpressions}.
 *  It is used to calculate the remainder of a division.
 */
public class Modulo extends BinaryOperator implements ArithmeticOperator {
    @Override
    public String toString() {
        return "%";
    }
}
