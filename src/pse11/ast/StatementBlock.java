package ast;

import interpreter.ASTVisitor;

/**
 * This class symbolizes a statement block in a user program.
 * This is an ordered list of statements with its own scope.
 */
public class StatementBlock extends ASTRoot {
    /**
     * The list of statements this block contains
     */
    private final Statement[]  statements;
    /**
     * Indicates the number of the next statement.
     */
    private int noOfNextStatement;
    
    /**
     * Constructor.
     * 
     * @param statements statements this block contains
     * @param position indicates the position of this element
     *                 in the original source code
     */
    public StatementBlock(Statement[] statements, Position position) {
        super(position);
        this.statements = statements;
        noOfNextStatement = 0;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Returns the next statement of this statement block.
     * @return next statement of this statement block
     */
    public Statement getNextStatement() {
        if (noOfNextStatement >= statements.length) {
            noOfNextStatement = 0;
            return null;
        }
        Statement returnedStatement = statements[noOfNextStatement];
        noOfNextStatement += 1;
        return returnedStatement;
    }
}
