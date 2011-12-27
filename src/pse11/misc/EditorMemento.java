package misc;

public class EditorMemento {
	private final String text;
	public EditorMemento(String text) {
		this.text = text;
	}
	public String getText() {
		return this.text;
	}
}
