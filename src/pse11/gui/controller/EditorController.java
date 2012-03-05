package gui.controller;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

import gui.EditorView;
import misc.Editor;

/**
 * This class is responsible for controlling the view @see{EditorFrame} 
 * and uses the model @see{Editor}.
 */
public class EditorController implements MouseListener, ModifyListener, VerifyListener, VerifyKeyListener, FocusListener {
	/**
	 * view for displaying source code and statement breakpoints
	 */
	private EditorView editorframe;
	/**
	 * model for source code and statement breakpoints
	 */
	private Editor editor;
       
	/**
     * Construct an editor controller with the specified view and model.
     * @param editor specified model
     * @param editorframe specified view
     */
    public EditorController(Editor editor, EditorView editorframe) {
        this.editorframe = editorframe;
        this.editor = editor;
        this.editorframe.getTextField().addFocusListener(this);
        this.editorframe.getTextField().addModifyListener(this);
        this.editorframe.getTextField().addVerifyKeyListener(this);
        this.editorframe.getLineNumbers().addMouseListener(this);
        this.editorframe.getLineNumbers().addFocusListener(this);
    }
    
    /**
     * Return the model of the controller.
     * @return model of the controller
     */
    public Editor getEditor() {
        return this.editor;
    }
    
    /**
     * Return the view of the controller.
     * @return view of the controller
     */
    public EditorView getEditorView() {
		return this.editorframe;
    }
    
    /**
     * Deactivate the view to avoid invalid changes during program execution.
     */
    public void deactivateView() {
    	if (this.editorframe.isActive()) {
    		this.editorframe.getLineNumbers().removeMouseListener(this);
        	this.editorframe.getTextField().setEditable(false);
        	this.editorframe.setActive(false);
    	}
    }
    
    /**
     * Reactivate the view.
     */
    public void activateView() {
    	if (!this.editorframe.isActive()) {
    		this.editorframe.getLineNumbers().addMouseListener(this);
        	this.editorframe.getTextField().setEditable(true);
        	this.editorframe.setActive(true);
    	}
    }
    
    /**
     * Highlight the specified line. 
     * @param line specified line
     */
    public void markCurrentLine(int line) {
    	this.editorframe.markLine(line);
    }
    
    /**
     * Remove all line highlighting.
     */
    public void removeMark() {
    	this.editorframe.removeAllLineBackground();
    }
    
    @Override
    public void modifyText(ModifyEvent e) {
    	if(!this.editor.getSource().equals(editorframe.getText()))
    		editor.setSource(editorframe.getText());
    }
    @Override
    public void verifyText(VerifyEvent e) {
        // TODO need?
    }
    @Override
    public void verifyKey(VerifyEvent e) {
        if ((e.stateMask == SWT.CTRL) && (e.character == '\u001A')) {
            //undo
            e.doit = false;
            this.editor.undo();
        }
    }
    @Override
    public void focusGained(FocusEvent e) {
		if (e.getSource() == this.editorframe.getLineNumbers()) {
			this.editorframe.getTextField().setFocus();
		}
    } 
    
	@Override
	public void mouseDoubleClick(MouseEvent e) {
		//breakpoints can only be set if the line contains a statement
		if (e.getSource() == this.editorframe.getLineNumbers()) {
			int offset = this.editorframe.getLineNumbers().getCaretOffset() / 2;
			int lineCount = this.editorframe.getTextField().getLineCount();
			int i = this.editor.removeBreakpoint(offset + 1);
			if (i == 1) {
				this.editorframe.setStatementBreakpoint(offset + 1, 0);
				this.editorframe.getTextField().setFocus();
				return;
			}
			if (offset > lineCount - 1 || this.editorframe.getTextField().getLine(offset) == null 
					|| !(this.editorframe.getTextField().getLine(offset).contains(";")
							|| this.editorframe.getTextField().getLine(offset).replaceAll(" ", "").contains("if(")
							|| this.editorframe.getTextField().getLine(offset).replaceAll(" ", "").contains("else")
							|| this.editorframe.getTextField().getLine(offset).replaceAll(" ", "").contains("while("))) {
				this.editorframe.getTextField().setFocus();
				return;
			} 					
			this.editor.addBreakpoint(offset + 1); 
			this.editorframe.setStatementBreakpoint(offset + 1, 1);
			this.editorframe.getTextField().setFocus();
		}			
	}
    
    @Override
    public void focusLost(FocusEvent e) {
    }
	@Override
	public void mouseDown(MouseEvent arg0) {
	}
	@Override
	public void mouseUp(MouseEvent arg0) {		
	}		
}
