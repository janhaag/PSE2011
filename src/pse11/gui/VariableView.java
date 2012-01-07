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
	    
	    TreeColumn column1 = new TreeColumn(this.tree, SWT.NONE);
	    TreeColumn column2 = new TreeColumn(this.tree, SWT.CENTER);
	    column1.setText("         Variable         ");
	    column2.setText("         Value         ");
	    
	    //Test values
	    int count = 3;
	    for (int i = 0; i < count; i++) {
	    	TreeItem item1 = new TreeItem(this.tree, SWT.NONE);
	    	item1.setText("item " + i);
	    	item1.setText(1, "" + 1);
	      
	    	for (int j = 0; j < count; j++) {
	    		TreeItem item2 = new TreeItem(item1, SWT.NONE);
	    		item2.setText("item " + j);
	    		item2.setText(1, "" + 2);
	        
	    		for (int k = 0; k < count; k++) {
	    			TreeItem item3 = new TreeItem(item2, SWT.NONE);
	    			item3.setText("item " + k);
	    			item3.setText(1, "" + 3);		        		        
	    		}
	    	}

	    	TreeItem item4 = new TreeItem(this.tree, SWT.NONE);
	    	item4.setText("item " + i + ",5");
	    	item4.setText(1, "" + 0);
	    }
	    	    
	    this.tree.getColumn(0).pack();
	    this.tree.getColumn(1).pack();
		
	}
}
