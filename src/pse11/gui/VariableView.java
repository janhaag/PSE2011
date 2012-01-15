package gui;

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
	    
	    TreeColumn column1 = new TreeColumn(this.tree, SWT.CENTER);
	    TreeColumn column2 = new TreeColumn(this.tree, SWT.CENTER);
	    TreeColumn column3 = new TreeColumn(this.tree, SWT.CENTER);
	    column1.setWidth(80);
	    column1.setText("Type");
	    column2.setWidth(100);
	    column2.setText("Variable");
	    column3.setWidth(100);
	    column3.setText("Value");
		
	}
	
	//insert first level tree items
	public TreeItem addTreeItem(Tree parent, String type, String id, String value) {
		TreeItem item = new TreeItem(parent, SWT.NONE);
		item.setText(type);
		item.setText(1, id);
		item.setText(2, value);
		return item;
	}
	
	//insert tree items of level 2 and more
	public TreeItem addTreeItem(TreeItem parent, String type, String id, String value) {
		TreeItem item = new TreeItem(parent, SWT.NONE);
		item.setText(type);
		item.setText(1, id);
		item.setText(2, value);
		return item;
	}
	
	public Tree getVarTree() {
		return this.tree;
	}
}
