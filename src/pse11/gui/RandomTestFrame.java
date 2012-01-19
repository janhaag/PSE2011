package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RandomTestFrame extends Frame implements MiscFrame {
	Shell shell;
	private Text intervalTextField1;
	private Text intervalTextField2;
	private Button testButton;
	
	public RandomTestFrame(Shell parentShell) {
		
		this.shell = new Shell();
		this.shell.setSize(300,200);
		this.shell.setText("Random test");
		
		//Setting layout
		GridLayout gLayout = new GridLayout();
		gLayout.marginTop = 20;
		gLayout.marginLeft = 20;
		gLayout.marginRight = 20;
		this.shell.setLayout(gLayout);
		
		//Add the group
		final Group randomGroup = new Group(this.shell, SWT.SHADOW_ETCHED_IN);
		randomGroup.setText("Number interval for random test");
		gLayout = new GridLayout();
		gLayout.numColumns = 3;
		gLayout.makeColumnsEqualWidth = true;
		gLayout.marginTop = 10;
		gLayout.marginLeft = 10;
		gLayout.marginRight = 10;
		randomGroup.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 2;
		randomGroup.setLayoutData(gData);
		
		new Label(randomGroup, SWT.NONE).setText("Begin:");
		this.intervalTextField1 = new Text(randomGroup, SWT.SINGLE);
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 2;
		this.intervalTextField1.setLayoutData(gData);
		new Label(randomGroup, SWT.NONE).setText("End:");
		this.intervalTextField2 = new Text(randomGroup, SWT.SINGLE);
		gData = new GridData(GridData.FILL_HORIZONTAL);
		gData.horizontalSpan = 2;
		this.intervalTextField2.setLayoutData(gData);
		
		this.testButton = new Button(shell, SWT.PUSH);
		this.testButton.setText("Start test");
		gData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		gData.horizontalSpan = 3;
		gData.verticalSpan = 10;
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
