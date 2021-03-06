package ast;

/**
 * This class represents a parameter of a function.
 */
public class FunctionParameter {
    /**
     * parameter name
     */
    private final String name;
    /**
     * parameter type
     */
    private final Type type;

    /**
     * Constructor.
     *
     * @param name parameter name
     * @param type parameter type
     */
    public FunctionParameter(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Returns the parameter name.
     * @return parameter name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the parameter type.
     * @return parameter type
     */
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(type.toString());
        sb.append(' ').append(name);
        return sb.toString();
    }
}
