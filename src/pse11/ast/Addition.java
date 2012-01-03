package ast;

/**
 *  This class encapsulates the addition (binary '+') operator
 *  in @see{ArithmeticExpressions}.
 */
public class Addition extends ArithmeticOperator {
    @Override
    public boolean isBinary() {
        return true;
    }
}
