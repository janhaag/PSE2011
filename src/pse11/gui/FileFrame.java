package gui;

import gui.controller.MiscController;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;

public class FileFrame extends Frame implements MiscFrame {
	private MiscController controller;
	private Shell shell;

	public FileFrame(Shell parentShell) {
		this.controller = new MiscController(this);
		
		shell = new Shell(parentShell);
		shell.setSize(200,200);
		shell.setText("File");
		shell.setLayout(new FillLayout());
		
		shell.open();
	}
	@Override
	public Button getSaveButton() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Button getCloseButton() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void close() {
		this.shell.close();
	}
}
