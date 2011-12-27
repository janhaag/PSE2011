package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class Conditional extends Statement {
    private LogicalExpression condition;
    private StatementBlock trueStatements;
    private StatementBlock falseStatements;

    public Conditional(Position position, LogicalExpression condition,
                       StatementBlock trueStatements, StatementBlock falseStatements) {
        super(position);
        this.condition = condition;
        this.trueStatements = trueStatements;
        this.falseStatements = falseStatements;
    }

    public LogicalExpression getCondition() {
        return condition;
    }

    public StatementBlock getTrueConditionBody() {
        return trueStatements;
    }

    public StatementBlock getFalseConditionBody() {
        return falseStatements;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
