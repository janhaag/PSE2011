package gui;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import misc.Message;
import misc.MessageSystem;

/**
 * This class represents a console as a part of the main frame.
 * It displays various messages for the user.
 */
public abstract class Console extends Composite {
	/**
	 * table to display messages
	 */
	protected Table table;
	/**
	 * model to save messages
	 */
	protected MessageSystem messagesystem;
	
	/**
	 * Construct a console with the specified parent composite, definitions 
	 * of its style and model.
	 * @param parent specified composite
	 * @param style specified definitions
	 * @param messagesystem specified model
	 */
	public Console(Composite parent, int style, MessageSystem messagesystem) {
		super(parent, style);
		this.messagesystem = messagesystem;
		messagesystem.addConsole(this);
	}
	public abstract void updateConsole(ArrayList<Message> messages);
}
