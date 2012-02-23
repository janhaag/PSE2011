package gui;

import java.util.ArrayList;

import misc.MessageCategories;
import misc.Message;
import misc.MessageSystem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * This class represents an error console as a part of the main frame.
 * It displays error messages caused by parsing, type checking and program
 * execution.
 */
public class ErrorConsole extends Console {
	/**
	 * table column to show the position of the error
	 */
	private TableColumn positionColumn;
	/**
	 * table column to show the description of the error
	 */
	private TableColumn errormessageColumn;
	
	/**
	 * Construct an error console with the specified parent composite,
	 * definitions of its style and model.
	 * @param parent specified composite
	 * @param style specified definitions
	 * @param messagesystem specified model
	 */
	public ErrorConsole(Composite parent, int style, MessageSystem messagesystem) {
		super(parent, style, messagesystem);
		FillLayout fLayout = new FillLayout();
		this.setLayout(fLayout);
		
		//Add various components
		this.table = new Table(this, SWT.BORDER);
		this.positionColumn = new TableColumn(this.table, SWT.CENTER);
		this.positionColumn.setText("Position");
		this.positionColumn.setWidth(100);
		this.errormessageColumn = new TableColumn(this.table, SWT.CENTER | SWT.FILL);
		this.errormessageColumn.setText("Message");
		this.errormessageColumn.setWidth(500);
		this.table.setHeaderVisible(true);
	}

	@Override
	public void updateConsole(ArrayList<Message> messages) {
		assert this.table != null;
		this.table.removeAll();
		for(Message message : messages) {
			if(message.getCategory() == MessageCategories.ERROR) {
				TableItem tableitem = new TableItem(this.table, SWT.NONE);
				tableitem.setText(new String[] {Integer.toString(message.getPosition()),message.getText()});
			}
		}	
	}

}
