package gui.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import misc.Editor;
import misc.ExecutionHandler;
import misc.Help;
import misc.MessageSystem;
import misc.Settings;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Image;

import gui.AboutFrame;
import gui.FileFrame;
import gui.HelpFrame;
import gui.MainFrame;
import gui.MiscConsole;
import gui.ParameterFrame;
import gui.SettingsFrame;
import gui.RandomTestFrame;

public class MainController implements SelectionListener {
	private ExecutionHandler executionHandler;

	private MainFrame mainframe;
	private SettingsController settingsController;
	private HelpController helpController;
	private ParameterController parameterContoller;
	private EditorController editorController;
	private TableViewController tableController;

	public MainController() {
		MessageSystem messagesystem = new MessageSystem();
		this.executionHandler = new ExecutionHandler(messagesystem);
		Editor editor = new Editor();
		this.mainframe = new MainFrame(this, editor, messagesystem);
		this.editorController = new EditorController(editor, this.mainframe.getEditor());
		this.settingsController = new SettingsController(Settings.getInstance());
		this.helpController = new HelpController(Help.getInstance(), this.mainframe.getHelpBox());
		this.parameterContoller = new ParameterController(this.executionHandler, 
				(MiscConsole) this.mainframe.getConsole()[2]);
		this.tableController = new TableViewController(this.mainframe.getBreakpointView(), 
				this.mainframe.getVarView(), this.executionHandler);

		// Has to be the last call in the constructor
		initMainFrame();
	}

	private void initMainFrame() {
		/*
		 * Very important to call this in a separated method because SWT uses an
		 * infinite loop for its window management and we need the instance of
		 * MainFrame.
		 */
		this.mainframe.openWindow();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		// frame events
		if (e.getSource() == this.mainframe.getMenuBar().getMenuBarItemExit()) {
			System.exit(0);
		} else if (e.getSource() == mainframe.getMenuBar().getMenuBarItemLoad()) {
			FileFrame openFileFrame = new FileFrame(this.mainframe.getShell(), SWT.OPEN);
			if (openFileFrame.getChosenFile() != null) {
				String fileText = getFileAsString(openFileFrame.getChosenFile());
				if (fileText != null) {
					this.mainframe.getEditor().setText(fileText);
				}
			}
		} else if (e.getSource() == mainframe.getMenuBar().getMenuBarItemSave()) {
			FileFrame saveFileFrame = new FileFrame(this.mainframe.getShell(), SWT.SAVE);
			if (saveFileFrame.getChosenFile() != null) {
				writeStringToFile(this.mainframe.getEditor().getText(), saveFileFrame.getChosenFile());
			}
		} else if (e.getSource() == mainframe.getMenuBar().getMenuBarItemNewFile()) {
			this.mainframe.getEditor().setText("");
		} else if (e.getSource() == mainframe.getMenuBar().getMenuBarItemSettings()) {
			new SettingsFrame(this.mainframe.getShell(), this.settingsController);
		} else if (e.getSource() == mainframe.getMenuBar().getMenuBarItemRandomTest()) {
			RandomTestFrame randomtestframe = new RandomTestFrame(this.mainframe.getShell());
			this.parameterContoller.addRandomTestFrame(randomtestframe, this.editorController.getEditor().getSource());
		} else if (e.getSource() == mainframe.getMenuBar().getMenurBarItemAbout()) {
			new AboutFrame(this.mainframe.getShell());
		} else if (e.getSource() == mainframe.getMenuBar().getMenuBarItemHelp()) {
			new HelpFrame(this.mainframe.getShell(), this.helpController);
		} else if (e.getSource() == mainframe.getMenuBar().getMenurBarItemUndo()) {
			this.editorController.getEditor().undo();
		} else if (e.getSource() == mainframe.getMenuBar().getMenuBarItemRedo()) {
			this.editorController.getEditor().redo();
		}

		// button events
		else if (e.getSource() == this.mainframe.getRunButton() 
				|| e.getSource() == this.mainframe.getMenuBar().getMenuBarItemRun()) {
			assert editorController != null;
			this.executionHandler.setPaused(false);
			if (this.executionHandler.getAST() == null) {
				this.tableController.getVarView().getVarTree().removeAll();
				this.executionHandler.parse(this.editorController.getEditor().getSource());
				if (this.executionHandler.getAST() != null) {
					ParameterFrame parameterframe = new ParameterFrame(this.mainframe.getShell());
					parameterContoller.addParameterFrame(parameterframe);
				} else {
					return;
				}
			}			
			this.runView();
			
			// Execution
			new Thread() {
				public void run() {
					while (!parameterContoller.getParameterframe().getShell().isDisposed()
							&& !(executionHandler.getAST().getMainFunction().getParameters() == null
							|| executionHandler.getAST().getMainFunction().getParameters().length == 0)) {
						try {
							sleep(100);
						} catch (InterruptedException ignored) {
						}
					}
					executionHandler.run(editorController.getEditor().getStatementBreakpoints(),
							executionHandler.getGlobalBreakpoints());
					mainframe.getDisplay().asyncExec(new Runnable() {
						public void run() {
							if (executionHandler.getAssertionFailureMessage() != null) {
								executionHandler.printAssertionFailureMessage();
								stopView();
								return;
							}
							if (executionHandler.getPaused()) {
								pauseView();
							}
							else {
								stopView();
							}
						}
					});
				}
			}.start();
		} else if (e.getSource() == this.mainframe.getStepButton() 
				|| e.getSource() == this.mainframe.getMenuBar().getMenuBarItemStep()) {
			// Functions
			assert editorController != null;
			if (this.executionHandler.getAST() == null) {
				this.tableController.getVarView().getVarTree().removeAll();
				this.executionHandler.parse(this.editorController.getEditor().getSource());
				if (this.executionHandler.getAST() != null) {
					ParameterFrame parameterframe = new ParameterFrame(this.mainframe.getShell());
					this.parameterContoller.addParameterFrame(parameterframe);
				} else {
					return;
				}
			}
			this.pauseView();
			
			// Execution
			new Thread() {
				public void run() {
					while (!parameterContoller.getParameterframe().getShell().isDisposed()
							&& !(executionHandler.getAST().getMainFunction().getParameters() == null
							|| executionHandler.getAST().getMainFunction().getParameters().length == 0)) {
						try {
							sleep(100);
						} catch (InterruptedException ignored) {
						}
					}
					executionHandler.singleStep(editorController.getEditor().getStatementBreakpoints(),
							executionHandler.getGlobalBreakpoints());
					mainframe.getDisplay().asyncExec(new Runnable() {
						public void run() {
							if (executionHandler.getAssertionFailureMessage() != null) {
								executionHandler.printAssertionFailureMessage();
								stopView();
								return;
							}
							tableController.updateVarView();
							if (executionHandler.getProgramExecution() != null
									&& executionHandler.getProgramExecution().getCurrentState().getCurrentStatement() == null) {
								stopView();
							}
						}
					});
				}
			}.start();
		} else if (e.getSource() == mainframe.getPauseButton()) {
			this.executionHandler.setPaused(true);
		} else if (e.getSource() == mainframe.getStopButton()) {
			this.stopView();
		} else if (e.getSource() == mainframe.getCheckSyntaxButton()) {
			// Functions
			assert editorController != null;
			this.executionHandler.parse(this.editorController.getEditor().getSource());
			this.executionHandler.setAST(null);
		} else if (e.getSource() == mainframe.getValidateButton()) {
			this.executionHandler.verify(this.editorController.getEditor().getSource());
		}
	}

