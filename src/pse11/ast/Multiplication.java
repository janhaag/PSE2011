package ast;

/**
 *  This class encapsulates the multiplication ('*') operator
 *  in @see{ArithmeticExpressions}.
 */
public class Multiplication extends BinaryOperator
        implements ArithmeticOperator {
    @Override
    public String toString() {
        return "*";
    }
}
