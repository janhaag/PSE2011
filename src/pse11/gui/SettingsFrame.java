package gui;

import gui.controller.SettingsController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class SettingsFrame extends Frame {
	private SettingsController controller;
	Shell shell;
	private Text memoryLimitTextField;
	private Text timeoutTextField;
	private Button saveButton;
	private Button closeButton;
	private Label errorLabel;
	
	public SettingsFrame(Shell parentShell, SettingsController controller) {
		this.controller = controller;
		this.controller.addView(this);
		
		this.shell = new Shell();
		this.shell.setSize(300,260);
		this.shell.setText("Settings");
		
		//Setting layout
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
//		gridLayout.makeColumnsEqualWidth = true;
		gridLayout.marginTop = 20;
		gridLayout.marginLeft = 20;
		gridLayout.marginRight = 20;
		this.shell.setLayout(gridLayout);
		
		//Add the group
		final Group settingsGroup = new Group(this.shell, SWT.SHADOW_ETCHED_IN);
		settingsGroup.setText("Settings for Z3");
		gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.makeColumnsEqualWidth = true;
		gridLayout.marginTop = 10;
		gridLayout.marginLeft = 10;
		gridLayout.marginRight = 10;
		settingsGroup.setLayout(gridLayout);
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 2;
		settingsGroup.setLayoutData(gData);
		
		/*Label label = new Label(this.shell, SWT.NONE);
		label.setText("Settings for Z3");
		GridData gData = new GridData();
		gData.horizontalSpan = 3;
		gData.verticalSpan = 10;
		label.setLayoutData(gData);*/
		
		new Label(settingsGroup, SWT.NONE).setText("Timeout:");
		this.timeoutTextField = new Text(settingsGroup, SWT.SINGLE | SWT.RIGHT);
		this.timeoutTextField.setText(controller.getTimeOut());
		gData = new GridData(GridData.FILL_HORIZONTAL);
		this.timeoutTextField.setLayoutData(gData);
		new Label(settingsGroup, SWT.NONE).setText("sec");
		
		new Label(settingsGroup, SWT.NONE).setText("Memory limit:");
		this.memoryLimitTextField = new Text(settingsGroup, SWT.SINGLE | SWT.RIGHT);
		this.memoryLimitTextField.setText(controller.getMemoryLimit());
		this.memoryLimitTextField.setLayoutData(gData);
		new Label(settingsGroup, SWT.NONE).setText("KB");
		
		this.saveButton = new Button(shell, SWT.PUSH);
		this.saveButton.setText(" Save ");
		this.closeButton = new Button(shell, SWT.PUSH);
		this.closeButton.setText(" Close ");
		
		//Position of Buttons
		gData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gData.verticalSpan = 10;
		this.saveButton.setLayoutData(gData);
		this.closeButton.setLayoutData(gData);
		
		//Add label for error message
		this.errorLabel = new Label(this.shell, SWT.BORDER | SWT.BORDER_DOT);
		this.errorLabel.setForeground(new Color(this.shell.getDisplay(), new RGB(0, 0, 0)));
//		this.errorLabel.setFont(new Font(this.shell.getDisplay(), "arial", 10, SWT.BOLD));
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 2;
		gData.verticalSpan = 1;
		gData.minimumHeight = 100;
		this.errorLabel.setLayoutData(gData);
		this.errorLabel.setVisible(false);
		
		//Add event listeners
		this.saveButton.addSelectionListener(this.controller.getSaveButtonListener());
		this.closeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
	    
		this.shell.open();
	}
	public void close() {
		this.shell.close();
	}
	public Button getSaveButton() {
		return this.saveButton;
	}
	public Button getCloseButton() {
		return this.closeButton;
	}
	public Text getMemoryLimitTextField() {
		return this.memoryLimitTextField;
	}
	public Text getTimeoutTextField() {
		return this.timeoutTextField;
	}
	public void update() {
		this.memoryLimitTextField.setText(this.controller.getMemoryLimit());
		this.timeoutTextField.setText(this.controller.getTimeOut());
	}
	public void displayMessage(boolean error, String msg) {
		this.errorLabel.setText(msg);
		if(error) {
			this.errorLabel.setBackground(new Color(this.shell.getDisplay(), new RGB(255, 0, 0)));
		} else {
			this.errorLabel.setBackground(new Color(this.shell.getDisplay(), new RGB(0, 255, 0)));
		}
		this.errorLabel.setVisible(true);
	}
}
