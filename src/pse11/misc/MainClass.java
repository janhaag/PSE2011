package misc;

import gui.controller.MainController;

/**
 * Main class for starting the program.
 * 
 * @version 1.0
 */
public class MainClass {
	/**
	 * This method is the <code>main</code>-method and initiates the program start.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		//System.out.println(System.getProperty("java.class.path"));
		new MainController();
	}	
}
