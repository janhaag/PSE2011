package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class BreakpointView extends Composite {
	private Table table;
	public BreakpointView(Composite parent, int def, Table table) {
		super(parent, def);
		this.table = table;
		
		table.setLinesVisible (true);
		table.setHeaderVisible (true);
		
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.verticalSpan = 40;
		this.table.setLayoutData(gridData); 
		
		TableColumn column1 = new TableColumn(this.table, SWT.CENTER);
		column1.setText("  Active");
		TableColumn column2 = new TableColumn(this.table, SWT.CENTER);
		column2.setText("Line number or expression");
		
		for (int i=0; i<5; i++) {
			TableItem item = new TableItem(this.table, SWT.NONE);
			item.setText("" + i);
			item.setText(1, "i = 5");
		}
		
		table.getColumn(0).pack();
		table.getColumn(1).pack();
	
		Rectangle clientArea = parent.getClientArea ();
		table.setBounds (clientArea.x, clientArea.y, 100, 100);
		table.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				String string = event.detail == SWT.CHECK ? "Checked" : "Selected";
				System.out.println (event.item + " " + string);
			}
		}); 
	} 
}
