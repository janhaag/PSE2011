package ast;

/**
 * This class indicates something is of an array type,
 * which means a linear collection of elements
 * belonging to a type all elements have in common,
 * which is called the base type of this array.
 */
public class ArrayType extends Type {
    /**
     * base type of the array
     */
    private final Type type;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return type.equals(((ArrayType) o).type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(type.toString());
        return sb.append("[]").toString();
    }
}
