package ast;

import interpreter.ASTVisitor;

/**
 * This class represents an if-statement.
 */
public class Conditional extends Statement {
    /**
     * condition to be checked
     */
    private final Expression condition;
    /**
     * statement block execution if condition is evaluated to true
     */
    private final StatementBlock trueStatements;
    /**
     * statement block execution if condition is evaluated to false
     */
    private final StatementBlock falseStatements;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param condition condition to be checked
     * @param trueStatements statements executed if condition is true
     * @param falseStatements statements executed if condition is false
     */
    public Conditional(Position position, Expression condition,
                       StatementBlock trueStatements,
                       StatementBlock falseStatements) {
        super(position);
        this.condition = condition;
        this.trueStatements = trueStatements;
        this.falseStatements = falseStatements;
    }

    /**
     * Returns the condition of this if-statement
     * @return condition of this if-statement
     */
    public Expression getCondition() {
        return condition;
    }

    /**
     * Returns the block executed if condition is true
     * @return block executed if condition is true
     */
    public StatementBlock getTrueConditionBody() {
        return trueStatements;
    }

    /**
     * Returns the block executed if condition is false
     * @return block executed if condition is false
     */
    public StatementBlock getFalseConditionBody() {
        return falseStatements;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
