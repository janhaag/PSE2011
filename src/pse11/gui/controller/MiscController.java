package gui.controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import gui.MiscFrame;

public class MiscController implements SelectionListener {
	MiscFrame frame;
	
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
