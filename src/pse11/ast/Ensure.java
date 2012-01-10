package ast;

/**
 * This class symbolizes an assurance, i.e. a formula that must hold
 * after execution of a method
 */
public class Ensure extends Specification {
    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param expression formula that must hold
     */
    public Ensure(Position position, Expression expression) {
        super(position, expression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ensure ");
        sb.append(getExpression().toString());
        sb.append(";\n");
        return sb.toString();
    }
}
