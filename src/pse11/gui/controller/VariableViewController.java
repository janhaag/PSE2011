package gui.controller;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TreeItem;

import gui.VariableView;

public class VariableViewController {
	private VariableView view;
	
	private HashMap<String, Integer> var;
	
	public VariableViewController(VariableView view) {
		this.view = view;		
		this.var = new HashMap<String, Integer>();
		
	    //Test values
		TreeItem item1 = new TreeItem(this.view.getVarTree(), SWT.NONE);
		item1.setText("array");
		item1.setText(1, "-" ); 
		TreeItem item2 = new TreeItem(item1, SWT.NONE);
		item2.setText("array[0]");
		item2.setText(1, "-" ); 
		TreeItem item3 = new TreeItem(item2, SWT.NONE);
		item3.setText("array[0][0]");
		item3.setText(1, "42" ); 
	}
	
	public void updateView() {
		this.view.drawView(this.var);
	}
}
