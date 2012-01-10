package ast;

/**
 * This class symbolizes a return statement.
 */
public class ReturnStatement extends Statement {
    /**
     * value to be returned
     */
    private final Expression returnValue;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param returnValue value to be returned
     */
    public ReturnStatement(Position position, Expression returnValue) {
        super(position);
        this.returnValue = returnValue;
    }

    /**
     * Returns the value that is returned.
     * @return return value
     */
    public Expression getReturnValue() {
        return returnValue;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("return ");
        sb.append(returnValue.toString());
        sb.append(";\n");
        return sb.toString();
    }
}
