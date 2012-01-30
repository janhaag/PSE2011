package gui.controller;

import gui.SettingsFrame;

import misc.Settings;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * This class serves as a part of a MVC pattern. It is the controller 
 * for the view @see{SettingsFrame} and the model @see{Settings}.
 */
public class SettingsController {
	/**
	 * view for displaying saved settings
	 */
	private SettingsFrame frame;
	/**
	 * model to save settings
	 */
	private Settings settings;
	
	/**
	 * Construct a controller instance with the specified model.
	 * @param settings the specified model
	 */
	public SettingsController(Settings settings) {
		this.settings = settings;
	}
	
	/**
	 * Return the value of the timeout of the model @see{Settings}.
	 * @return the timeout
	 */
	public String getTimeOut() {
		return Integer.toString(this.settings.getTimeout());
	}
	
	/**
	 * Return the value of the memory limit of the model @see{Settings}.
	 * @return the memory limit
	 */
	public String getMemoryLimit() {
		return Integer.toString(this.settings.getMemoryLimit());
	}
	
	/**
	 * Add the specified frame as view.
	 * @param frame the specified view
	 */
	public void addView(SettingsFrame frame) {
		this.frame = frame;
	}
	
	/**
	 * Return a new listener instance to save settings.
	 * @return the listener 
	 */
	public SaveSettings getSaveButtonListener() {
		return new SaveSettings();
	}
	
	/**
	 * Display error message.
	 */
	private void invalidInput() {
		this.frame.displayMessage(true, "Invalid input.");
		this.frame.update();
	}
	
	private class SaveSettings implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent e) {
			int timeout, memorylimit;
			try {
				timeout = Integer.parseInt(frame.getTimeoutTextField().getText());
				memorylimit = Integer.parseInt(frame.getMemoryLimitTextField().getText());
			} catch(NumberFormatException nfe) {
				invalidInput();
				return;
			}
			if(timeout < 0 || memorylimit < 0) {
				invalidInput();
				return;
			}
			settings.setTimeout(timeout);
			settings.setMemoryLimit(memorylimit);
			frame.displayMessage(false, "Settings saved.");
			frame.update();
		}
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}
}
