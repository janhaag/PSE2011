package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.RecognitionException;

import ast.Expression;

import parser.ParserInterface;
import interpreter.Interpreter;
import interpreter.ProgramExecution;
import interpreter.GlobalBreakpoint;

public class ExecutionHandler {
	private ProgramExecution execution;
	private Interpreter interpreter;
	private MessageSystem messagesystem;
	private ArrayList<GlobalBreakpoint> globalBreakpoints;
	public ExecutionHandler(MessageSystem messagesystem) {
		this.messagesystem = messagesystem;
		this.interpreter = new Interpreter();
		this.globalBreakpoints = new ArrayList<GlobalBreakpoint>();
	}
	public ProgramExecution getProgramExecution() {
		return this.execution;
	}
	public void addGlobalBreakpoint(Expression expression) {
		GlobalBreakpoint newGlobalBreakpoint = new GlobalBreakpoint(expression);
		if(!this.globalBreakpoints.contains(newGlobalBreakpoint)) {
			this.globalBreakpoints.add(newGlobalBreakpoint);
		} else {
			newGlobalBreakpoint = null;
		}
	}
	public void parse(String source) {
		ParserInterface parser = new ParserInterface();
		this.messagesystem.clear(MessageCategories.ERROR);
		try {
			/*this.execution = new ProgramExecution(new ParserInterface().parseProgram(source),
					this.interpreter);*/
			parser.parseProgram(source);
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
	public void singleStep() {
		
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
}
