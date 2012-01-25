package interpreter;

import ast.ArrayType;
import ast.BooleanType;
import ast.IntegerType;
import ast.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a value of array type,
 * i.e. a collection of other values that share the same type.
 */
public class ArrayValue extends Value {
    /**
     * values this array saves
     */
    private final Value[] values;

    /**
     * Constructor.
     *
     * @param type base type of the array
     * @param lengths length of the different array dimensions
     * @param pos array dimension that is currently constructed
     */
    public ArrayValue(ArrayType type, int[] lengths, int pos) {
        super(type);
        Type baseType = type.getType();
        int length = lengths[pos];
        values = new Value[length];
        if (baseType instanceof ArrayType) {
            for (int i = 0; i < length; i++) {
                values[i] = new ArrayValue((ArrayType) baseType,
                                            lengths, pos + 1);
            }
        }
        if (baseType instanceof BooleanType) {
            for (int i = 0; i < length; i++) {
                values[i] = new BooleanValue(null);
            }
        }
        if (baseType instanceof IntegerType) {
            for (int i = 0; i < length; i++) {
                values[i] = new IntegerValue(null);
            }
        }
    }

    public ArrayValue(ArrayType type, int[] lengths) {
        this(type, lengths, 0);
    }

    /**
     * Returns the collection of values that this array saves.
     * @return collection of values that this array saves
     */
    public Value[] getValues() {
        return values;
    }

    public void setValue(String value, List<Integer> indexes) {
        setValue(value, indexes, 0);
    }

    /**
     * Changes the value of one element in this array
     * at the specified position.
     * @param value new value (as String)
     * @param indexes indexes describing the position of the
     *                element that will be changed
     */
    public void setValue(String value, List<Integer> indexes, int depth) {
        int pos = indexes.get(depth);
        if (pos < 0 || pos >= values.length) {
            pos = 0;
        }
        if (values[pos] instanceof BooleanValue) {
            ((BooleanValue) values[pos]).setValue(value);
        } else if (values[pos] instanceof IntegerValue) {
            ((IntegerValue) values[pos]).setValue(value);
        } else {
            ((ArrayValue) values[pos]).setValue(value, indexes, depth + 1);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayValue arrayValue = (ArrayValue) o;
        if (arrayValue.values.length != values.length) {
            return false;
        }
        boolean equal = true;
        for (int i = 0; i < values.length; i++) {
            equal = equal && values[i].equals(arrayValue.values[i]);
        }
        return equal;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append(values[0].toString());
        for (int i = 1; i < values.length; i++) {
            sb.append(',').append(values[i].toString());
        }
        return sb.append('}').toString();
    }
}
