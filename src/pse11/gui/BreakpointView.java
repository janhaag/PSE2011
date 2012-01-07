package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class BreakpointView extends Composite {
	private Table global;
	private Table statement;
	
	public BreakpointView(Composite parent, int def) {
		super(parent, def);		
		
		//Setting layout
		GridLayout gLayout = new GridLayout();
		this.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_BOTH);
		this.setLayoutData(gData);
	    
		//Create global and statement breakpoint tables
		for (int i = 0; i < 2; i++) {
			Table table = new Table (parent, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL 
					| SWT.H_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);
			
			table.setLinesVisible(true);
			table.setHeaderVisible(true);
			
			TableColumn column1 = new TableColumn(table, SWT.CENTER);
			column1.setText("  Active");
			TableColumn column2 = new TableColumn(table, SWT.CENTER);
			
			if (i == 0) {
				column2.setText("             Expression             ");
			}
			else {
				column2.setText("           Line number           ");
			}
			
			//Test values
			if (i == 0) {
				for (int j = 0; j < 5; j++) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText("" + j);
					item.setText(1, "i = 5");
				}
			}
			else {
				for (int j = 0; j < 7; j++) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText("" + j);
					item.setText(1, "42");
				}
			}
			
			table.getColumn(0).pack();
			table.getColumn(1).pack();

			//Check box event
			Rectangle clientArea = parent.getClientArea ();
			table.setBounds (clientArea.x, clientArea.y, 100, 100);
			table.addListener (SWT.Selection, new Listener () {
				public void handleEvent (Event event) {
					String string = event.detail == SWT.CHECK ? "Checked" : "Selected";
					System.out.println (event.item + " " + string);
				}
			}); 
			
			if (i == 0) {
				this.global = table;
			}
			else {
				this.statement = table;
			}
		}
	}
	
	public Table getGlobalBreakpoint() {
		return this.global;
	}
	
	public Table getStatementBreakpoint() {
		return this.statement;
	}
}
