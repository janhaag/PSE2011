package gui.controller;

import interpreter.GlobalBreakpoint;
import interpreter.ProgramExecution;
import interpreter.StatementBreakpoint;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;

import gui.BreakpointView;
import gui.VariableView;

public class TreeViewController implements SelectionListener {
	private ProgramExecution execution;
	
	private BreakpointView breakpointView;
	private VariableView varView;
	
	//get them from program execution, parser interface needed
	private ArrayList<GlobalBreakpoint> globalBreakpoints;
	private ArrayList<StatementBreakpoint> statementBreakpoints;
	private HashMap<String, Integer> var;
	
	public TreeViewController(BreakpointView breakpointView, VariableView varView,
			ProgramExecution execution) {
		this.execution = execution;
		
		this.breakpointView = breakpointView;
		this.varView = varView;		
		
		this.breakpointView.setListenerControl(this);
		
		//test values
		this.globalBreakpoints = new ArrayList<GlobalBreakpoint>();
		this.statementBreakpoints = new ArrayList<StatementBreakpoint>();
		StatementBreakpoint sbreakpoint = new StatementBreakpoint(null);
		this.statementBreakpoints.add(sbreakpoint);
		TableItem item = new TableItem(this.breakpointView.getStatementBreakpoint(), SWT.NONE);
		item.setText(1, "20");
		
		this.var = new HashMap<String, Integer>();	
		TreeItem item1 = new TreeItem(this.varView.getVarTree(), SWT.NONE);
		item1.setText("array");
		item1.setText(1, "-" ); 
		TreeItem item2 = new TreeItem(item1, SWT.NONE);
		item2.setText("array[0]");
		item2.setText(1, "42" );  
	}
	
	public void updateView() {
		this.varView.drawView(this.var);
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource() == this.breakpointView.getGlobalBreakpoint() && e.detail == SWT.CHECK) {
			Table table = this.breakpointView.getGlobalBreakpoint();		
			int i;
			for (i = 0; i < this.globalBreakpoints.size(); i++) {
				if (e.item == table.getItem(i)) {
					break;
				}
			}			
			/*String expression = table.getItem(i).getText(1);
			if (this.globalBreakpoints.get(i).isActive()) {
				this.globalBreakpoints.get(i).setActive(false);
				System.out.println("Globalbreakpoint " + expression + " deactivated.");
			} else {
				this.globalBreakpoints.get(i).setActive(true);
				System.out.println("Globalbreakpoint " + expression + " activated.");
			} */
			
		} else if(e.getSource() == this.breakpointView.getStatementBreakpoint() && e.detail == SWT.CHECK) {
			Table table = this.breakpointView.getStatementBreakpoint();			
			int i;
			for (i = 0; i < this.statementBreakpoints.size(); i++) {
				if (e.item == table.getItem(i)) {
					break;
				}
			}			
			String line = table.getItem(i).getText(1);
			if (this.statementBreakpoints.get(i).isActive()) {
				this.statementBreakpoints.get(i).setActive(false);
				System.out.println("Statementbreakpoint from line " + line + " deactivated.");
			} else {
				this.statementBreakpoints.get(i).setActive(true);
				System.out.println("Statementbreakpoint from line " + line + " activated.");
			}
			
		} else if(e.getSource() == this.breakpointView.getAddButton()) {
			String expression = this.breakpointView.getAddTextField().getText();
			if (expression == null || expression.length() == 0) {
				return;
			}
			
			boolean contains = false;
			for (GlobalBreakpoint g : this.globalBreakpoints) {
				if (g.getExpression().toString().equals(expression)) contains = true;
			}
			
			if (!contains) {
				//GlobalBreakpoint gBreakpoint = new GlobalBreakpoint(null);
				//this.execution.createStatementBreakpoint(expression);
				this.breakpointView.setGlobalBreakpointItem(expression);
			} else {
				//Remove global breakpoints
				//this.breakpointView.removeGlobalBreakpointItem();
			}
		}	
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
