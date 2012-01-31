package verifier.smtlib;

import ast.Type;

import java.util.LinkedList;

/**
 * Defines a Variable
 */
public class VarDef extends S_Expression {
    private final String ident;
    private final Type type;
    private final String fullRepresentation;
    private final int depth;

    /**
     * Defines a Variable
     * @param ident the name of the variable
     * @param type the type of the variable
     * @param depth the depth of the variable
     */
    public VarDef(String ident, Type type, int depth) {
        super(ident, null);
        this.ident = ident;
        this.type = type;
        fullRepresentation = ident + " () "
                + SMTLibTranslator.getTypeString(type);
        this.depth = depth;
    }

    @Override
    public String toString() {
        return ident;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public void addVars(LinkedList<String> varList) {
        if (!varList.contains(fullRepresentation)) {
            varList.add(fullRepresentation);
        }
    }

    @Override
    public S_Expression deepCopy() {
        return new VarDef(ident, type, depth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VarDef varDef = (VarDef) o;

        return ident.equals(varDef.ident);
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }
}
