package gui;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * This class represents a frame for open or save files.
 */
public class FileFrame extends Frame implements MiscFrame {
	/**
	 * shell of the frame
	 */
	private Shell shell;
	/**
	 * chosen file for load
	 */
	private File chosenFile;
	/**
	 * allowed file extensions for source code files
	 */
	private static final String[] fileExtensions = new String[]{"*.wp;*.txt"};

	/**
	 * Construct a file frame with the specified parent shell and 
	 * definitions about its behavior and style.
	 * @param parentShell specified shell
	 * @param def specified definitions
	 */
	public FileFrame(Shell parentShell, int def) {
		shell = new Shell(parentShell);
		chosenFile = null;
		String fileName = null;
		
		FileDialog dlg = new FileDialog(shell, def);
		dlg.setOverwrite(true);
		dlg.setFilterExtensions(fileExtensions);
		fileName = dlg.open();
		if (fileName != null) {
			File file = new File(fileName);
			if ((def == SWT.OPEN && file.canRead())
					|| (def == SWT.SAVE && (!file.exists() || (file.exists() && file.canWrite())))) {
				chosenFile = file;
			}
		}
	}

	/**
	 * Return the chosen file for load option.
	 * @return chosen file
	 */
	public File getChosenFile() {
		return chosenFile;
	}

	@Override
	public Button getSaveButton() {
		return null;
	}
	@Override
	public Button getCloseButton() {
		return null;
	}

	@Override
	public void close() {
		this.shell.close();
	}
}
