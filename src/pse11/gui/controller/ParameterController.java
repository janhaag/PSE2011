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
		if (this.executionHandler.getAST() != null && this.executionHandler.getAST().getMainFunction().getParameters() != null) {
			this.frame = frame;
			this.frame.createFrame(this.executionHandler.getAST().getMainFunction().getParameters());
			this.frame.getOkButton().addSelectionListener(this);
		}		
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == this.frame.getOkButton()) {
			String[] parameterValues = new String[this.frame.getValues().length];
			for (int i = 0; i < this.frame.getValues().length; i++) {
				parameterValues[i] = "";
				parameterValues[i] += this.frame.getValues()[i].getText();
			}
			this.executionHandler.setParameterValues(parameterValues);
			this.frame.getShell().dispose();
		}		
	}

	public ParameterFrame getFrame() {
		return this.frame;
	}
	
	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub	
	}
}
