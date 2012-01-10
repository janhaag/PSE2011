package gui;

import gui.controller.MiscController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class EvaluationFrame extends Frame implements MiscFrame {
	private MiscController controller;
	Shell shell;
	private Text statementTextField;
	private Text resultTextField;
	private Button evaluateButton;
	
	public EvaluationFrame(Shell parentShell) {
		this.controller = new MiscController(this);
		
		this.shell = new Shell();
		this.shell.setSize(300,250);
		this.shell.setText("Evaluate Statement");
		
		//Setting layout
		GridLayout gLayout = new GridLayout();
		gLayout.marginTop = 20;
		gLayout.marginLeft = 20;
		gLayout.marginBottom = 20;
		gLayout.marginRight = 20;
		this.shell.setLayout(gLayout);
		
		Label label = new Label(this.shell, SWT.NONE);
		label.setText("Please enter the statement:");
		
		this.statementTextField = new Text(this.shell, SWT.SINGLE);
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		this.statementTextField.setLayoutData(gData);
		
		this.evaluateButton = new Button(shell, SWT.PUSH);
		this.evaluateButton.setText("Evaluate");
		gData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		this.evaluateButton.setLayoutData(gData);
		
		new Label(this.shell, SWT.NONE).setText("Result:");
		this.resultTextField = new Text(this.shell, SWT.SINGLE);
		this.resultTextField.setEditable(false);
		this.resultTextField.setBackground(new Color(this.resultTextField.getDisplay(), 
				255, 255, 255));
		gData = new GridData(GridData.FILL_BOTH);
		gData.verticalSpan = 12;
		this.resultTextField.setLayoutData(gData);

		this.shell.open();
	}
	
	@Override
	public Button getSaveButton() {
		return this.evaluateButton;
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
