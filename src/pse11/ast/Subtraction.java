package ast;

/**
 *  This class encapsulates the subtraction (binary '-') operator in @see{ArithmeticExpressions}.
 */
public class Subtraction extends ArithmeticOperator {
    @Override
    public boolean isBinary() {
        return true;
    }
}
