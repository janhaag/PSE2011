package gui;

import gui.controller.EditorController;
import gui.controller.MainController;

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
	private BreakpointView breakView;
	
	public MainFrame(MainController controller) {
		//Initialization and Configuration of the window
		display = new Display();
		shell = new Shell(display);
		shell.setSize(700,500);
		shell.setText(SHELLTITLE);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		gridLayout.makeColumnsEqualWidth = true;
		shell.setLayout(gridLayout);
		
		//Adding menu bar
		menubar = new MenuBar(controller, shell);
		
		//Adding editor
		Editor editor = new Editor();
		this.editor = new EditorView(shell, SWT.BORDER, editor);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 3;
		this.editor.setLayoutData(gridData);
		
		EditorController editorcontroller = new EditorController(editor, this.editor);
		
	    // Create a composite for tree view and breakpoint view
	    Composite composite = new Composite(shell, SWT.NONE); 
	    gridLayout = new GridLayout();
	    composite.setLayout(gridLayout);
	    gridData = new GridData(GridData.FILL_BOTH);
	    composite.setLayoutData(gridData);
	    
		//Adding variable view
	    new Label(composite, SWT.NONE).setText("Variables");
	    Tree tree = new Tree(composite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL 
				| SWT.MULTI | SWT.FULL_SELECTION);
		this.varView = new VariableView(composite, SWT.NONE, tree);
		this.varView.setLayoutData(gridData);
		
		//Adding breakpoint view
		new Label(composite, SWT.NONE).setText("Breakpoints");
		Table table = new Table (composite, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL 
				| SWT.H_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);
		this.breakView = new BreakpointView(composite, SWT.NONE, table);
		this.breakView.setLayoutData(gridData);
		
		//Adding consoles
		MessageSystem messagesystem = new MessageSystem();
		this.console = new Console[3];
		TabFolder tf = new TabFolder(shell, SWT.NONE);
		gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 3;
		gridData.verticalSpan = 30;
	    tf.setLayoutData(gridData);
	    
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
		gridData = new GridData(GridData.FILL_BOTH);
		gridData.verticalSpan = 30;
	    help.setLayoutData(gridData);
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
