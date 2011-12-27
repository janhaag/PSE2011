package misc;

import org.eclipse.swt.graphics.RGB;

public class Keyword {
	private int start;
	private int length;
	private RGB color;
	public Keyword(int start, int length, String color) {
		this.start = start;
		this.length = length;
		this.color = this.convertStringToRGB(color);
	}
	public int getStart() {
		return this.start;
	}
	public int getLength() {
		return this.length;
	}
	public RGB getColor() {
		return this.color;
	}
	private RGB convertStringToRGB(String colorstring) {
		assert colorstring.length() == 6; 
		return new RGB(Integer.valueOf(colorstring.substring(0, 2), 16).intValue(), 
				Integer.valueOf(colorstring.substring(2, 4), 16).intValue(), 
				Integer.valueOf(colorstring.substring(4, 6), 16).intValue());
	}
}
