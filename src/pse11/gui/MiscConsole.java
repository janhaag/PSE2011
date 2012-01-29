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

public class MiscConsole extends Console {
	public MiscConsole(Composite parent, int style, MessageSystem messagesystem) {
		super(parent, style, messagesystem);
		
		FillLayout fLayout = new FillLayout();
		this.setLayout(fLayout);
		this.table = new Table(this, SWT.BORDER | SWT.MULTI);		
		
		TableColumn column1 = new TableColumn(this.table, SWT.CENTER);
		column1.setWidth(30);
		TableColumn column2 = new TableColumn(this.table, SWT.CENTER);
		column2.setWidth(600);
		column2.setText("Values");
		TableColumn column3 = new TableColumn(this.table, SWT.CENTER);
		column3.setWidth(150);
		column3.setText("Result");
		
		this.table.setLinesVisible(true);
		this.table.setHeaderVisible(true);
	}
	
	/*public void printRandomTestResult(String[] result) {
		TableItem item = new TableItem(this.table, SWT.NONE);
		item.setText(result[0]);
		item.setText(1, result[1]);
		item.setText(2, result[2]);
	}*/
	
	@Override
	public void updateConsole(ArrayList<Message> messages) {
		assert this.table != null;
		this.table.clearAll();
		//clearAll() doesn't work correct, so itemcount has to be set manually
		this.table.setItemCount(0);
		for(Message message : messages) {
			if(message.getCategory() == MessageCategories.MISC) {
				TableItem tableitem = new TableItem(this.table, SWT.NONE);
				tableitem.setText(new String[] {Integer.toString(message.getPosition()),message.getText()});
			}
		}	
	}

}
