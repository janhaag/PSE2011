package misc;

import parser.ParserInterface;
import interpreter.Interpreter;
import interpreter.ProgramExecution;

public class ExecutionHandler {
	private ProgramExecution execution;
	private Interpreter interpreter;
	
	public ExecutionHandler() {
		this.interpreter = new Interpreter();
	}
	public ProgramExecution getProgramExecution() {
		return this.execution;
	}
	public void parse(String source) {
		/*this.execution = new ProgramExecution(new ParserInterface().parseProgram(source), 
				this.interpreter);*/
	}
	public void singleStep() {
		
	}
}
