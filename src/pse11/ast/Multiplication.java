package ast;

/**
 *  This class encapsulates the multiplication ('*') operator
 *  in @see{ArithmeticExpressions}.
 */
public class Multiplication extends ArithmeticOperator {
    @Override
    public boolean isBinary() {
        return true;
    }
}
