package gui;

import java.util.ArrayList;

import misc.Message;
import misc.MessageSystem;

import org.eclipse.swt.widgets.Composite;

public class MiscConsole extends Console {
	public MiscConsole(Composite parent, int style, MessageSystem messagesystem) {
		super(parent, style, messagesystem);
		this.messagesystem = messagesystem;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateConsole(ArrayList<Message> messages) {
		// TODO Auto-generated method stub
		
	}

}
