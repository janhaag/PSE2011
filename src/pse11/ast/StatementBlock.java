package ast;

import java.util.Arrays;
import java.util.Iterator;

/**
 * This class symbolizes a statement block in a user program.
 * This is an ordered list of statements with its own scope.
 */
public class StatementBlock extends ASTRoot {
    /**
     * The list of statements this block contains
     */
    private final Statement[] statements;
    
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
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Returns the next statement of this statement block.
     * @return next statement of this statement block
     */

    public Iterator<Statement> getIterator() {
        return Arrays.asList(statements).iterator();
    }

    /**
     * Returns the statements in this block.
     * @return statements in this block
     */
    public Statement[] getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Statement statement : statements) {
            sb.append(statement);
        }
        return sb.toString();
    }
}
