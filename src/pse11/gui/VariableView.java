package gui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public class VariableView extends Composite {
	private Tree tree;
	
	public VariableView(Composite parent, int def) {
		super(parent, def);		
	    
	    this.tree = new Tree(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL 
				| SWT.MULTI | SWT.FULL_SELECTION);
	    
		//Setting the Layout
		GridLayout gLayout = new GridLayout();
		this.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_BOTH);
		this.setLayoutData(gData);
		this.tree.setLayoutData(gData);
	    
	    this.tree.setHeaderVisible(true);
	    this.tree.setLinesVisible(true);
	    
	    TreeColumn column1 = new TreeColumn(this.tree, SWT.NONE);
	    TreeColumn column2 = new TreeColumn(this.tree, SWT.CENTER);
	    column1.setText("         Variable         ");
	    column2.setText("         Value         ");
	    	    
	    this.tree.getColumn(0).pack();
	    this.tree.getColumn(1).pack();
		
	}
	
	//Update variable view
	public void drawView(HashMap<String, Integer> var) {
		Iterator<Map.Entry<String, Integer>> it = var.entrySet().iterator();		
		while(it.hasNext()) {
			TreeItem item = new TreeItem(this.tree, SWT.NONE);
			Map.Entry<String, Integer> entry = it.next();
			item.setText(entry.getKey().toString());
			item.setText(1, entry.getValue().toString());
		}
	}
	
	public Tree getVarTree() {
		return this.tree;
	}
}
