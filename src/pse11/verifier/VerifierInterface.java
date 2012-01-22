package verifier;

import ast.ASTRoot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import misc.Pair;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

/**
 *
 */
public class VerifierInterface {
    private WPProgram program;
    private SMTLibTranslator smtLibTranslator;
    private String verifier;

    public VerifierInterface(SMTLibTranslator smtLibTranslator, String verifier) {
        this.smtLibTranslator = smtLibTranslator;
        this.verifier = verifier;
    }

    public LinkedList<Pair<Boolean, String>> verify(ASTRoot ast) throws IOException, InterruptedException, RecognitionException {
        program = smtLibTranslator.getWPTree(ast);
        File file = saveInSMTFile(program.toString());
        Process verifierProcess = Runtime.getRuntime().exec(verifier + " text.smt2");
        InputStream verifierout = verifierProcess.getInputStream();
        InputStreamReader reader = new InputStreamReader(verifierout);
        BufferedReader bReader = new BufferedReader(reader);
        verifierProcess.waitFor();
        StringBuilder output = new StringBuilder("");
        int lastRead = 0;
        while(lastRead != -1) {
            lastRead = bReader.read();
            if (lastRead != -1) {
               output.append(Character.toChars(lastRead));
            }
        }
        verifierout.close();
        /*String[] path = verifier.split("/");
        String [] nameAndEnding = path[path.length - 1].split(".");
        String name = nameAndEnding[0];
        String lexerName = name + "Lexer";
        String parserName = name + "Parser";*/
        CharStream in = new ANTLRStringStream(output.toString());
        z3Lexer lexer = new z3Lexer(in);
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(lexer);
        z3Parser parser = new z3Parser(tokens);
        LinkedList<Pair<Boolean, String>> result = parser.start();
        if (file.exists()) {
            file.delete();
        }
        return result;
    }

    private File saveInSMTFile(String toSave) throws IOException {
        File file = new File("text.smt2");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(toSave);
        writer.close();
        return file;
    }
}
