package interpreter;

import ast.BooleanType;

/**
 * This class represents a value of boolean type.
 */
public class BooleanValue extends Value {
    /**
     * value this instance represents
     */
    private boolean value;

    /**
     * Constructor.
     * If value == null, the default value is false.
     *
     * @param value value this instance represents (as String)
     */
    public BooleanValue(String value) {
        super(new BooleanType());
        this.value = ("true".equals(value));
    }

    /**
     * Returns the value this instance represents.
     * @return value this instance represents
     */
    public boolean getValue() {
        return value;
    }

    /**
     * Changes the value of this instance.
     * @param value new value (as String)
     */
    public void setValue(String value) {
        this.value = ("true".equals(value));
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return value == ((BooleanValue) o).value;
    }
}
