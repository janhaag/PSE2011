package ast;

/**
 *  This class is an abstract class used as the operator
 *  of an @see{ArithmeticExpression}.
 *  The different operators are symbolized by the different subclasses.
 */
public abstract class ArithmeticOperator {
    /**
     * Returns whether this operator symbolizes a binary
     * or a unary operator.
     * @return true if this operator is binary, false if it is unary
     */
    public abstract boolean isBinary();
}
