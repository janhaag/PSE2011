package parser;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import ast.Program;
import ast.Expression;

public class ParserInterface {
    /**
     * Parse program text into an AST
     * @param text the text to be parsed
     * @return the AST
     * @throws RecognitionException 
     */
    public Program parseProgram(String text) throws RecognitionException {
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
     * @throws RecognitionException 
     */
    public Expression parseExpression(String text) throws RecognitionException {
        CharStream in = new ANTLRStringStream(text);
        WhileLanguageLexer lex = new WhileLanguageLexer(in);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lex);
        WhileLanguageParser parser = new WhileLanguageParser(tokens);
        return parser.single_expression();
    }
}
