package interpreter;

import ast.IntegerType;

import java.math.BigInteger;

/**
 *
 */
public class IntegerValue extends Value {
    private BigInteger value;
    
    public IntegerValue(String value) {
        super(new IntegerType());
        this.value = (value == null) ? BigInteger.ZERO : new BigInteger(value);
    }

    public BigInteger getValue() {
        return value;
    }
}
