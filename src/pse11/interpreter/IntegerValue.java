package interpreter;

import ast.IntegerType;

import java.math.BigInteger;

/**
 * This class represents a value of integer type.
 */
public class IntegerValue extends Value {
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
        this.value = (value == null) ? BigInteger.ZERO : new BigInteger(value);
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
        this.value = (value == null) ? BigInteger.ZERO : new BigInteger(value);
    }
}
