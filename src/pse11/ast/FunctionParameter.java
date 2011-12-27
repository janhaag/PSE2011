package ast;

/**
 *
 */
public class FunctionParameter {
    private String name;
    private Type type;

    public FunctionParameter(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
