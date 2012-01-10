package ast;

import java.util.Arrays;

/**
 * This class represents a function; it may be the main function.
 */
public class Function extends ASTRoot {
    /**
     * Function name. 'main' is reserved for main method.
     */
    private final String name;
    /**
     * the function body
     */
    private final StatementBlock functionBody;
    /**
     * list of function parameters
     */
    private final FunctionParameter[] parameters;
    /**
     * list of assumptions about parameter values
     */
    private final Assumption[] assumptions;
    /**
     * list of assurances for the value of variables
     */
    private final Ensure[] ensures;
    /**
     * type of return value. returnType is null iff this is the main function.
     */
    private final Type returnType;
    
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param returnType type of return value
     * @param name the function name
     * @param parameters the function parameters
     * @param functionBody the body of the function
     * @param assumptions list of assumptions for this functions
     * @param ensures list of assurances for this functions
     */
    public Function(Position position, Type returnType, String name,
                    FunctionParameter[] parameters,
                    StatementBlock functionBody,
                    Assumption[] assumptions,
                    Ensure[] ensures) {
        super(position);
        this.returnType = returnType;
        this.name = name;
        this.functionBody = functionBody;
        this.parameters = parameters;
        this.assumptions = assumptions;
        this.ensures = ensures;
    }

    /**
     * Returns the name of the function.
     * @return function name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the function body.
     * @return function body
     */
    public StatementBlock getFunctionBlock() {
        return functionBody;
    }

    /**
     * Returns the list of parameters.
     * @return list of parameters
     */
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    /**
     * Returns the type of the function
     * @return function type
     */
    public Type getReturnType() {
        return returnType;
    }

    /**
     * Returns the list of assumptions.
     * @return list of assumptions
     */
    public Assumption[] getAssumptions() {
        return assumptions;
    }

    /**
     * Returns the list of assurances.
     * @return list of assurances
     */
    public Ensure[] getEnsures() {
        return ensures;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        if (returnType != null) {
            sb.append(returnType).append(' ');
        }
        sb.append(name).append('(');
        if (parameters.length != 0) {
            sb.append(parameters[0]);
        }
        for (int i = 1; i < parameters.length; i++) {
            sb.append(", ").append(parameters[i]);
        }
        sb.append(") {\n");
        for (Assumption assumption : assumptions) {
            sb.append(assumption);
        }
        sb.append(functionBody);
        for (Ensure ensure : ensures) {
            sb.append(ensure);
        }
        return sb.append('}').toString();
    }
}