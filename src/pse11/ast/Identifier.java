package ast;

/**
 * This class represents an identifier (i.e. the name of a variable).
 */
public class Identifier {
    /**
     * String to identify the identifier
     */
    private final String name;

    /**
     * Constructor.
     *
     * @param name identifier name
     */
    public Identifier(String name) {
        if (name == null) {
            throw new
                 IllegalArgumentException("Parameter name must not be null!");
        }
        this.name = name;
    }

    /**
     * Returns the name of the identifier.
     * @return identifier name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return name.equals(((Identifier) o).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
