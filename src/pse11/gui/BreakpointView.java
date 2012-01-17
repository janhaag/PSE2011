package gui;

import gui.controller.TreeViewController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class BreakpointView extends Composite {
	private Table global;
	private Table statement;
	private StyledText addTextField;
	private Button button;
	
	public BreakpointView(Composite parent, int def) {
		super(parent, def);		
		
		//Setting layout
		GridLayout gLayout = new GridLayout();
		this.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_BOTH);
		this.setLayoutData(gData);
	    
		TabFolder tab = new TabFolder(this, SWT.NONE);
		gData = new GridData(GridData.FILL_BOTH);
		tab.setLayoutData(gData);
		
		//Create global and statement breakpoint tables
		for (int i = 0; i < 2; i++) {
			Table table = new Table (tab, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL 
					| SWT.H_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);
			
			table.setLinesVisible(true);
			table.setHeaderVisible(true);
			
			TableColumn column1 = new TableColumn(table, SWT.CENTER);
			column1.setWidth(50);
			column1.setText("Active");
			TableColumn column2 = new TableColumn(table, SWT.CENTER);
			column2.setWidth(230);
			if (i == 0) {
				column2.setText("Expression");
			}
			else {
				column2.setText("Line number");
			}
			
			if (i == 0) {
				this.global = table;
			}
			else {
				this.statement = table;
			}
		}
		
		TabItem tabitem1 = new TabItem(tab, SWT.BORDER);
		tabitem1.setText("Global");
		tabitem1.setControl(this.global);
		TabItem tabitem2 = new TabItem(tab, SWT.BORDER);
		tabitem2.setText("Statement");
		tabitem2.setControl(this.statement);
		
		//Create text field and button for global breakpoint inserts
	    this.addTextField = new StyledText(this, SWT.SINGLE | SWT.BORDER);
	    this.addTextField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    gData = new GridData(GridData.FILL_HORIZONTAL); 
	    gData.verticalSpan = 5;
	    this.addTextField.setLayoutData(gData);
	    
	    this.button = new Button(this, SWT.PUSH);
	    this.button.setText("Add Globalbreakpoint");
	    gData = new GridData(GridData.FILL_HORIZONTAL);  
	    gData.verticalSpan = 5;
	    this.button.setLayoutData(gData);
	}
	
	public void setGlobalBreakpointItem(String key) {		
		TableItem item = new TableItem(this.global, SWT.NONE);
		item.setText(1, key);
	}
	
	public void removeGlobalBreakpointItem() {
	}
	
	public Table getGlobalBreakpoint() {
		return this.global;
	}
	
	public Table getStatementBreakpoint() {
		return this.statement;
	}
	
	public StyledText getAddTextField() {
		return this.addTextField;
	}
	
	public Button getAddButton() {
		return this.button;
	}
}
