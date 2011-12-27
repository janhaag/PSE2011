package ast;

/**
 *
 */
public abstract class Expression extends Statement {
    protected Expression(Position position) {
        super(position);
    }
}
