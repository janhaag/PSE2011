package verifier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.util.LinkedList;

import ast.ASTRoot;

import ast.Position;
import misc.Pair;

public abstract class Verifier {
    protected String[] template;

    protected Verifier(String template) {
        this.template = template.split("\\s+");
    }

    protected abstract String translate(ASTRoot ast);

    public LinkedList<Pair<Boolean, String>> parseVerifierOutput(String verifierOutput) {
        return null;
    }

    public final String call(ASTRoot ast) throws IOException, InterruptedException {
        String verifierInput = translate(ast);
        Pair<String, File> target = getVerifierCmdLine();
        if (target.getValue2() != null) {
            writeVerifierInputToFile(target.getValue2(), verifierInput);
        }
        Process verifierProcess = Runtime.getRuntime().exec(target.getValue1());
        if (target.getValue2() == null) {
            pipeVerifierInput(verifierProcess.getOutputStream(), verifierInput);
        }
        verifierProcess.waitFor();
        return readVerifierOutput(verifierProcess.getInputStream());
    }

    private String readVerifierOutput(InputStream channel) throws IOException {
        InputStreamReader reader = new InputStreamReader(channel);
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder output = new StringBuilder("");
        int lastRead = 0;
        while(lastRead != -1) {
            lastRead = bReader.read();
            if (lastRead != -1) {
               output.append(Character.toChars(lastRead));
            }
        }
        channel.close();
        return output.toString();
    }

    private void writeVerifierInputToFile(File out, String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(out));
        writer.write(data);
        writer.close();
    }

    private void pipeVerifierInput(OutputStream channel, String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(channel));
        writer.append(data);
        writer.close();
    }

    private Pair<String, File> getVerifierCmdLine() throws IOException {
        StringBuilder result = new StringBuilder();
        File file = null;
        for (int i = 0; i < template.length; i++) {
            if ("${FILE}".equals(template[i])) {
                file = File.createTempFile("PSE11", ".smt2");
                file.deleteOnExit();
                template[i] = file.getAbsolutePath();
            }
            result.append(template[i]).append(' ');
        }
        return new Pair<String, File>(result.toString(), file);
    }
}
