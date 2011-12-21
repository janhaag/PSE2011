import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        WhileLanguageLexer lex = new WhileLanguageLexer(new ANTLRFileStream("/home/stud/s_bischo/Desktop/testprog.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        WhileLanguageParser g = new WhileLanguageParser(tokens, 49100, null);
        try {
            g.program();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}