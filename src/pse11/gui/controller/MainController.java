package gui.controller;

import misc.Editor;
import misc.ExecutionHandler;
import misc.Settings;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Image;

import gui.AboutFrame;
import gui.EvaluationFrame;
import gui.FileFrame;
import gui.HelpFrame;
import gui.MainFrame;
import gui.SettingsFrame;
import gui.RandomTestFrame;

public class MainController implements SelectionListener {
	private ExecutionHandler executionHandler;
	private Editor editor; //TODO evt nicht nötig...
	
	private MainFrame mainframe;
	private MiscController miscController;
	private SettingsController settingsController;
	private EditorController editorController;
	private TreeViewController treeController;
	
	public MainController() {
		Editor editor = new Editor();
		this.mainframe = new MainFrame(this, editor);
		this.editorController = new EditorController(editor, mainframe.getEditor());
		this.executionHandler = new ExecutionHandler();
		this.miscController = new MiscController(null);
		this.settingsController = new SettingsController(Settings.getInstance());
		this.treeController = new TreeViewController(this.mainframe.getBreakpointView(),
				this.mainframe.getVarView(), this.executionHandler.getProgramExecution());
		
		//Has to be the last call in the constructor
		initMainFrame();
	}
	
	private void initMainFrame() {
		/* Very important to call this in a separated method because SWT uses an infinite 
		 * loop for its window management and we need the instance of MainFrame.
		 */
		this.mainframe.openWindow();
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		//frame events
		if(e.getSource() == this.mainframe.getMenuBar().getMenuBarItemExit()) {
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
		//button events
		else if(e.getSource() == mainframe.getRunButton()) {
			//Images
			Image image = new Image(this.mainframe.getDisplay(), "./src/gui/image/run2.png");
			Image image2 = new Image(this.mainframe.getDisplay(), "./src/gui/image/pause1.png");
			this.mainframe.switchIcon(image, image2);
			//Functions
			assert editorController != null;
			this.executionHandler.run(this.editorController.getEditor().getSource());
		} else if(e.getSource() == mainframe.getStepButton()) {
			Image image = new Image(this.mainframe.getDisplay(), "./src/gui/image/run2.png");
			Image image2 = new Image(this.mainframe.getDisplay(), "./src/gui/image/pause1.png");
			this.mainframe.switchIcon(image, image2);
		} else if(e.getSource() == mainframe.getPauseButton()) {
			Image image = new Image(this.mainframe.getDisplay(), "./src/gui/image/run1.png");
			Image image2 = new Image(this.mainframe.getDisplay(), "./src/gui/image/pause2.png");
			this.mainframe.switchIcon(image, image2);
		} else if(e.getSource() == mainframe.getValidateButton()) {
			Image image = new Image(this.mainframe.getDisplay(), "./src/gui/image/run1.png");
			Image image2 = new Image(this.mainframe.getDisplay(), "./src/gui/image/pause1.png");
			this.mainframe.switchIcon(image, image2);
		}
	}
	
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}
}
