package verifier;

/**
 * Defines a Variable (for quantification)
 * @param ident the name of the variable
 * @param type the type of the variable
 */
public class VarDef extends S_Expression {
    public VarDef(String ident, String type) {
        super(ident + ' ' + type, null);
    }
}
