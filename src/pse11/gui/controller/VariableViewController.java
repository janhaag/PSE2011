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

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import ast.ArrayType;
import ast.BooleanType;
import ast.Identifier;
import ast.IntegerType;

public class VariableViewController {
	private ExecutionHandler executionHandler;
	private VariableView varView;
	
	
	public VariableViewController(VariableView varView) {	
		this.varView = varView;		
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
		
        //if (this.execution == null) return;
        //HashMap<Identifier, Value> vars = this.execution.getVariables();
      
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
}
