package gui;

import java.util.ArrayList;

import misc.Categories;
import misc.Message;
import misc.MessageSystem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class ErrorConsole extends Console {
	private TableColumn positionColumn;
	private TableColumn errormessageColumn;
	private ArrayList<TableItem> tableitems;;
	public ErrorConsole(Composite parent, int style, MessageSystem messagesystem) {
		super(parent, style, messagesystem);
		this.tableitems = new ArrayList<TableItem>();
		
		this.table = new Table(this, SWT.BORDER);
		this.positionColumn = new TableColumn(this.table, SWT.CENTER);
		this.positionColumn.setText("Position");
		this.positionColumn.setWidth(20);
		this.errormessageColumn = new TableColumn(this.table, SWT.CENTER);
		this.errormessageColumn.setText("Message");
		this.errormessageColumn.setWidth(200);
		this.table.setBounds(0,0,250,100);
		this.table.setHeaderVisible(true);
		// TODO Auto-generated constructor stub
		TableItem ti1 = new TableItem(this.table, SWT.NONE);
		ti1.setText(new String[] {"lol","huh"});
	}

	@Override
	public void updateConsole(ArrayList<Message> messages) {
		System.out.println("update");
		int i = 0;
		for(Message message : messages) {
			System.out.println("inhalt");
			if(message.getCategory() == Categories.ERROR) {
				System.out.println("here");
				assert this.table != null;
				TableItem tableitem = new TableItem(this.table, SWT.NONE);
				tableitem.setText(new String[] {Integer.toString(message.getPosition()),"huh"});
			}
		}	
	}

}