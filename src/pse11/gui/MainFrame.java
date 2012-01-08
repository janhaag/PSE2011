package gui;

import gui.controller.BreakpointViewController;
import gui.controller.EditorController;
import gui.controller.MainController;
import gui.controller.VariableViewController;

import misc.Editor;
import misc.MessageSystem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class MainFrame extends Frame {
	private Display display;
	private Shell shell;
	private MenuBar menubar;
	private EditorView editor;
	private Console console[];
	private VariableView varView;
	private BreakpointView breakpointView;
	
	public MainFrame(MainController controller) {
		//Initialization and Configuration of the window
		display = new Display();
		shell = new Shell(display);
		shell.setSize(800,600);
		shell.setText(SHELLTITLE);
		
		//Setting layout
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 4;
		gLayout.makeColumnsEqualWidth = true;
		shell.setLayout(gLayout);
		
		//Adding menu bar
		menubar = new MenuBar(controller, shell);
		
		//Adding editor view and controller
		Editor editor = new Editor();
		this.editor = new EditorView(shell, SWT.BORDER, editor);
		GridData gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan = 3;
		this.editor.setLayoutData(gData);	
		EditorController editorController = new EditorController(editor, this.editor);
		
	    // Create a composite for variable view and breakpoint view
	    Composite composite = new Composite(shell, SWT.NONE); 
	    gLayout = new GridLayout();
	    composite.setLayout(gLayout);
	    gData = new GridData(GridData.FILL_BOTH);
	    composite.setLayoutData(gData);
	    
		//Adding variable view and controller 
		new Label(composite, SWT.NONE).setText("Variables");
		this.varView = new VariableView(composite, SWT.NONE);
		gData = new GridData(GridData.FILL_BOTH);
		this.varView.setLayoutData(gData);
		VariableViewController varController = new VariableViewController(this.varView);
		
		
		//Adding breakpoint view and controller			
		 new Label(composite, SWT.NONE).setText("Breakpoints");
	    BreakpointViewController breakpointController = new BreakpointViewController();	 	    
		this.breakpointView = new BreakpointView(composite, SWT.NONE, breakpointController);			
		breakpointController.addView(this.breakpointView);		
		gData = new GridData(GridData.FILL_BOTH);
		this.breakpointView.setLayoutData(gData);
		
		//Adding consoles
		MessageSystem messagesystem = new MessageSystem();
		this.console = new Console[3];
		TabFolder tf = new TabFolder(shell, SWT.NONE);
		gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan = 3;
		gData.verticalSpan = 30;
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
		//TODO WEG!
		messagesystem.notifyConsoles();
		
		//Adding help box
		HelpBox help = new HelpBox(shell, SWT.BORDER, editor);
		gData = new GridData(GridData.FILL_BOTH);
		gData.verticalSpan = 30;
	    help.setLayoutData(gData);
	}
	public Shell getShell() {
		return this.shell;
	}
	public MenuBar getMenuBar() {
		return menubar;
	}
	public void openWindow() {
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private static final String SHELLTITLE = "PSE";
}
