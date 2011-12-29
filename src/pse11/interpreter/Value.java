package interpreter;

import ast.Type;

/**
 *
 */
public abstract class Value {
    private Type type;

    protected Value(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
