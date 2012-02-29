package gui;

import interpreter.GlobalBreakpoint;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * This class represents the view for displaying global breakpoints as a
 * part of the main frame. It is also important for adding new global 
 * breakpoints and de-/activating those.
 */
public class BreakpointView extends Composite {
	/**
	 * table displaying added global breakpoints
	 */
	private Table global;
	/**
	 * text for global breakpoint expression input
	 */
	private StyledText addTextField;
	/**
	 * button for add and remove
	 */
	private Button button;
	private boolean active;
	/**
	 * Construct a breakpoint view with the specified parent composite and 
	 * definitions of its style and behavior.
	 * @param parent specified composite
	 * @param def specified definitions
	 */
	public BreakpointView(Composite parent, int def) {
		super(parent, def);		
		this.active = true;
		
		//Setting layout
		GridLayout gLayout = new GridLayout();
		this.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_BOTH);
		this.setLayoutData(gData);
		
		//Add the table
		this.global = new Table (this, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL 
				| SWT.H_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);
		
		this.global.setLinesVisible(true);
		this.global.setHeaderVisible(true);
		gData = new GridData(GridData.FILL_BOTH);
		this.global.setLayoutData(gData);
				
		TableColumn column1 = new TableColumn(this.global, SWT.CENTER);
		column1.setWidth(50);
		column1.setText("Active");
		TableColumn column2 = new TableColumn(this.global, SWT.CENTER);
		column2.setWidth(200);
		column2.setText("Expression");
	
		//Add text field and button
		this.addTextField = new StyledText(this, SWT.SINGLE | SWT.BORDER);
		this.addTextField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		gData = new GridData(GridData.FILL_HORIZONTAL); 
		gData.verticalSpan = 5;
		this.addTextField.setLayoutData(gData);
    
		this.button = new Button(this, SWT.PUSH);
		this.button.setText("Add/Remove");
		gData = new GridData(GridData.FILL_HORIZONTAL);  
		gData.verticalSpan = 5;
		this.button.setLayoutData(gData);
	}
	
	/**
	 * Update the table for displaying all added global breakpoints given
	 * by the specified list of global breakpoints.
	 * @param gbreakpoints specified list
	 */
	public void drawGlobalBreakpointItem(ArrayList<GlobalBreakpoint> gbreakpoints) {		
		this.global.removeAll();
		for (int i = 0; i < gbreakpoints.size(); i++) {
			TableItem item = new TableItem(this.global, SWT.NONE);
			item.setText(1, gbreakpoints.get(i).getExpression().toString());
			if (gbreakpoints.get(i).isActive()) item.setChecked(true);
		}
	}
	
	/**
	 * Return the table of the view.
	 * @return table of the view
	 */
	public Table getGlobalBreakpoint() {
		return this.global;
	}
	
	/**
	 * Return the expression text field of the view.
	 * @return text field of the view
	 */
	public StyledText getAddTextField() {
		return this.addTextField;
	}
	
	/**
	 * Return the add/remove button of the view.
	 * @return button of the view
	 */
	public Button getAddButton() {
		return this.button;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
}
