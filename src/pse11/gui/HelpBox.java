package gui;

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

/**
 * This class represents the help box of the main frame. It displays
 * the help document and enables searching for a keyword.
 */
public class HelpBox extends Composite {
	/**
	 * browser containing the help document
	 */
	private Browser helpbox;
	/**
	 * text field for the keyword 
	 */
	private Text search;
	/**
	 * button for search
	 */
	private Button button;

	/**
	 * Construct a help box with the specified parent shell and definitions
	 * about its behavior and style.
	 * @param parent specified shell
	 * @param style specified definitions
	 */
	public HelpBox(Shell parent, int style) {
		super(parent, style);
		
		//Set the Layout
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 4;
		this.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_BOTH);
		this.setLayoutData(gData);

		//Add various components
		Text helpboxheader = new Text(this, SWT.NONE);
		helpboxheader.setEnabled(false);
		helpboxheader.setBackground(new Color(helpboxheader.getDisplay(), 142, 189, 247));
		helpboxheader.setText("Help");
		gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan = 4;
		gData.verticalSpan = 4;
		helpboxheader.setLayoutData(gData);

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

	/**
	 * Add the specified listener to the search button.
	 * @param listener specified listener
	 */
	public void addSelectionListener(SelectionListener listener) {
		this.button.addSelectionListener(listener);
	}

	/**
	 * Set the content of the text field.
	 * @param text specified text to be set
	 */
	public void setText(String text) {
		this.helpbox.setText(text);
	}

	/**
	 * Return the key word to be searched for.
	 * @return key word
	 */
	public String getSearchText() {
		return this.search.getText();
	}
}
