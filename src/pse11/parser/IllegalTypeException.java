package parser;

import ast.Position;

/**
 * This exception is thrown by the type checker if
 * the type of the user program are not correct.
 */
public class IllegalTypeException extends RuntimeException {
    private final Position errorPosition;

    public IllegalTypeException(String message, Position errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    public Position getErrorPosition() {
        return this.errorPosition;
    }
}
