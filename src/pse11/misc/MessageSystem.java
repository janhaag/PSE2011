package misc;

import java.util.ArrayList;

import gui.Console;

public class MessageSystem {
	private ArrayList<Console> consoles;
	private ArrayList<Message> messages;
	public MessageSystem() {
		this.consoles = new ArrayList<Console>();
		this.messages = new ArrayList<Message>();
		//TODO weg
		messages.add(new Message(Categories.ERROR,2,"test"));
	}
	public void addConsole(Console console) {
		if(!this.consoles.contains(console)) {
			this.consoles.add(console);
		}
		System.out.println(console.toString());
	}
	public void removeConsole(Console console) {
		if(this.consoles.contains(console)) {
			this.consoles.remove(this.consoles.indexOf(console));
		}
	}
	public void addMessage(int category, int position, String text) {
		this.messages.add(new Message(Categories.ERROR, position, text));
	}
	//TODO private
	public void notifyConsoles() {
		for(Console console : this.consoles) {
			console.updateConsole(this.messages);
		}
	}
}
