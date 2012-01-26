package verifier;

import ast.ASTRoot;

import java.io.IOException;
import java.util.LinkedList;
import misc.Pair;
import org.antlr.runtime.RecognitionException;

/**
 *
 */
public class VerifierInterface {
    private Verifier verifier;

    public VerifierInterface(Verifier verifier) {
        this.verifier = verifier;
    }

    public String getVerifierOutput(ASTRoot ast) throws IOException, InterruptedException {
        return verifier.call(ast);
    }

    public LinkedList<Pair<Boolean, String>> verify(ASTRoot ast) throws IOException, InterruptedException, RecognitionException {
        String verifierResult = verifier.call(ast);
        return verifier.parseVerifierOutput(verifierResult);
    }
}
