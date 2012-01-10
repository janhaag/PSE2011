package interpreter;

import ast.Position;

/**
 *
 */
public class AssertionFailureException extends RuntimeException {
    private final Position position;

    public AssertionFailureException(String message, Position position) {
        super(message);
        this.position = position;
    }
}
