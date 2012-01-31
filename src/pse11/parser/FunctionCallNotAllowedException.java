package parser;

import ast.Position;

/**
 *
 */
public class FunctionCallNotAllowedException extends RuntimeException {
    /**
     * the position of the failing program element in
     * the source code
     */
    private final Position errorPosition;

    public FunctionCallNotAllowedException(String message, Position errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    public Position getErrorPosition() {
        return errorPosition;
    }
}
