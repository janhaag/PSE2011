package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 *
 */
public class Loop extends Statement {
    private LogicalExpression condition;
    private StatementBlock body;
    private ArrayList<Invariant> invariants;

    public Loop(Position position, LogicalExpression condition,
                StatementBlock body, ArrayList<Invariant> invariants) {
        super(position);
        this.condition = condition;
        this.body = body;
        this.invariants = invariants;
    }

    public ArrayList<Invariant> getInvariants() {
        return invariants;
    }

    public LogicalExpression getCondition() {
        return condition;
    }

    public StatementBlock getLoopBody() {
        return body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
