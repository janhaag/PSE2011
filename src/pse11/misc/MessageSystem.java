package misc;

import java.util.ArrayList;

import gui.Console;

/**
 * An instance of this class collects and stores all messages of external modules 
 * like Parser, Interpreter and Verifier.
 * 
 * @version 1.0
 */
public class MessageSystem {
	/**
	 * the consoles which display the messages
	 */
	private ArrayList<Console> consoles;
	/**
	 * the current messages 
	 */
	private ArrayList<Message> messages;
	/**
	 * Constructs a new instance of MessageSystem.
	 */
	public MessageSystem() {
		this.consoles = new ArrayList<Console>();
		this.messages = new ArrayList<Message>();
		//TODO weg
		//messages.add(new Message(MessageCategories.ERROR,2,"test"));
	}
	/**
	 * Adds the specified console as an observer to this instance.
	 * 
	 * @param console the console which should be added
	 */
	public void addConsole(Console console) {
		if(!this.consoles.contains(console)) {
			this.consoles.add(console);
		}
		System.out.println(console.toString());
	}
	/**
	 * Removes the specified console from the observer list.
	 * 
	 * @param console the console which should be removed
	 */
	public void removeConsole(Console console) {
		if(this.consoles.contains(console)) {
			this.consoles.remove(this.consoles.indexOf(console));
		}
	}
	//TODO JavaDoc
	/**
	 * Adds a new message to this instance.
	 * 
	 * 
	 * 
	 * @param category the category of the message
	 * @param position the position of the message in the source
	 * @param text the text of the message
	 */
	public void addMessage(MessageCategories category, int position, String text) {
		this.messages.add(new Message(MessageCategories.ERROR, position, text));
		this.notifyConsoles();
		System.out.println("lol");
	}
	//TODO private
	/**
	 * Notifies all observers on a change of the messages.
	 */
	private void notifyConsoles() {
		for(Console console : this.consoles) {
			console.updateConsole(this.messages);
		}
	}
}
