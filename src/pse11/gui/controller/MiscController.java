package gui.controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import gui.MiscFrame;

/**
 * This class serves as a part of a MVC pattern. It is the controller 
 * for the view @see{MiscFrame}.
 */
public class MiscController implements SelectionListener {
	/**
	 * miscellaneous views
	 */
	MiscFrame frame;
	
	/**
	 * Construct a controller instance with the specified view.
	 * @param frame the specified view
	 */
	public MiscController(MiscFrame frame) {
		this.frame = frame;
//		this.frame.getCloseButton().addSelectionListener(this);
//		this.frame.getSaveButton().addSelectionListener(this);
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource() == this.frame.getCloseButton()) {
			frame.close();
		} else if(e.getSource() == this.frame.getSaveButton()) {
			
		}	
	}
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub		
	}	
	public class SaveOptions implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent e) {			
		}
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub		
		}
	}
}
