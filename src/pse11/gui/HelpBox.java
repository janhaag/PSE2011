package gui;

import misc.Editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelpBox extends Composite {
	private Text helpbox;
	private Editor editor;
	public HelpBox(Shell parent, int style, Editor editor) {
		super(parent, style);
		this.editor = editor;
		
		//Setting the Layout
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 1;
		this.setLayout(gLayout);
		final Text helpboxheader = new Text(this, SWT.NONE);
		
		//Initialize the text fields
		helpboxheader.setEnabled(false);
		helpboxheader.setBackground(new Color(helpboxheader.getDisplay(), 0, 0, 255));
		helpboxheader.setText("Help");
		
		this.helpbox = new Text(this, SWT.BORDER | SWT.V_SCROLL);
		this.helpbox.setEditable(false);
		this.helpbox.setText("Hier werden sie geholfen");
		
		//Position the text fields
		GridData gData = new GridData(GridData.FILL_HORIZONTAL);
		helpboxheader.setLayoutData(gData);
		gData = new GridData(GridData.FILL_BOTH);
		gData.minimumWidth = 200;
		this.helpbox.setLayoutData(gData);
		gData = null;
	}
}
