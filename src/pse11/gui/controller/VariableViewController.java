package gui.controller;

import gui.VariableView;
import interpreter.ArrayValue;
import interpreter.BooleanValue;
import interpreter.IntegerValue;
import interpreter.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import misc.ExecutionHandler;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import ast.ArrayType;
import ast.BooleanType;
import ast.Identifier;
import ast.IntegerType;

public class VariableViewController {
	private ExecutionHandler executionHandler;
	private VariableView varView;
	
	
	public VariableViewController(VariableView varView, ExecutionHandler executionHandler) {	
		this.varView = varView;	
		this.executionHandler = executionHandler;
	}
	

	//update the variable view when in single step, paused or stopped state
	public void updateVarView() {        		
        if (this.executionHandler == null || this.executionHandler.getProgramExecution() == null) {
        	return;
        }
        HashMap<Identifier, Value> vars = this.executionHandler.getProgramExecution().getVariables();
      
        //insert Tree items       
        this.varView.getVarTree().removeAll();       
		Iterator<Map.Entry<Identifier, Value>> it = vars.entrySet().iterator();		
		while (it.hasNext()) {
			Map.Entry<Identifier, Value> entry = it.next();
			String type = entry.getValue().getType().toString();
			String id = entry.getKey().toString();
			Value tmp = entry.getValue();
			this.checkValue(this.varView.getVarTree(), type, id, tmp);
		}     
	}
	
	//insert first level tree items
	private void checkValue(Tree parent, String type, String id, Value tmp) {
		if (tmp instanceof IntegerValue || tmp instanceof BooleanValue) {
			this.varView.addTreeItem(parent, type, id, tmp.toString());
		}
		else if (tmp instanceof ArrayValue) {
			TreeItem item = this.varView.addTreeItem(parent, type, id, "-");
			for (int i = 0; i < ((ArrayValue) tmp).getValues().length; i++) {
				String newId = id + "[" + i + "]";
				this.checkValue(item, ((ArrayValue) tmp).getValues()[i].getType().toString(), 
						newId, ((ArrayValue) tmp).getValues()[i]);
			}
		}
	}
	
	//insert tree items of level 2 and more
	private void checkValue(TreeItem parent, String type, String id, Value tmp) {
		if (tmp instanceof IntegerValue || tmp instanceof BooleanValue) {
			this.varView.addTreeItem(parent, type, id, tmp.toString());
		}
		else if (tmp instanceof ArrayValue) {
			for (int i = 0; i < ((ArrayValue) tmp).getValues().length; i++) {
				TreeItem item = this.varView.addTreeItem(parent, type, id, "-");
				String newId = id + "[" + i + "]";
				this.checkValue(item, ((ArrayValue) tmp).getValues()[i].getType().toString(), 
						newId, ((ArrayValue) tmp).getValues()[i]);
			}
		}
	}
	
	public void deactivateView() {
		this.varView.getVarTree().setBackground(new Color(this.varView.getDisplay(), 231, 231, 231));
		this.varView.getVarTree().setForeground(new Color(this.varView.getDisplay(), 151, 151, 151));
	}
	
	public void activateView() {
		this.varView.getVarTree().setBackground(null);
		this.varView.getVarTree().setForeground(null);
	}
	
	
	
	public VariableView getVarView() {
		return this.varView;
	}
}
