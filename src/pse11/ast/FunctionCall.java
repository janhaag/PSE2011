package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 *
 */
public class FunctionCall extends Expression {
    private ArrayList<Expression> parameters;
    private Function function;
    
    protected FunctionCall(Function function, ArrayList<Expression> parameters, Position position) {
        super(position);
        this.parameters = parameters;
        this.function = function;

    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public ArrayList<Expression> getParameters() {
        return parameters;
    }

    public Function getFunction() {
        return function;
    }
}
