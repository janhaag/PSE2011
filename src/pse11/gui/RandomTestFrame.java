package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ast.ArrayType;
import ast.BooleanType;
import ast.FunctionParameter;
import ast.IntegerType;
import ast.Type;

public class RandomTestFrame extends Frame implements MiscFrame {
	private Shell shell;
	private Text count;
	private Text[][] intervals;
	private Button startButton;
	
	public RandomTestFrame(Shell parentShell) {
		this.shell = new Shell(parentShell);
		this.shell.setText("Random Test");
		
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 4;
		gLayout.makeColumnsEqualWidth = true;
		gLayout.marginTop = 10;
		gLayout.marginLeft = 10;
		gLayout.marginRight = 10;
		shell.setLayout(gLayout);
	}
	
	public void createFrame(FunctionParameter[] parameters) {
		Label label = new Label(this.shell, SWT.NONE);
		label.setText("Number of random tests: ");	
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 2;
		label.setLayoutData(gData);
		this.count = new Text(this.shell, SWT.NONE);
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 2;
		this.count.setLayoutData(gData);
		Label label2 = new Label(this.shell, SWT.NONE);
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 4;
		label2.setLayoutData(gData);
		new Label(this.shell, SWT.NONE).setText("ID");
		new Label(this.shell, SWT.NONE).setText("Begin");
		new Label(this.shell, SWT.NONE).setText("End");
		new Label(this.shell, SWT.NONE).setText("Array size");

		this.intervals = new Text[parameters.length][3];
		int i;
		for (i = 0; i < parameters.length; i++) {
			new Label(this.shell, SWT.NONE).setText(parameters[i].toString());
			Text begin = new Text(this.shell, SWT.NONE);
			gData = new GridData(GridData.FILL_HORIZONTAL);
			begin.setLayoutData(gData);	
			Text end = new Text(this.shell, SWT.NONE);
			gData = new GridData(GridData.FILL_HORIZONTAL);
			end.setLayoutData(gData);	
			Text size = new Text(this.shell, SWT.NONE);
			gData = new GridData(GridData.FILL_HORIZONTAL);
			size.setLayoutData(gData);
			
			if (parameters[i].getType() instanceof IntegerType) {
				size.setEditable(false);
				size.setBackground(new Color(this.shell.getDisplay(), 210, 210, 210));
			}
			else if (parameters[i].getType() instanceof BooleanType) {
				begin.setEditable(false);
				begin.setBackground(new Color(this.shell.getDisplay(), 210, 210, 210));
				end.setEditable(false);
				end.setBackground(new Color(this.shell.getDisplay(), 210, 210, 210));
				size.setEditable(false);
				size.setBackground(new Color(this.shell.getDisplay(), 210, 210, 210));
			}
			else if (parameters[i].getType() instanceof ArrayType) {
				Type tmp = parameters[i].getType();
				while (tmp instanceof ArrayType) {
					tmp = ((ArrayType) tmp).getType();
				}
				if (tmp instanceof BooleanType) {
					begin.setEditable(false);
					begin.setBackground(new Color(this.shell.getDisplay(), 210, 210, 210));
					end.setEditable(false);
					end.setBackground(new Color(this.shell.getDisplay(), 210, 210, 210));
				}
			}
			
			this.intervals[i][0] = begin; 
			this.intervals[i][1] = end;
			this.intervals[i][2] = size;
		}
		
		Label label3 = new Label(this.shell, SWT.NONE);
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 4;
		label3.setLayoutData(gData);
		this.startButton = new Button(this.shell, SWT.NONE);
		this.startButton.setText("Start");
		gData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		gData.horizontalSpan = 4;
		this.startButton.setLayoutData(gData);
		
		this.shell.setSize(400, 180 + 20 * i);
		this.shell.open();
	}
	
	public void createEmptyFrame(String s) {
		Label label = new Label(this.shell, SWT.NONE);
		label.setText(s);
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 5;
		label.setForeground(new Color(this.shell.getDisplay(), 150, 0, 0));
		label.setLayoutData(gData);
		this.shell.setSize(260, 80);
		this.shell.open();
	}
	
	public Shell getShell() {
		return this.shell;
	}
	
	public Text getCount() {
		return this.count;
	}
	
	public Text[][] getIntervals() {
		return this.intervals;
	}
	
	public Button getStartButton() {
		return this.startButton;
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
