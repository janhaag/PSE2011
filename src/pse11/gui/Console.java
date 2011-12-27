package gui;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import misc.Message;
import misc.MessageSystem;

public abstract class Console extends Composite {
	//TODO PRIVATE
	public MessageSystem messagesystem;
	protected Table table;
	public Console(Composite parent, int style, MessageSystem messagesystem) {
		super(parent, style);
		this.messagesystem = messagesystem;
		messagesystem.addConsole(this);
		// TODO Auto-generated constructor stub
	}
	/*public static void setMessageSystem(MessageSystem ms) {
		messagesystem = ms;
	}*/
	public abstract void updateConsole(ArrayList<Message> messages);
}
