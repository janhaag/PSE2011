package misc;

import org.eclipse.swt.graphics.RGB;

/**
 * Instances of this class represent special keywords in the source which get special
 * colors.
 * 
 * This class is one of the main components of the syntax highlighting function of the 
 * {@link Editor}.
 * 
 * @version 1.0
 */
public class Keyword {
	/**
	 * the position of the first letter of the keyword in the source
	 */
	private int start;
	/**
	 * the length of the keyword
	 */
	private int length;
	/**
	 * the color of the keyword
	 */
	private RGB color;
	/**
	 * Constructs a new instance of Keyword.
	 * 
	 * The color should be passed as a <code>String</code> of a 24bit number in hex format.
	 * The length of the keyword must be larger than 0.
	 * 
	 * @param start the position of the first letter of the keyword in the source
	 * @param length the length of the keyword
	 * @param color the color of the keyword
	 * @throws IllegalArgumentException if the length of the keyword is less than 1
	 */
	public Keyword(int start, int length, String color) {
		if(length < 1) {
			throw new IllegalArgumentException("Illegal Argument! "
					+ "- the length of the keyword should be larger than 0.");
		}
		this.start = start;
		this.length = length;
		this.color = this.convertStringToRGB(color);
	}
	/**
	 * Returns the position of the first letter of the keyword in the source.
	 * 
	 * @return the position of the keyword
	 */
	public int getStart() {
		return this.start;
	}
	/**
	 * Returns the length of the keyword.
	 * 
	 * @return the length of the keyword
	 */
	public int getLength() {
		return this.length;
	}
	/**
	 * Returns the color of the keyword.
	 * 
	 * @return the color of the keyword
	 */
	public RGB getColor() {
		return this.color;
	}
	//TODO Methode convert... unsicher!
	/**
	 * Converts the given String to an instance of {@link RGB}.
	 * 
	 * @param colorstring the string which encodes the color
	 * @return an instance of RGB with the specified color
	 */
	private RGB convertStringToRGB(String colorstring) {
		assert colorstring.length() == 6; 
		return new RGB(Integer.valueOf(colorstring.substring(0, 2), 16).intValue(), 
				Integer.valueOf(colorstring.substring(2, 4), 16).intValue(), 
				Integer.valueOf(colorstring.substring(4, 6), 16).intValue());
	}
}
