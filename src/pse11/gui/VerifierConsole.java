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
 * This class represents a console for verifier results.
 */
public class VerifierConsole extends Console {
	private TableColumn positionColumn;
	private TableColumn errormessageColumn;
	
	/**
	 * Construct a verifier console with the specified parent composite,
	 * definitions of behavior and model.
	 * @param parent specified composite
	 * @param style specified style
	 * @param messagesystem specified model
	 */
	public VerifierConsole(Composite parent, int style, MessageSystem messagesystem) {
		super(parent, style, messagesystem);
		FillLayout fLayout = new FillLayout();
		this.setLayout(fLayout);
		this.table = new Table(this, SWT.BORDER);
		this.positionColumn = new TableColumn(this.table, SWT.CENTER);
		this.positionColumn.setText("Position");
		this.positionColumn.setWidth(100);
		this.errormessageColumn = new TableColumn(this.table, SWT.CENTER | SWT.FILL);
		this.errormessageColumn.setText("Message");
		this.errormessageColumn.setWidth(300);
		this.table.setHeaderVisible(true);
	}

	@Override
	public void updateConsole(ArrayList<Message> messages) {
		assert this.table != null;
		this.table.clearAll();
		//clearAll() doesn't work correct, so itemcount has to be set manually
		this.table.setItemCount(0);
		for(Message message : messages) {
			if(message.getCategory() == MessageCategories.VERIFYERROR) {
				TableItem tableitem = new TableItem(this.table, SWT.NONE);
				tableitem.setText(new String[] {Integer.toString(message.getPosition()),message.getText()});
			}
		}
	}

}
