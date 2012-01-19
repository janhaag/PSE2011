package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class AboutFrame extends Frame implements MiscFrame {
	private Shell shell;

	public AboutFrame(Shell parentShell) {
		
		shell = new Shell(parentShell);
		shell.setSize(200,200);
		shell.setText("About");
		shell.setLayout(new FillLayout());
		
		new Label(this.shell, SWT.NONE).setText("PSE 2011/2012");
		
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
