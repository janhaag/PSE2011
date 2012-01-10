package ast;

/**
 * This class represents the type int, which is an integer
 * of arbitrary absolute value.
 */
public class IntegerType extends Type {
    @Override
    public boolean equals(Object o) {
        return o instanceof IntegerType;
    }

    @Override
    public String toString() {
        return "int";
    }
}
