package interpreter;

import ast.BooleanType;

/**
 *
 */
public class BooleanValue extends Value {
    private boolean value;
    
    public BooleanValue(String value) {
        super(new BooleanType());
        this.value = ("true".equals(value));
    }

    public boolean getValue() {
        return value;
    }
}
