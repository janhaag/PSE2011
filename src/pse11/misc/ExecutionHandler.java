package misc;

import org.antlr.runtime.RecognitionException;

import parser.ParserInterface;
import interpreter.Interpreter;
import interpreter.ProgramExecution;

public class ExecutionHandler {
	private ProgramExecution execution;
	private Interpreter interpreter;
	private MessageSystem messagesystem;
	
	public ExecutionHandler(MessageSystem messagesystem) {
		this.messagesystem = messagesystem;
		this.interpreter = new Interpreter();
	}
	public ProgramExecution getProgramExecution() {
		return this.execution;
	}
	public void parse(String source) {
		try {
			/*this.execution = new ProgramExecution(new ParserInterface().parseProgram(source),
					this.interpreter);*/
			new ParserInterface().parseProgram(source);
		} catch (RecognitionException e) {
			//e.printStackTrace();
			this.messagesystem.addMessage(MessageCategories.ERROR, 0, e.getMessage());
			//new Message(MessageCategories.ERROR, 0, e.getMessage());
		}
	}
	public void singleStep() {
		
	}
}
