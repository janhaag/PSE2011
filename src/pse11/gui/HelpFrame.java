package gui;

import gui.controller.HelpController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/**
 * This class represents a frame for displaying the help documentation.
 */
public class HelpFrame extends Frame implements MiscFrame {
	private HelpController controller;
	private Shell shell;
	private List list;
	private Browser browser;
	private Button closeButton;

	/**
	 * Construct a help frame with the specified parent shell and controller.
	 * @param parentShell specified shell
	 * @param helpController specified controller
	 */
	public HelpFrame(Shell parentShell, HelpController helpController) {
		this.controller = helpController;
		controller.setHelpFrame(this);
		shell = new Shell(parentShell, SWT.SHELL_TRIM);
		shell.setText("Help");
		
		//Set the layout
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		shell.setLayout(layout);

		//Add various components
		list = new List(shell, SWT.SIMPLE);
		GridData listLayoutData = new GridData(SWT.FILL, SWT.FILL, false, false);
		listLayoutData.widthHint = 100;
		list.setLayoutData(listLayoutData);
		list.setItems(controller.getTableOfContents());
		list.addSelectionListener(controller.getHelpFrameListSelectionListener());

		try {
			browser = new Browser(shell, SWT.NONE);
		} catch (SWTError e) {
			// TODO: handle error nicely
			System.out.println("Could not instantiate Browser: " + e.getMessage());
			shell.dispose();
			return;
		}
		GridData browserLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		browserLayoutData.widthHint = 450;
		browserLayoutData.heightHint = 400;
		browser.setLayoutData(browserLayoutData);
		list.select(0);
		list.notifyListeners(SWT.Selection, new Event());
		// TODO: Browser location listener for links inside help documents

		closeButton = new Button(shell, SWT.PUSH);
		closeButton.setText("Close");
		GridData closeButtonLayoutData = new GridData(GridData.END, GridData.END, false, false);
		closeButtonLayoutData.horizontalSpan = 2;
		closeButton.setLayoutData(closeButtonLayoutData);

		this.closeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		
		shell.setMinimumSize(400, 320);
		shell.pack();
		shell.open();
	}
	
	/**
	 * Return the list of sections of the documentation.
	 * @return list of sections
	 */
	public List getList() {
		return list;
	}

	@Override
	public Button getSaveButton() {
		return null;
	}

	@Override
	public Button getCloseButton() {
		return closeButton;
	}

	@Override
	public void close() {
		this.shell.close();
	}

	public void setText(String helpByTOC) {
		this.browser.setText(helpByTOC);
	}
}
