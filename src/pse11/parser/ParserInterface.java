package parser;
import ast.Program;
import ast.Expression;

public class ParserInterface {
    /**
     * Parse program text into an AST
     * @param text the text to be parsed
     * @return the AST
     */
    public Program parseProgram(String text) {
        CharStream in = new ANTLRStringStream(text);
        WhileLanguageLexer lex = new WhileLanguageLexer(in);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lex);
        WhileLanguageParser parser = new WhileLanguageParser(tokens);
        return parser.program();
    }

    /**
     * Parse expression text into an AST
     * @param text the text to be parsed
     * @return the AST
     */
    public Expression parseExpression(String text) {
        CharStream in = new ANTLRStringStream(text);
        WhileLanguageLexer lex = new WhileLanguageLexer(in);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lex);
        WhileLanguageParser parser = new WhileLanguageParser(tokens);
        return parser.single_expression();
    }
}
