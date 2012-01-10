package interpreter;

import ast.Type;

/**
 * This class is a superclass of all classes that represent
 * values in the user program
 */
public abstract class Value {
    /**
     * type of this value
     */
    private final Type type;

    /**
     * Constructor.
     *
     * @param type type of this value
     */
    protected Value(Type type) {
        this.type = type;
    }

    /**
     * Returns the type of this value.
     * @return type of this value
     */
    public Type getType() {
        return type;
    }
}
