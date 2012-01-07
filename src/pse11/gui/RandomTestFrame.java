package gui;

import gui.controller.MiscController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RandomTestFrame extends Frame implements MiscFrame{
	private MiscController controller;
	Shell shell;
	private Text intervalTextField1;
	private Text intervalTextField2;
	private Button testButton;
	
	public RandomTestFrame(Shell parentShell) {
		this.controller = new MiscController(this);
		
		this.shell = new Shell();
		this.shell.setSize(300,250);
		this.shell.setText("Random test");
		
		//Setting layout
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.makeColumnsEqualWidth = true;
		gridLayout.marginTop = 20;
		gridLayout.marginLeft = 20;
		gridLayout.marginBottom = 20;
		gridLayout.marginRight = 20; 
		this.shell.setLayout(gridLayout);
		
		Label label = new Label(this.shell, SWT.NONE);
		label.setText("Number interval for the random test");
		GridData gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan = 3;
		label.setLayoutData(gData);
		
		new Label(this.shell, SWT.NONE).setText("Begin:");
		this.intervalTextField1 = new Text(this.shell, SWT.SINGLE);
		gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan = 2;
		this.intervalTextField1.setLayoutData(gData);
		new Label(this.shell, SWT.NONE).setText("End:");
		this.intervalTextField2 = new Text(this.shell, SWT.SINGLE);
		this.intervalTextField2.setLayoutData(gData);
		
		this.testButton = new Button(shell, SWT.PUSH);
		this.testButton.setText("Start test");
		gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan = 3;
		this.testButton.setLayoutData(gData);

		this.shell.open();
	}
	
	@Override
	public Button getSaveButton() {
		return null;
	}
	
	@Override
	public void close() {
		this.shell.close();
	}

	@Override
	public Button getCloseButton() {
		// TODO Auto-generated method stub
		return null;
	}
}
