package verifier;

/**
 * This class represents a Constant,
 * which is a S-Expression without subexpressions.
 * It is identified by its String representation.
 */
public class Constant extends S_Expression {
   /**
    * Its String representation.
    * It can be a number or a variable.
    */
   private String stringRepresentation;

   /**
    * Constructor.
    * The second argument in the upper class is null,
    * because a Constant has no subexpressions.
    * @param stringRepresentation Its String representation.
    */
   public Constant(String stringRepresentation) {
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
}
