package ast;

import interpreter.ASTVisitor;

/**
 *
 */
public class ArithmeticExpression extends Expression {
    private Expression subexpression1;
    private Expression subexpression2;
    private ArithmeticOperator arithmeticOperator;

    public ArithmeticExpression(Position position, Expression subexpression1,
                                Expression subexpression2, ArithmeticOperator arithmeticOperator) {
        super(position);
        this.subexpression1 = subexpression1;
        this.subexpression2 = subexpression2;
        this.arithmeticOperator = arithmeticOperator;
    }

    public Expression getSubexpression1() {
        return subexpression1;
    }

    public Expression getSubexpression2() {
        return subexpression2;
    }

    public ArithmeticOperator getArithmeticOperator() {
        return arithmeticOperator;
    }

    @Override
    public void accept(ASTVisitor visitor) {
    }
}
