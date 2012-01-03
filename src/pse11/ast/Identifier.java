package ast;

/**
 * This class represents an identifier (i.e. the name of a variable).
 */
public class Identifier {
    /**
     * String to identify the identifier
     */
    private String name;

    /**
     * Constructor.
     *
     * @param name identifier name
     */
    public Identifier(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the identifier.
     * @return identifier name
     */
    public String getName() {
        return name;
    }
}
