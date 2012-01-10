package parser;

import ast.Position;

/**
 * This exception is thrown by the type checker if
 * the type of the user program are not correct.
 */
public class IllegalTypeException extends RuntimeException {
    /**
     * the position of the failing program element in
     * the source code
     */
    private final Position errorPosition;

    /**
     * Constructor.
     *
     * @param message error message
     * @param errorPosition position of failing program element
     */
    public IllegalTypeException(String message, Position errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    /**
     * Returns the position of the failing program element.
     * @return position of the failing program element
     */
    public Position getErrorPosition() {
        return this.errorPosition;
    }
}
