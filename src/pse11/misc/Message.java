package misc;

public class Message {
	private Categories category;
	private int position;
	private String text;
	public Message(Categories category, int position, String text) {
		this.category = Categories.ERROR;
		this.position = 99;
		this.text = "test";
	}
	public Categories getCategory() {
		return this.category;
	}
	public int getPosition() {
		return this.position;
	}
	public String getText() {
		return this.text;
	}
}
