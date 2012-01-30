package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * This class represents a frame which shows the "About" content.
 */
public class AboutFrame extends Frame implements MiscFrame {
	/**
	 * shell of the frame
	 */
	private Shell shell;

	/**
	 * Construct an about frame with the specified shell.
	 * @param parentShell specified shell
	 */
	public AboutFrame(Shell parentShell) {		
		shell = new Shell(parentShell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setSize(350,300);
		shell.setText("About");
		
		//Set the layout
		GridLayout gLayout = new GridLayout();
		gLayout.marginTop = 20;
		gLayout.marginWidth = 15;
		shell.setLayout(gLayout);
		
		//Add various components
		GridData gData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		Label l1 = new Label(this.shell, SWT.NONE);
		l1.setText("Praxis der Softwareentwicklung");
		l1.setFont(new Font(parentShell.getDisplay(), "", 16, SWT.BOLD) );
		l1.setForeground(new Color(parentShell.getDisplay(), 140, 140, 140));
		l1.setLayoutData(gData);
		Label l2 = new Label(this.shell, SWT.NONE);
		l2.setText("Projekt 3, Gruppe 1");
		l2.setFont(new Font(parentShell.getDisplay(), "", 14, SWT.BOLD) );
		l2.setForeground(new Color(parentShell.getDisplay(), 140, 140, 140));
		gData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		l2.setLayoutData(gData);		
		new Label(this.shell, SWT.NONE);
		Image image = new Image(parentShell.getDisplay(), MainFrame.class.getResourceAsStream("image/kitlogo.png"));
		Label l3 = new Label(this.shell, SWT.NONE);
		l3.setImage(image);
		gData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		l3.setLayoutData(gData);
		Label l4 = new Label(this.shell, SWT.NONE);
		l4.setText("WS 2011/2012");
		l4.setForeground(new Color(parentShell.getDisplay(), 140, 140, 140));
		l4.setFont(new Font(parentShell.getDisplay(), "", 14, SWT.BOLD ) );
		gData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		l4.setLayoutData(gData);
		shell.open();
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
