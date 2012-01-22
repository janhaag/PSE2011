package misc;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.RecognitionException;

import ast.Program;

import parser.ParserInterface;
import interpreter.Interpreter;
import interpreter.ProgramExecution;
import interpreter.GlobalBreakpoint;
import interpreter.StatementBreakpoint;

public class ExecutionHandler {
	private ProgramExecution execution;
	private Interpreter interpreter;
	private MessageSystem messagesystem;
	private ParserInterface parser;
	
	private Program ast;
	private int[] parameterValues;
	private boolean paused;
	
	public ExecutionHandler(MessageSystem messagesystem) {
		this.messagesystem = messagesystem;
		this.interpreter = new Interpreter();
		this.parser = new ParserInterface();
	}
	public ProgramExecution getProgramExecution() {
		return this.execution;
	}

	public void parse(String source) {
		this.messagesystem.clear(MessageCategories.ERROR);
		try {
			this.ast = this.parser.parseProgram(source);
		} catch (RecognitionException re) {
			this.messagesystem.addMessage(MessageCategories.ERROR, 0, re.getMessage());
		} catch(NullPointerException npe) {
			npe.printStackTrace();
			this.messagesystem.addMessage(MessageCategories.ERROR, -1, "AST creation not possible!");
		}
		for(String error : parser.getErrors()) {
			String[] parsedError = parseParserError(error);
			this.messagesystem.addMessage(MessageCategories.ERROR, Integer.parseInt(parsedError[0]), parsedError[1]);
		}
	}
	
	public void run(ArrayList<StatementBreakpoint> sbreakpoints, 
			ArrayList<GlobalBreakpoint> gbreakpoints) {
		if (this.ast == null) {
			return;
		}
		boolean finished = false;
		while (!paused && !finished) {
			this.singleStep(sbreakpoints, gbreakpoints);
			if (this.execution != null && this.execution.getCurrentState().getCurrentStatement() == null) {
				finished = true;
			}
		}
	}
	
	public void singleStep(ArrayList<StatementBreakpoint> sbreakpoints, 
			ArrayList<GlobalBreakpoint> gbreakpoints) {
		if (this.ast == null) {
			return;
		}
		if (this.execution == null) {
			this.execution = new ProgramExecution(this.ast, this.interpreter, 
					sbreakpoints, gbreakpoints, this.parameterValues == null ? new int[0] : this.parameterValues);
		}
		if (this.execution.getCurrentState().getCurrentStatement() != null) {
			this.interpreter.step(this.execution.getCurrentState());
		}
	}
	
	private String[] parseParserError(String error) {
		String[] parsedError = new String[2];
		Pattern p = Pattern.compile("^line (\\d+):(\\d+) (.*)$");
		Matcher m = p.matcher(error); 
		boolean isvalid = m.matches();
		if(!isvalid) {
			System.out.println("ERROR");
			return new String[]{"-1", "ERROR"};
		}
		parsedError[0] = m.group(1);
		parsedError[1] = m.group(3);
		return parsedError;
	}
	
	public void destroyProgramExecution() {
		this.execution = null;
	}
	
	public void setParameterValues(int[] values) {
		this.parameterValues = values;
	}
	
	public int[] getParameterValues() {
		return this.parameterValues;
	}
	
	public void setAST(Program ast) {
		this.ast = ast;
	}
	
	public Program getAST() {
		return this.ast;
	}
	
	public ParserInterface getParserInterface() {
		return this.parser;
	}
}
