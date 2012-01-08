package gui.controller;

import gui.SettingsFrame;

import misc.Settings;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class SettingsController {
	private SettingsFrame frame;
	private Settings settings;
	
	public SettingsController(Settings settings) {
		this.settings = settings;
	}
	public String getTimeOut() {
		return Integer.toString(this.settings.getTimeout());
	}
	public String getMemoryLimit() {
		return Integer.toString(this.settings.getMemoryLimit());
	}
	public void addView(SettingsFrame frame) {
		this.frame = frame;
	}
	public SaveSettings getSaveButtonListener() {
		return new SaveSettings();
	}
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
