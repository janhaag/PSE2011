package interpreter;

import ast.Position;

/**
 * This exception is thrown if a specification fails.
 */
public class AssertionFailureException extends RuntimeException {
    /**
     * position of failing specification
     */
    private final Position position;

    /**
     * Constructor.
     *
     * @param message error message
     * @param position position of failing specification
     */
    public AssertionFailureException(String message, Position position) {
        super(message);
        this.position = position;
    }

    /**
     * Returns the position of failing specification.
     * @return position of failing specification
     */
    public Position getPosition() {
        return position;
    }
}
