package misc;

/**
 * The instances of this class represent a message from the model (parser, type checker,
 * verifier, ...).
 * 
 * Each message has a defined type. For the possible types see:
 * @see {@link MessageCategories}
 * 
 * @version 1.0
 */
public class Message {
	/**
	 * the category of the message
	 */
	private MessageCategories category;
	/**
	 * the position in the source the message relates to
	 */
	private int position;
	/**
	 * the text of the message
	 */
	private String text;
	
	private String result;
	/**
	 * Constructs a new instance of Message with the specified values.
	 * 
	 * @param category the category of the message (@see {@link MessageCategories})
	 * @param position the position in the source the message relates to
	 * @param text the text of the message
	 */
	public Message(MessageCategories category, int position, String text) {
		this.category = category;
		this.position = position;
		this.text = text;
	}
	
	public Message(MessageCategories category, int position, String text, String result) {
		this.category = category;
		this.position = position;
		this.text = text;
		this.result = result;
	}
	
	/**
	 * Returns the category of the message.
	 * 
	 * @return the category of the message
	 */
	public MessageCategories getCategory() {
		return this.category;
	}
	public int getPosition() {
		return this.position;
	}
	/**
	 * Returns the text of the message.
	 * 
	 * @return the text of the message
	 */
	public String getText() {
		return this.text;
	}
	
	public String getResult() {
		return this.result;
	}
}
