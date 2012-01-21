package gui.controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import misc.ExecutionHandler;
import gui.ParameterFrame;

public class ParameterController implements SelectionListener {
	private ParameterFrame frame;
	private ExecutionHandler executionHandler;
	
	public ParameterController(ExecutionHandler executionHandler) {
		this.executionHandler = executionHandler;
	}

	public void addView(ParameterFrame frame) {
		this.frame = frame;
		this.frame.createFrame(this.executionHandler.getParameters());
		this.frame.getOkButton().addSelectionListener(this);		
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == this.frame.getOkButton()) {
			int[] parameterValues = new int[this.frame.getValues().length];
			for (int i = 0; i < this.frame.getValues().length; i++) {
				String s = this.frame.getValues()[i].getText();
				try {
					parameterValues[i] = Integer.parseInt(s);
					System.out.println(parameterValues[i]);
				}
				catch (NumberFormatException nf) {
					parameterValues[i] = 0;
				}
			}
			this.executionHandler.setParameterValues(parameterValues);
			this.frame.getShell().dispose();
		}		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub	
	}
}
