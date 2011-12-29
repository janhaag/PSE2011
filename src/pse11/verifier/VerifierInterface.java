package Verifier;

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
    private interpreter.SMTLibTranslator smtLibTranslator;
    private Verifier verifier;

    public VerifierInterface(interpreter.SMTLibTranslator smtLibTranslator) {
        this.smtLibTranslator = smtLibTranslator;
        verifier = Verifier.Z3;
    }

    public void notifyConsole() {
        //An welchen Controller und was genau?
    }

    public String verify(ast.ASTRoot ast) throws IOException {
        program = interpreter.SMTLibTranslator.getWPTree(ast);
        File file = saveInSMTFile(program.toString());
        switch(verifier) {
            case Z3:
                Process z3 = Runtime.getRuntime().exec("z3 text.smt2"); //"cmd /c"?
                try {
                    InputStream z3out = z3.getInputStream();
                    InputStreamReader reader = new InputStreamReader(z3out);
                    z3.waitFor();
                    StringBuilder output = new StringBuilder("");
                    int lastRead = 0;
                    while(lastRead != -1) {
                        lastRead = reader.read();
                        if (lastRead != -1) {
                            output.append(Character.toChars(lastRead));
                        }
                    }
                    z3out.close();
                } catch (InterruptedException ex) {
                      //Was soll hier rein?
			//Try Block noch zu groß
                }
                //Schicke Ergebniss von Z3 an Lexer und dessen an Parser.
                notifyConsole();
                break;
            default:
                System.out.println("Unknown Verifier.");
        }
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
