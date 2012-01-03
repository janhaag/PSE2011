package ast;

import interpreter.ASTVisitor;

/**
 * This class symbolizes a function call.
 */
public class FunctionCall extends Expression {
    /**
     * function parameters
     */
    private final Expression[] parameters;
    /**
     * function to be called
     */
    private final Identifier functionIdentifier;

    /**
     * Constructor.
     *
     * @param function function to be called
     * @param parameters array of function parameters
     * @param position indicates the position of this element
     *                 in the original source code
     */
    public FunctionCall(Identifier function, Expression[] parameters,
                           Position position) {
        super(position);
        this.parameters = parameters;
        this.functionIdentifier = function;

    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Returns the parameters of this function call.
     * @return function parameters
     */
    public Expression[] getParameters() {
        return parameters;
    }

    /**
     * Returns the identifier of the function to be called.
     * @return identifier of the function to be called
     */
    public Identifier getFunctionIdentifier() {
        return functionIdentifier;
    }
}
