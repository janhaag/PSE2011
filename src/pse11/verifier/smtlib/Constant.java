package verifier.smtlib;

import java.util.LinkedList;

/**
 * This class represents a Constant,
 * which is a S-Expression without subexpressions
 * that represents a constant value.
 * It is identified by its String representation.
 */
public class Constant extends S_Expression {
    /**
     * Its String representation.
     * It can be a number or a boolean value.
     */
    private final String stringRepresentation;

    /**
     * Constructor.
     * The second argument in the upper class is null,
     * because a Constant has no subexpressions.
     * @param stringRepresentation Its String representation.
     */
    public Constant(String stringRepresentation) {
         super(stringRepresentation);
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
        return new Constant(stringRepresentation);
    }

    @Override
    public void addVars(LinkedList<VarDef> varList) {
        //no-op
    }
}
