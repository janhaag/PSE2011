package ast;

/**
 * This class indicates something is of an array type,
 * which means a rectangular (in arbitrary dimension) collection
 * of elements belonging to a type all elements have in common,
 * which is called the base type of this array.
 */
public class ArrayType {
    /**
     * base type of the array
     */
    Type type;

    /**
     * Constructor.
     *
     * @param type base type of the array
     */
    public ArrayType(Type type) {
        this.type = type;
    }

    /**
     * Returns the base type of the array.
     * @return base type of the array
     */
    public Type getType() {
        return type;
    }
}
