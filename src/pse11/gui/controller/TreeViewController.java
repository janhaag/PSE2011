package gui.controller;

import interpreter.ArrayValue;
import interpreter.BooleanValue;
import interpreter.GlobalBreakpoint;
import interpreter.IntegerValue;
import interpreter.ProgramExecution;
import interpreter.StatementBreakpoint;
import interpreter.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import ast.ArrayType;
import ast.BooleanType;
import ast.Identifier;
import ast.IntegerType;

import gui.BreakpointView;
import gui.VariableView;

public class TreeViewController implements SelectionListener {
	private ProgramExecution execution;
	
	private BreakpointView breakpointView;
	private VariableView varView;
	
	//get them from program execution, parser interface needed
	private ArrayList<GlobalBreakpoint> globalBreakpoints;
	private ArrayList<StatementBreakpoint> statementBreakpoints;
	
	public TreeViewController(BreakpointView breakpointView, VariableView varView,
			ProgramExecution execution) {
		this.execution = execution;
		
		this.breakpointView = breakpointView;
		this.varView = varView;		
		
		this.breakpointView.setListenerControl(this);
		
		//test values
		this.globalBreakpoints = new ArrayList<GlobalBreakpoint>();
		this.statementBreakpoints = new ArrayList<StatementBreakpoint>();
		StatementBreakpoint sbreakpoint = new StatementBreakpoint(20);
		this.statementBreakpoints.add(sbreakpoint);
		TableItem item = new TableItem(this.breakpointView.getStatementBreakpoint(), SWT.NONE);
		item.setText(1, "20");
	}
	
	//update the variable view when in single step, paused or stopped state
	public void updateVarView() {        
		//TODO: delete this when an instance of ProgramExecution can be created
		HashMap<Identifier, Value> vars = new HashMap<Identifier, Value>();
        ArrayValue a = new ArrayValue(new ArrayType(new BooleanType()),
                                      new int[]{2}, 0);
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(0);
        a.setValue("true", l);
        vars.put(new Identifier("a"), a);
        vars.put(new Identifier("B"), new BooleanValue("true"));
        vars.put(new Identifier("z_k"), new IntegerValue("-8"));
        ArrayValue i =
                new ArrayValue(new ArrayType(new ArrayType(new IntegerType())),
                                      new int[]{2, 1}, 0);
        l.add(1);l.add(0);
        i.setValue("42", l);
        vars.put(new Identifier("i0"), i);
		
        
        //HashMap<Identifier, Value> vars = this.execution.getVariables();
      
        //insert Tree items       
        this.varView.getVarTree().removeAll();
        
		Iterator<Map.Entry<Identifier, Value>> it = vars.entrySet().iterator();		
		while (it.hasNext()) {
			Map.Entry<Identifier, Value> entry = it.next();
			Value tmp = entry.getValue();
			String id = entry.getKey().toString();
			this.checkValue(tmp, this.varView.getVarTree(), id);
		}     
	}
	
	//insert first level tree items
	private void checkValue(Value tmp, Tree parent, String id) {
		if (tmp instanceof IntegerValue) {
			this.varView.addTreeItem(parent, "int", id, tmp.toString());
		}
		else if (tmp instanceof BooleanValue) {
			this.varView.addTreeItem(parent, "bool", id, tmp.toString());
		}
		else if (tmp instanceof ArrayValue) {
			TreeItem item = this.varView.addTreeItem(parent, "array", id, "-");
			for (int i = 0; i < ((ArrayValue) tmp).getValues().length; i++) {
				String newId = id + "[" + i + "]";
				this.checkValue(((ArrayValue) tmp).getValues()[i], item, newId);
			}
		}
	}
	
	//insert tree items of level 2 and more
	private void checkValue(Value tmp, TreeItem parent, String id) {
		if (tmp instanceof IntegerValue) {
			this.varView.addTreeItem(parent, "int", id, tmp.toString());
		}
		else if (tmp instanceof BooleanValue) {
			this.varView.addTreeItem(parent, "bool", id, tmp.toString());
		}
		else if (tmp instanceof ArrayValue) {
			for (int i = 0; i < ((ArrayValue) tmp).getValues().length; i++) {
				TreeItem item = this.varView.addTreeItem(parent, "array", id, "-");
				String newId = id + "[" + i + "]";
				this.checkValue(((ArrayValue) tmp).getValues()[i], item, newId);
			}
		}
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
