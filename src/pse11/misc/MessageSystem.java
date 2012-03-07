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
		this.messages.add(new Message(category, position, text));
		this.notifyConsoles();
	}
	
	public void addMessage(MessageCategories category, int position, String text, String result) {
		this.messages.add(new Message(category, position, text, result));
		this.notifyConsoles();
	}
	
	/**
	 * Notifies all observers on a change of the messages.
	 */
	private void notifyConsoles() {
		for(Console console : this.consoles) {
			console.updateConsole(this.messages);
		}
	}
	
	public void clear(MessageCategories category) {
		ArrayList<Message> delMessages = new ArrayList<Message>();
		for(Message message : this.messages) {
			if(message.getCategory() == category) {
				delMessages.add(message);
			}
		}
		this.messages.removeAll(delMessages);
		this.notifyConsoles();
	}
	
	public ArrayList<Message> getMessages() {
		return this.messages;
	}
	
	public ArrayList<Console> getConsoles() {
		return this.consoles;
	}
}
