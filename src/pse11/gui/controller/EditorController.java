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

public class EditorController implements MouseListener, ModifyListener, VerifyListener, VerifyKeyListener, FocusListener {
    private EditorView editorframe;
    private Editor editor;
        
    public EditorController(Editor editor, EditorView editorframe) {
        this.editorframe = editorframe;
        this.editor = editor;
        this.editorframe.getTextField().addFocusListener(this);
        this.editorframe.getTextField().addModifyListener(this);
        this.editorframe.getTextField().addVerifyKeyListener(this);
        this.editorframe.getLineNumbers().addMouseListener(this);
        this.editorframe.getLineNumbers().addFocusListener(this);
    }
    
    public Editor getEditor() {
        return this.editor;
    }
    
    public EditorView getEditorView() {
		return this.editorframe;
    }
    
    public void deactivateView() {
    	this.editorframe.getLineNumbers().removeMouseListener(this);
    	this.editorframe.getTextField().setEditable(false);
    }
    
    public void activateView() {
    	this.editorframe.getLineNumbers().addMouseListener(this);
    	this.editorframe.getTextField().setEditable(true);
    }
    
    @Override
    public void modifyText(ModifyEvent e) {
        // TODO REST
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
			if (offset > lineCount - 1 || this.editorframe.getTextField().getLine(offset) == null 
					|| !(this.editorframe.getTextField().getLine(offset).contains(";")
							|| this.editorframe.getTextField().getLine(offset).replaceAll(" ", "").contains("if(")
							|| this.editorframe.getTextField().getLine(offset).replaceAll(" ", "").contains("else")
							|| this.editorframe.getTextField().getLine(offset).replaceAll(" ", "").contains("while("))) {
				this.editorframe.getTextField().setFocus();
				return;
			} 					
			int i = this.editor.addBreakpoint(offset + 1); 
			this.editorframe.setStatementBreakpoint(offset + 1, i);
			this.editorframe.getTextField().setFocus();
		}			
	}
    
    @Override
    public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub

    }
	@Override
	public void mouseDown(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseUp(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}		
}
