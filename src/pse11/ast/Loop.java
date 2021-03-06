package ast;

/**
 * This class represents a while-statement.
 */
public class Loop extends Statement {
    /**
     * condition to be checked
     */
    private final Expression condition;
    /**
     * statement block executed while condition holds true
     */
    private final StatementBlock body;
    /**
     * list of loop invariants
     */
    private final Invariant[] invariants;
    /**
     * List of postconditions.
     */
    private final Ensure[] postconditions;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param condition condition to be checked
     * @param body loop body
     * @param invariants list of loop invariants
     * @param postconditions list of post-conditions
     */
    public Loop(Position position, Expression condition,
                StatementBlock body, Invariant[] invariants,
                Ensure[] postconditions) {
        super(position);
        this.condition = condition;
        this.body = body;
        this.invariants = invariants;
        this.postconditions = postconditions;
    }

    /**
     * Returns the list of loop invariants.
     * @return loop invariants
     */
    public Invariant[] getInvariants() {
        return invariants;
    }

    /**
     * Returns the list of postconditions.
     * @return the postconditions
     */
    public Ensure[] getPostconditions() {
        return postconditions;
    }


    /**
     * Returns the loop condition.
     * @return loop condition
     */
    public Expression getCondition() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("while (");
        sb.append(condition).append(")\n");
        for (Invariant invariant : invariants) {
            sb.append(invariant);
        }
        sb.append("{\n").append(body);
        sb.append("}\n");
        for (Ensure ensure : postconditions) {
            sb.append(ensure);
        }
        return sb.toString();
    }
}
