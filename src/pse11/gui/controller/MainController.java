package gui.controller;

import misc.Settings;

import org.eclipse.swt.events.*;

import gui.AboutFrame;
import gui.EvaluationFrame;
import gui.FileFrame;
import gui.HelpFrame;
import gui.MainFrame;
import gui.SettingsFrame;
import gui.RandomTestFrame;

public class MainController implements SelectionListener {
	private MainFrame mainframe;
	private MiscController miscController;
	private SettingsController settingsController;
	public MainController() {
		this.miscController = new MiscController(null);
		this.settingsController = new SettingsController(Settings.getInstance());
		//Has to be the last call in the constructor
		initMainFrame();
	}
	private void initMainFrame() {
		this.mainframe = new MainFrame(this);
		/* Very important to call this in a separated method because SWT uses an infinite 
		 * loop for its window management and we need the instance of MainFrame.
		 * => THINK => CHANGE but CHANGE =\> THINK!
		 */
		this.mainframe.openWindow();
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource() == mainframe.getMenuBar().getMenuBarItemExit()) {
			System.exit(0);
		} else if(e.getSource() == mainframe.getMenuBar().getMenuBarItemLoad()
					|| e.getSource() == mainframe.getMenuBar().getMenuBarItemSave()) {
			new FileFrame(this.mainframe.getShell());
		} else if(e.getSource() == mainframe.getMenuBar().getMenuBarItemSettings()) {
			new SettingsFrame(this.mainframe.getShell(), this.settingsController);
		} else if(e.getSource() == mainframe.getMenuBar().getMenuBarItemEvaluation()) {
			new EvaluationFrame(this.mainframe.getShell());
		} else if(e.getSource() == mainframe.getMenuBar().getMenuBarItemRandomTest()) {
			new RandomTestFrame(this.mainframe.getShell(), miscController);
		} else if(e.getSource() == mainframe.getMenuBar().getMenurBarItemAbout()) {
			new AboutFrame(this.mainframe.getShell());
		} else if(e.getSource() == mainframe.getMenuBar().getMenuBarItemHelp()) {
			new HelpFrame(this.mainframe.getShell());
		}
	}
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO methodblock
	}
}
