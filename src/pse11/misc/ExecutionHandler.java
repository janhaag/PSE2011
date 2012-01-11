package misc;

import parser.ParserInterface;
import interpreter.Interpreter;
import interpreter.ProgramExecution;

public class ExecutionHandler {
	private ProgramExecution execution;
	private Interpreter interpreter;
	
	public ExecutionHandler() {
		
	}
	public ProgramExecution getProgramExecution() {
		return this.execution;
	}
	public void run(String source) {
		this.execution = new ProgramExecution(new ParserInterface().parse(source));
	}
	public void singleStep() {
		
	}
}
