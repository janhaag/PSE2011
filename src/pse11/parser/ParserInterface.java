package parser;
import ast.Program;
import ast.Expression;

public class ParserInterface {
    /**
     * Initialize parser state
     */
    public void initParser() {}

    /**
     * Parse program text into an AST
     * @param text the text to be parsed
     * @return the AST
     */
    public Program parseProgram(String text) {
        return null;
    }

    /**
     * Parse expression text into an AST
     * @param text the text to be parsed
     * @return the AST
     */
    public Expression parseExpression(String text) {
        return null;
    }
}
