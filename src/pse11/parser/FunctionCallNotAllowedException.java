package parser;

import ast.Position;

/**
 * This exception is thrown if a function is called when it is not allowed.
 */
public class FunctionCallNotAllowedException extends RuntimeException {
    /**
     * the position of the failing program element in
     * the source code
     */
    private final Position errorPosition;

    /**
     * Constructor.
     * @param message error message
     * @param errorPosition position of the failing program element
     */
    public FunctionCallNotAllowedException(String message, Position errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

    /**
     * Returns the position of the failing program element.
     * @return position of the failing program element
     */
    public Position getErrorPosition() {
        return errorPosition;
    }
}