	private void runView() {
		//Functions
		this.editorController.removeMark();
		// Images
		Image image = new Image(this.mainframe.getDisplay(), 
				MainFrame.class.getResourceAsStream("image/run2.png"));
		Image image2 = new Image(this.mainframe.getDisplay(),
				MainFrame.class.getResourceAsStream("image/pause1.png"));
		this.mainframe.switchIcon(image, image2);
		// (De-)activations
		this.mainframe.getPauseButton().setEnabled(true);
		this.mainframe.getStepButton().setEnabled(false);
		this.mainframe.getStopButton().setEnabled(true);
		this.mainframe.getCheckSyntaxButton().setEnabled(false);
		this.tableController.activateVarView();
		this.tableController.deactivateBreakpointView();
		this.tableController.getVarView().getVarTree().removeAll();
		this.editorController.deactivateView();
	}
	
	private void pauseView() {
		// Functions
		this.tableController.updateVarView();
		this.editorController.removeMark();
		if (this.executionHandler.getProgramExecution() != null) {
			int line = this.executionHandler.getProgramExecution().getCurrentState().getCurrentStatement().getPosition().getLine();
			this.editorController.markCurrentLine(line);
		}
		// Images
		Image image = new Image(this.mainframe.getDisplay(), 
				MainFrame.class.getResourceAsStream("image/run1.png"));
		Image image2 = new Image(this.mainframe.getDisplay(),
				MainFrame.class.getResourceAsStream("image/pause2.png"));
		// (De-)activations
		this.mainframe.switchIcon(image, image2);
		this.mainframe.getStepButton().setEnabled(true);
		this.mainframe.getPauseButton().setEnabled(false);
		this.mainframe.getStopButton().setEnabled(true);
		this.mainframe.getCheckSyntaxButton().setEnabled(false);
		this.editorController.deactivateView();
		this.tableController.activateVarView();
		this.tableController.deactivateBreakpointView();
	}
	
	private void stopView() {
		// Functions
		this.editorController.removeMark();
		this.tableController.updateVarView();
		this.executionHandler.destroyProgramExecution();
		this.executionHandler.setParameterValues(null);
		this.executionHandler.setAST(null);
		// Images
		Image image = new Image(this.mainframe.getDisplay(), 
				MainFrame.class.getResourceAsStream("image/run1.png"));
		Image image2 = new Image(this.mainframe.getDisplay(), 
				MainFrame.class.getResourceAsStream("image/pause1.png"));
		this.mainframe.switchIcon(image, image2);
		// (De-)activations
		this.mainframe.getStopButton().setEnabled(false);
		this.mainframe.getPauseButton().setEnabled(false);
		this.mainframe.getStepButton().setEnabled(true);
		this.mainframe.getCheckSyntaxButton().setEnabled(true);
		this.tableController.deactivateVarView();
		this.tableController.activateBreakpointView();
		this.editorController.activateView();
	}

	private static String getFileAsString(File file) {
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String line = null;
		String fileText = new String();
		try {
			while ((line = fileReader.readLine()) != null) {
				fileText += line + '\n';
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return fileText;
	}

	private static void writeStringToFile(String content, File file) {
		BufferedWriter fileWriter = null;
		try {
			fileWriter = new BufferedWriter(new FileWriter(file));
			fileWriter.write(content);
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
	}
}
