package ast;

import interpreter.ASTVisitor;

/**
 * This class represents a while-statement.
 */
public class Loop extends Statement {
    /**
     * condition to be checked
     */
    private LogicalExpression condition;
    /**
     * statement block executed while condition holds true
     */
    private StatementBlock body;
    /**
     * list of loop invariants
     */
    private Invariant[] invariants;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param condition condition to be checked
     * @param body loop body
     * @param invariants list of loop invariants
     */
    public Loop(Position position, LogicalExpression condition,
                StatementBlock body, Invariant[] invariants) {
        super(position);
        this.condition = condition;
        this.body = body;
        this.invariants = invariants;
    }

    /**
     * Returns the list of loop invariants.
     * @return loop invariants
     */
    public Invariant[] getInvariants() {
        return invariants;
    }

    /**
     * Returns the loop condition.
     * @return loop condition
     */
    public LogicalExpression getCondition() {
        return condition;
    }

    /**
     * Returns the loop body.
     * @return loop body
     */
    public StatementBlock getLoopBody() {
        return body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
