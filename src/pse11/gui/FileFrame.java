package gui;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class FileFrame extends Frame implements MiscFrame {
	private Shell shell;

	public FileFrame(Shell parentShell, int def) {
		shell = new Shell(parentShell);
		
		FileDialog dlg = new FileDialog(shell, def);
	    String fileName = dlg.open();
	    if (fileName != null) {
	      System.out.println(fileName);
	    }
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
