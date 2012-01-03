package ast;

/**
 * This class represents the type boolean, which is either 'true' or 'false'.
 */
public class BooleanType extends Type {
    @Override
    public boolean equals(Object o) {
        return o instanceof BooleanType;
    }
}
