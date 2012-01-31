package gui;

import java.util.ArrayList;

import misc.Message;
import misc.MessageCategories;
import misc.MessageSystem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * This class represents a miscellaneous console which displays results
 * of random tests.
 */
public class MiscConsole extends Console {
	/**
	 * Construct a miscellaneous console with the specified parent composite,
	 * definitions and model
	 * @param parent specified composite
	 * @param style specified definitions
	 * @param messagesystem specified model
	 */
	public MiscConsole(Composite parent, int style, MessageSystem messagesystem) {
		super(parent, style, messagesystem);
		
		FillLayout fLayout = new FillLayout();
		this.setLayout(fLayout);
		this.table = new Table(this, SWT.BORDER);		
		
		TableColumn column1 = new TableColumn(this.table, SWT.CENTER);
		column1.setWidth(30);
		TableColumn column2 = new TableColumn(this.table, SWT.NONE);
		column2.setWidth(170);
		column2.setText("Result");
		TableColumn column3 = new TableColumn(this.table, SWT.NONE);
		column3.setWidth(600);
		column3.setText("Values");
		
		this.table.setLinesVisible(true);
		this.table.setHeaderVisible(true);
	}
	
	@Override
	public void updateConsole(ArrayList<Message> messages) {
		assert this.table != null;
		this.table.removeAll();
		for(Message message : messages) {
			if(message.getCategory() == MessageCategories.MISC) {
				TableItem tableitem = new TableItem(this.table, SWT.NONE);
				tableitem.setText(new String[] {Integer.toString(message.getPosition()),
						message.getResult(), message.getText()});
			}
		}	
	}
}
