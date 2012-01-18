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
		ParserInterface parser = new ParserInterface();
		this.messagesystem.clear(MessageCategories.ERROR);
		try {
			/*this.execution = new ProgramExecution(new ParserInterface().parseProgram(source), 
					this.interpreter);*/
			parser.parseProgram(source);
		} catch (RecognitionException re) {
			//e.printStackTrace();
			this.messagesystem.addMessage(MessageCategories.ERROR, 0, re.getMessage());
		} catch(NullPointerException npe) {
			this.messagesystem.addMessage(MessageCategories.ERROR, -1, "AST creation not possible!");
		}
		for(String error : parser.getErrors()) {
			this.messagesystem.addMessage(MessageCategories.ERROR, 0, error);
		}
	}
	public void singleStep() {
		
	}
}
