package interpreter;

import ast.ArrayType;
import ast.BooleanType;
import ast.IntegerType;
import ast.Type;

/**
 *
 */
public class ArrayValue extends Value {
    private Value[] values;
    
    public ArrayValue(ArrayType type) {
        super(type);
        Type baseType = type.getType();
        int length = type.getLength();
        values = new Value[length];
        if (baseType instanceof ArrayType) {
            for (int i = 0; i < length; i++) {
                values[i] = new ArrayValue((ArrayType) baseType);
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

    public Value[] getValues() {
        return values;
    }
}
