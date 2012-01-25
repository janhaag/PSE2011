package misc;

public class EditorMemento {
	private final String source;
	public EditorMemento(String source) {
		this.source = source;
	}
	public String getSource() {
		return this.source;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof EditorMemento && ((EditorMemento) o).getSource().equals(this.source))
			return true;
		return false;
	}
}
