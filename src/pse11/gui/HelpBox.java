package gui;

import misc.Editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelpBox extends Composite {
	// private Editor editor;

	private Browser helpbox;
	private Text search;
	private Button button;

	public HelpBox(Shell parent, int style, Editor editor) {
		super(parent, style);
		// this.editor = editor;

		// Setting the Layout
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 4;
		this.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_BOTH);
		this.setLayoutData(gData);

		// Create components of the help box
		Text helpboxheader = new Text(this, SWT.NONE);
		helpboxheader.setEnabled(false);
		helpboxheader.setBackground(new Color(helpboxheader.getDisplay(), 142, 189, 247));
		helpboxheader.setText("Help");
		gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan = 4;
		gData.verticalSpan = 4;
		helpboxheader.setLayoutData(gData);

		// this.helpbox = new StyledText(this, SWT.MULTI | SWT.WRAP | SWT.BORDER
		// | SWT.H_SCROLL | SWT.V_SCROLL);
		// this.helpbox.setEditable(false);
		// this.helpbox.setText("Please insert a key word (i.e. hallo, welt)");
		this.helpbox = new Browser(this, SWT.NONE);
		gData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gData.horizontalSpan = 4;
		gData.verticalSpan = 18;
		this.helpbox.setLayoutData(gData);
		this.setText("<html><body style=\"margin:0;font-family:sans-serif;font-size:0.8em;\">Insert a term to search for.</body></html>");

		this.search = new Text(this, SWT.SINGLE | SWT.BORDER);
		this.search.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan = 3;
		gData.verticalSpan = 5;
		this.search.setLayoutData(gData);
		this.search.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				return;
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				button.notifyListeners(SWT.Selection, new Event());
			}
		});

		this.button = new Button(this, SWT.PUSH);
		this.button.setText("Search");
		gData = new GridData(GridData.FILL_BOTH);
		gData.verticalSpan = 5;
		this.button.setLayoutData(gData);
	}

	public void addSelectionListener(SelectionListener listener) {
		this.button.addSelectionListener(listener);
	}

	public void setText(String text) {
		this.helpbox.setText(text);
	}

	public String getSearchText() {
		return this.search.getText();
	}
}
