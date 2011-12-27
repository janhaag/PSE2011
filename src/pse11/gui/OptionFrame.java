package gui;

import gui.controller.MiscController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class OptionFrame extends Frame implements MiscFrame {
	private MiscController controller;
	Shell shell;
	private Text memoryLimitTextField;
	private Text timeoutTextField;
	private Button saveButton;
	private Button closeButton;
	public OptionFrame(Shell parentShell) {
		this.controller = new MiscController(this);
		
		this.shell = new Shell();
		this.shell.setSize(300,300);
		
		this.memoryLimitTextField = new Text(this.shell, SWT.SINGLE);
		this.memoryLimitTextField.setBounds(10,10,100,20);
		
		this.saveButton = new Button(shell, SWT.PUSH);
		this.saveButton.setBounds(50,50,75,40);
		this.saveButton.setText("Save");
		this.saveButton.addSelectionListener(controller);
		this.closeButton = new Button(shell, SWT.PUSH);
		this.closeButton.setBounds(150,50,75,40);
		this.closeButton.setText("Close");
		this.closeButton.addSelectionListener(controller);
		
		this.shell.open();
	}
	@Override
	public Button getSaveButton() {
		return this.saveButton;
	}
	@Override
	public Button getCloseButton() {
		return this.closeButton;
	}
	@Override
	public void close() {
		this.shell.close();
	}
}
