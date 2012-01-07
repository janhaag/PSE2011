package gui;

import gui.controller.MiscController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class OptionFrame extends Frame implements MiscFrame {
	private MiscController controller;
	Shell shell;
	private Text memoryLimitTextField;
	private Text timeoutTextField;
	private Button saveButton;
	private Button closeButton;
	
	private static String timeout;
	private static String memorylim;
	
	public OptionFrame(Shell parentShell) {
		this.controller = new MiscController(this);
		
		this.shell = new Shell();
		this.shell.setSize(300,250);
		this.shell.setText("Settings");
		
		//Setting layout
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.makeColumnsEqualWidth = true;
		gridLayout.marginTop = 20;
		gridLayout.marginLeft = 20;
		this.shell.setLayout(gridLayout);
		
		Label label = new Label(this.shell, SWT.NONE);
		label.setText("Settings for Z3");
		GridData gData = new GridData();
		gData.horizontalSpan = 3;
		gData.verticalSpan = 10;
		label.setLayoutData(gData);
		
		new Label(this.shell, SWT.NONE).setText("Timeout:");
		this.timeoutTextField = new Text(this.shell, SWT.SINGLE | SWT.RIGHT);
		if (timeout != null && timeout.length() != 0) {
			this.timeoutTextField.setText(timeout);
		}
		gData = new GridData(GridData.FILL_HORIZONTAL);
		this.timeoutTextField.setLayoutData(gData);
		new Label(this.shell, SWT.NONE).setText("sec");
		
		new Label(this.shell, SWT.NONE).setText("Memory limit:");
		this.memoryLimitTextField = new Text(this.shell, SWT.SINGLE | SWT.RIGHT);
		if (memorylim != null && memorylim.length() != 0) {
			this.memoryLimitTextField.setText(memorylim);
		}
		this.memoryLimitTextField.setLayoutData(gData);
		new Label(this.shell, SWT.NONE).setText("KB");
		
		this.saveButton = new Button(shell, SWT.PUSH);
		this.saveButton.setText(" Save ");
		this.saveButton.addSelectionListener(controller);
		this.closeButton = new Button(shell, SWT.PUSH);
		this.closeButton.setText(" Close ");
		this.closeButton.addSelectionListener(controller);
		
		//Position of Buttons
		gData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		gData.verticalSpan = 20;
		this.saveButton.setLayoutData(gData);
		this.closeButton.setLayoutData(gData);
		
		
		//Add events
	    this.saveButton.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent e) {
	        String time = timeoutTextField.getText();
	        String mem = memoryLimitTextField.getText();
	        if (time == null || time.length() == 0 
	        		||  mem == null || mem.length() == 0 ) {
	            return;
	        }	        
	        timeout = time;
	        memorylim = mem;
	      }
	    });
	    
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
