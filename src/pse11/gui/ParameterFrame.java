package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ast.FunctionParameter;

/**
 * This class represents a frame for main() parameter inputs. 
 */
public class ParameterFrame extends Frame implements MiscFrame {
	/**
	 * shell of the frame
	 */
	private Shell shell;
	/**
	 * text fields for parameter values
	 */
	private Text[] values;
	/**
	 * button for execution start
	 */
	private Button okButton;

	/**
	 * Construct a parameter frame with the specified parent shell.
	 * @param parentShell specified shell
	 */
	public ParameterFrame(Shell parentShell) {	
		shell = new Shell(parentShell, SWT.SHELL_TRIM | SWT.APPLICATION_MODAL);
		shell.setText("Parameter");
		
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 4;
		gLayout.marginTop = 10;
		gLayout.marginLeft = 10;
		gLayout.marginRight = 10;
		shell.setLayout(gLayout);
		
		Label label = new Label(this.shell, SWT.NONE);
		label.setText("Please insert parameter values for the");	
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 4;
		label.setLayoutData(gData);
		Label label2 = new Label(this.shell, SWT.NONE);
		label2.setText("main function:");	
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 4;
		label2.setLayoutData(gData);
		Label label3 = new Label(this.shell, SWT.NONE);
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 4;
		label3.setLayoutData(gData);	
		
		this.shell.addListener(SWT.Close, new Listener() {
			@Override
			public void handleEvent(Event event) {
			event.doit = false;
			}
		});
	}
	
	/**
	 * Add attributes to the shell of the frame and open it. The size
	 * of the shell depends on the number of parameters.
	 * @param parameters list of parameters
	 */
	public void createFrame(FunctionParameter[] parameters) {
		if (parameters == null) {
			return;
		}
		this.values = new Text[parameters.length];
		this.shell.setSize(250, 180 + 20 * parameters.length);
		GridData gData;
		
		for (int i = 0; i < parameters.length; i++) {
			new Label(this.shell, SWT.NONE).setText(parameters[i].toString());
			Text value = new Text(this.shell, SWT.NONE);
			gData = new GridData(GridData.FILL_HORIZONTAL);
			gData.horizontalSpan = 3;
			value.setLayoutData(gData);	
			this.values[i] = value;
		}
		
		Label label = new Label(this.shell, SWT.NONE);
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 4;
		label.setLayoutData(gData);
		this.okButton = new Button(this.shell, SWT.NONE);
		this.okButton.setText("OK");
		gData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		gData.horizontalSpan = 4;
		this.okButton.setLayoutData(gData);
		
		if (parameters.length > 0) {
			this.shell.open();
		}	
	}

	/**
	 * Return the shell of the frame.
	 * @return shell of the frame
	 */
	public Shell getShell() {
		return this.shell;
	}
	
	/**
	 * Return the text fields of the frame.
	 * @return text fields of the frame
	 */
	public Text[] getValues() {
		return this.values;
	}
	
	/**
	 * Return the start execution button of the frame.
	 * @return button of the frame
	 */
	public Button getOkButton() {
		return this.okButton;
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
	}

}
