package gui;

import gui.controller.MainController;

import misc.MessageSystem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class MainFrame extends Frame {
	private Display display;
	private Shell shell;
	private MenuBar menubar;
	private EditorView editor;
	private Console console[];
	public MainFrame(MainController controller) {
		//Initialization and Configuration of the window
		display = new Display();
		shell = new Shell(display);
		shell.setSize(700,500);
		shell.setText(SHELLTITLE);
		
		//Adding menu bar
		menubar = new MenuBar(controller, shell);
		//Adding editor
		editor = new EditorView(shell, SWT.BORDER);
		
		//Adding consoles
		MessageSystem messagesystem = new MessageSystem();
		this.console = new Console[3];
		TabFolder tf = new TabFolder(shell, SWT.NONE);
		tf.setBounds(0,320,500,300);
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
	
	private final static String SHELLTITLE = "PSE";
}
