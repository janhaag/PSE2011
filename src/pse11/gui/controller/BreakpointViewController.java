package gui.controller;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import gui.BreakpointView;

public class BreakpointViewController implements SelectionListener {
	private BreakpointView view;
	
	//TEST -> Breakpoint instances from ProgramExecution needed
	private HashMap<String, Boolean> globalBreakpoint;
	private HashMap<String, Boolean> statementBreakpoint;
	
	public BreakpointViewController() {	
		this.globalBreakpoint = new HashMap<String, Boolean>();
		this.statementBreakpoint = new HashMap<String, Boolean>();
	}
	
	public void addView(BreakpointView view) {
		this.view = view;

		//TEST
		this.statementBreakpoint.put("20", false);
		TableItem item = new TableItem(this.view.getStatementBreakpoint(), SWT.NONE);
		item.setText(1, "20");
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource() == this.view.getGlobalBreakpoint() && e.detail == SWT.CHECK) {
			Table table = this.view.getGlobalBreakpoint();		
			int number = 0;
			for (int i = 0; i < this.globalBreakpoint.size(); i++) {
				if (e.item == table.getItem(i)) {
					number = i + 1;
					break;
				}
			}			
			String key = table.getItem(number - 1).getText(1);
			if (this.globalBreakpoint.get(key)) {
				this.globalBreakpoint.put(key, false);
				System.out.println("Globalbreakpoint " + key + " deactivated.");
			} else {
				this.globalBreakpoint.put(key, true);
				System.out.println("Globalbreakpoint " + key + " activated.");
			}
			
		} else if(e.getSource() == this.view.getStatementBreakpoint() && e.detail == SWT.CHECK) {
			Table table = this.view.getStatementBreakpoint();			
			int number = 0;
			for (int i = 0; i < this.statementBreakpoint.size(); i++) {
				if (e.item == table.getItem(i)) {
					number = i + 1;
					break;
				}
			}			
			String key = table.getItem(number - 1).getText(1);
			if (this.statementBreakpoint.get(key)) {
				this.statementBreakpoint.put(key, false);
				System.out.println("Statementbreakpoint from line " + key + " deactivated.");
			} else {
				this.statementBreakpoint.put(key, true);
				System.out.println("Statementbreakpoint from line " + key + " activated.");
			}
			
		} else if(e.getSource() == this.view.getAddButton()) {
			String key = this.view.getAddTextField().getText();
			if (key == null || key.length() == 0) {
				return;
			}
			if (!this.globalBreakpoint.containsKey(key)) {
				this.globalBreakpoint.put(key, false);
				this.view.setGlobalBreakpointItem(key);
			}			
		}	
	}
	
	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub		
	}
}
