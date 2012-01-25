package gui;

import java.io.IOException;

import gui.controller.MainController;

import misc.Editor;
import misc.MessageSystem;
import misc.Settings;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class MainFrame extends Frame {	
	private Display display;
	private Shell shell;
	private MenuBar menubar;
	private EditorView editor;
	private Button checkSyntaxButton;
	private Button runButton;
	private Button stepButton;
	private Button pauseButton;
	private Button stopButton;
	private Button validateButton;
	private Label pauseIcon;
	private Label runIcon;
	private Console console[];
	private VariableView varView;
	private BreakpointView breakpointView;
	private HelpBox help;
	
	public MainFrame(MainController mainController, Editor editor, MessageSystem messagesystem) {
		//Initialization and Configuration of the window
		display = new Display();
		shell = new Shell(display);
		shell.setSize(950,650);
		shell.setText(SHELLTITLE);
		
		//Setting layout
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 4;
		gLayout.makeColumnsEqualWidth = true;
		shell.setLayout(gLayout);
		
		//Adding menu bar
		menubar = new MenuBar(mainController, shell);
		
		Composite c1 = new Composite(shell, SWT.NONE);
		gLayout = new GridLayout();
		gLayout.numColumns = 20;
		gLayout.makeColumnsEqualWidth = true;
		c1.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan = 3;
		c1.setLayoutData(gData);
		
		//Adding editor
		this.editor = new EditorView(c1, SWT.BORDER, editor);
		gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan = 20;
		this.editor.setLayoutData(gData);
		
		//Adding buttons
		this.checkSyntaxButton = new Button(c1, SWT.PUSH);
		this.checkSyntaxButton.setText("Check Syntax");
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 3;
		this.checkSyntaxButton.setLayoutData(gData);
		
		this.runButton = new Button(c1, SWT.PUSH);
		this.runButton.setText("Run");
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 3;
		this.runButton.setLayoutData(gData);
		
		this.stepButton = new Button(c1, SWT.PUSH);
		this.stepButton.setText("Single Step");
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 3;
		this.stepButton.setLayoutData(gData);
		
		this.pauseButton = new Button(c1, SWT.PUSH);
		this.pauseButton.setText("Pause");
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 3;
		this.pauseButton.setLayoutData(gData);
		this.pauseButton.setEnabled(false);
		
		this.stopButton = new Button(c1, SWT.PUSH);
		this.stopButton.setText("Stop");
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 3;
		this.stopButton.setLayoutData(gData);
		this.stopButton.setEnabled(false);
		
		this.validateButton = new Button(c1, SWT.PUSH);
		this.validateButton.setText("Validate");
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 3;
		this.validateButton.setLayoutData(gData);
		
		this.checkSyntaxButton.addSelectionListener(mainController);
		this.runButton.addSelectionListener(mainController);
		this.stepButton.addSelectionListener(mainController);
		this.validateButton.addSelectionListener(mainController);
		this.pauseButton.addSelectionListener(mainController);
		this.stopButton.addSelectionListener(mainController);
		
		//Adding icons
		this.pauseIcon = new Label(c1, SWT.NONE);
		Image image1 = new Image(display, MainFrame.class.getResourceAsStream("image/pause1.png"));
		this.pauseIcon.setImage(image1);
		gData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		this.pauseIcon.setLayoutData(gData);
		
		this.runIcon = new Label(c1, SWT.NONE);
		Image image2 = new Image(display, MainFrame.class.getResourceAsStream("image/run1.png"));
		this.runIcon.setImage(image2);
		gData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		this.runIcon.setLayoutData(gData);
		
	    //Create a composite for variable view and breakpoint view
	    Composite c2 = new Composite(shell, SWT.NONE); 
	    gLayout = new GridLayout();
	    c2.setLayout(gLayout);
	    gData = new GridData(GridData.FILL_BOTH);
	    c2.setLayoutData(gData);
	    
		//Adding variable view
		new Label(c2, SWT.NONE).setText("Variables");
		this.varView = new VariableView(c2, SWT.NONE);
		gData = new GridData(GridData.FILL_BOTH);
		this.varView.setLayoutData(gData);		
		
		//Adding breakpoint view		
		new Label(c2, SWT.NONE).setText("Global Breakpoints");
		this.breakpointView = new BreakpointView(c2, SWT.NONE);				
		gData = new GridData(GridData.FILL_BOTH);
		this.breakpointView.setLayoutData(gData);
		
		//Adding consoles
		this.console = new Console[3];
		TabFolder tf = new TabFolder(shell, SWT.NONE);
		gData = new GridData(GridData.FILL_BOTH);
		gData = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL);
		gData.horizontalSpan = 3;
	    tf.setLayoutData(gData);
	    
		TabItem ti1 = new TabItem(tf, SWT.BORDER);
		ti1.setText("Errors");
		ti1.setControl(console[0] = new ErrorConsole(tf, SWT.BORDER, messagesystem));
		TabItem ti2 = new TabItem(tf, SWT.BORDER);
		ti2.setText("Verifier");
		ti2.setControl(console[1] = new VerifierConsole(tf, SWT.BORDER, messagesystem));
		TabItem ti3 = new TabItem(tf, SWT.BORDER);
		ti3.setText("Misc");
		ti3.setControl(console[2] = new MiscConsole(tf, SWT.BORDER, messagesystem));
		
		//Adding help box
		help = new HelpBox(shell, SWT.BORDER, editor);
		gData = new GridData(GridData.FILL_HORIZONTAL);
	    help.setLayoutData(gData);
	}
	
	public void switchIcon(Image image, Image image2) {
		this.runIcon.setImage(image);
		this.pauseIcon.setImage(image2);
	}
	
	public Shell getShell() {
		return this.shell;
	}
	
	public Display getDisplay() {
		return this.display;
	}
	
	public MenuBar getMenuBar() {
		return this.menubar;
	}
	
	public EditorView getEditor() {
		return this.editor;
	}
	
	public VariableView getVarView() {
		return this.varView;
	}
	
	public BreakpointView getBreakpointView() {
		return this.breakpointView;
	}
	
	public Button getCheckSyntaxButton() {
		return this.checkSyntaxButton;
	}
	
	public Button getRunButton() {
		return this.runButton;
	}
	
	public Button getStepButton() {
		return this.stepButton;
	}
	
	public Button getValidateButton() {
		return this.validateButton;
	}
	
	public Button getPauseButton() {
		return this.pauseButton;
	}
	
	public Button getStopButton() {
		return this.stopButton;
	}
	
	public HelpBox getHelpBox() {
		return this.help;
	}
	
	public void openWindow() {
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		//Save modified settings
		if(Settings.getInstance().settingsChanged()) {
			try {
				Settings.getInstance().saveSettings();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static final String SHELLTITLE = "PSE";

	
}
