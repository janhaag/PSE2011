package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 *
 */
public class StatementBlock extends ASTRoot {
    private ArrayList<Statement>  statements;

    public StatementBlock(ArrayList<Statement> statements, Position position) {
        super(position);
        this.statements = statements;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public Statement getNextStatement() {
        return statements.get(0);
    }
}
