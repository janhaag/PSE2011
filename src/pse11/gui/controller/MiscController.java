package gui.controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import gui.MiscFrame;

public class MiscController implements SelectionListener {
	MiscFrame frame;
	public MiscController(MiscFrame frame) {
		this.frame = frame;
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		if(e.getSource() == this.frame.getCloseButton()) {
			frame.close();
		}
		
	}
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
