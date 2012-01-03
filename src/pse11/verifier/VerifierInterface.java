package verifier;

import ast.ASTRoot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    public void notifyConsole() {
        //An welchen Controller und was genau?
    }

    public String verify(ASTRoot ast) throws IOException {
        program = smtLibTranslator.getWPTree(ast);
        File file = saveInSMTFile(program.toString());
        Process verifierProcess = Runtime.getRuntime().exec(verifier + " text.smt2");
        InputStream verifierout = verifierProcess.getInputStream();
        InputStreamReader reader = new InputStreamReader(verifierout);
        BufferedReader bReader = new BufferedReader(reader);
        try {
            verifierProcess.waitFor();
        } catch (InterruptedException ex) {
            System.out.println("Verifier was interrupted unexpectedly.");
        }
        StringBuilder output = new StringBuilder("");
        int lastRead = 0;
        while(lastRead != -1) {
            lastRead = bReader.read();
            if (lastRead != -1) {
               output.append(Character.toChars(lastRead));
            }
        }
        verifierout.close();
        //Schicke Ergebniss von Z3 an Lexer und dessen an Parser.
        notifyConsole();
        if (file.exists()) {
            file.delete();
        }
        return null; //Ergebniss des Parsers (interpretiert)
    }

    private File saveInSMTFile(String toSave) throws IOException {
        File file = new File("text.smt2");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(toSave);
        writer.close();
        return file;
    }
}
