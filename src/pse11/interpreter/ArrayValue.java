package interpreter;

import ast.ArrayType;
import ast.BooleanType;
import ast.IntegerType;
import ast.Type;

import java.util.ArrayList;

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

    /**
     * Returns the collection of values that this array saves.
     * @return collection of values that this array saves
     */
    public Value[] getValues() {
        return values;
    }

    /**
     * Changes the value of one element in this array
     * at the specified position.
     * @param value new value (as String)
     * @param indexes indexes describing the position of the
     *                element that will be changed
     */
    public void setValue(String value, ArrayList<Integer> indexes) {
        int pos = indexes.get(0);
        indexes.remove(0);
        if (indexes.isEmpty()) {
            if (values[pos] instanceof BooleanValue) {
                ((BooleanValue) values[pos]).setValue(value);
            } else {
                ((IntegerValue) values[pos]).setValue(value);
            }
        } else {
            ((ArrayValue) values[pos]).setValue(value, indexes);
        }
    }
}
