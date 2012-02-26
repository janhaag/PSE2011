package interpreter;

import ast.IntegerType;

import java.math.BigInteger;
import java.util.regex.Pattern;

/**
 * This class represents a value of integer type.
 */
public class IntegerValue extends Value {
    /**
     * pattern that indicates that a number is valid
     */
    private static final Pattern NUMBER = Pattern.compile("-?\\d+");
    /**
     * value this instance represents
     */
    private BigInteger value;

    /**
     * Constructor.
     * If value == null, the default value is BigInteger.ZERO.
     *
     * @param value value this instance represents (as String)
     */
    public IntegerValue(String value) {
        super(new IntegerType());
        setValue(value);
    }

    /**
     * Returns the value this instance represents.
     * @return value this instance represents
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Changes the value of this instance.
     * @param value new value (as String)
     */
    public void setValue(String value) {
       this.value = (value == null || !NUMBER.matcher(value).matches())
                ? BigInteger.ZERO : new BigInteger(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return value.equals(((IntegerValue) o).value);
    }
}
