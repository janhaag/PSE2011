package ast;

/**
 *  This class encapsulates the division ('/') operator
 *  in @see{ArithmeticExpressions}.
 */
public class Division extends ArithmeticOperator {
    @Override
    public boolean isBinary() {
        return true;
    }
}
