package verifier.smtlib;

import java.util.LinkedList;

/**
 * This class represents a variable,
 * which can be replaced by another
 * S_Expression.
 * This class is a leaf in the S_Expression tree.
 */
public class Variable extends S_Expression {
    /**
     * Its String representation, which is the variable name.
     */
    private final String stringRepresentation;

    /**
     * Constructor.
     * The second argument in the upper class is null,
     * because a Variable has no subexpressions.
     * @param stringRepresentation Its String representation.
     */
    public Variable(String stringRepresentation) {
         super(stringRepresentation, null);
         this.stringRepresentation = stringRepresentation;
    }
    /**
     * To String method.
     * @return Its String representation.
     */
    @Override
    public String toString() {
        return stringRepresentation;
    }

    @Override
    public S_Expression deepCopy() {
        return new Variable(stringRepresentation);
    }
}
