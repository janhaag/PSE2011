package gui.controller;

import interpreter.ProgramExecution;
import misc.Settings;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;

import gui.AboutFrame;
import gui.EvaluationFrame;
import gui.FileFrame;
import gui.HelpFrame;
import gui.MainFrame;
import gui.SettingsFrame;
import gui.RandomTestFrame;

public class MainController implements SelectionListener {
	private ProgramExecution execution;
	
	private MainFrame mainframe;
	private MiscController miscController;
	private SettingsController settingsController;
	private EditorController editorController;
	private TreeViewController treeController;
	
	public MainController() {
		this.miscController = new MiscController(null);
		this.settingsController = new SettingsController(Settings.getInstance());
		
		//parser interface for parameter needed.......
		//this.execution = new ProgramExecution(null);
		
		//Has to be the last call in the constructor
		initMainFrame();
	}
	
	private void initMainFrame() {
		this.mainframe = new MainFrame(this, this.editorController);	
		this.initViewController();
		/* Very important to call this in a separated method because SWT uses an infinite 
		 * loop for its window management and we need the instance of MainFrame.
		 */
		this.mainframe.openWindow();
	}
	
	private void initViewController() {
		this.treeController = new TreeViewController(this.mainframe.getBreakpointView(),
				this.mainframe.getVarView(), this.execution);
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource() == mainframe.getMenuBar().getMenuBarItemExit()) {
			System.exit(0);
		} else if(e.getSource() == mainframe.getMenuBar().getMenuBarItemLoad()) {
			new FileFrame(this.mainframe.getShell(), SWT.OPEN);
		} else if(e.getSource() == mainframe.getMenuBar().getMenuBarItemSave()) {
			new FileFrame(this.mainframe.getShell(), SWT.SAVE);
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
