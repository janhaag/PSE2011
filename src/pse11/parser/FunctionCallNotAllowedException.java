package parser;

/**
 *
 */
public class FunctionCallNotAllowedException extends RuntimeException {
    public FunctionCallNotAllowedException(String message) {
        super(message);
    }
}
