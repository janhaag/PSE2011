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
		//Please mind >all< components before resizing the view
		this.shell.setSize(300,240);
		this.shell.setText("Settings");
		
		//Setting layout
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		gLayout.makeColumnsEqualWidth = true;
		gLayout.marginTop = 20;
		gLayout.marginLeft = 20;
		gLayout.marginRight = 20;
		this.shell.setLayout(gLayout);
		
		//Add the group
		final Group settingsGroup = new Group(this.shell, SWT.SHADOW_ETCHED_IN);
		settingsGroup.setText("Settings for Z3");
		gLayout = new GridLayout();
		gLayout.numColumns = 3;
		gLayout.makeColumnsEqualWidth = true;
		gLayout.marginTop = 10;
		gLayout.marginLeft = 10;
		gLayout.marginRight = 10;
		settingsGroup.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 2;
		settingsGroup.setLayoutData(gData);
		
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
		
		//Add buttons
		final Composite buttoncomposite = new Composite(this.shell, SWT.NONE);
		final GridLayout buttonlayout = new GridLayout();
		buttonlayout.numColumns = 2;
		buttoncomposite.setLayout(buttonlayout);
		this.saveButton = new Button(buttoncomposite, SWT.PUSH);
		this.saveButton.setText(" Save ");
		this.closeButton = new Button(buttoncomposite, SWT.PUSH);
		this.closeButton.setText(" Close ");
		gData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		gData.verticalSpan = 10;
		gData.horizontalSpan = 2;
		buttoncomposite.setLayoutData(gData);
		
		//Add label for error message
		//TODO Some work on the "layout"/design
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
