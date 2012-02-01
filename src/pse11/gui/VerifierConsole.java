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
		
		TableColumn column1= new TableColumn(this.table, SWT.CENTER);
		column1.setText("Tested Contract");
		column1.setWidth(250);
		TableColumn column2 = new TableColumn(this.table, SWT.CENTER | SWT.FILL);
		column2.setText("Result");
		column2.setWidth(350);
		this.table.setHeaderVisible(true);
	}

	@Override
	public void updateConsole(ArrayList<Message> messages) {
		assert this.table != null;
		this.table.removeAll();
		for(Message message : messages) {
			if(message.getCategory() == MessageCategories.VERIFYERROR) {
				TableItem tableitem = new TableItem(this.table, SWT.NONE);
				tableitem.setText(1, message.getText());
				if (message.getResult() != null) {
					tableitem.setText(0, message.getResult());
				}
			}
		}
	}

}
