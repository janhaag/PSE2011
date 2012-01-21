package gui.controller;

import interpreter.GlobalBreakpoint;

import org.antlr.runtime.RecognitionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Table;

import ast.Expression;

import gui.BreakpointView;
import gui.EditorView;
import misc.Editor;
import misc.ExecutionHandler;

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
	
	//nested class
	public class BreakpointViewController implements MouseListener, SelectionListener {			
		private BreakpointView breakpointView;
		private ExecutionHandler executionHandler;
		
		public BreakpointViewController(BreakpointView breakpointView, ExecutionHandler executionHandler) {
			this.breakpointView = breakpointView;	
			this.executionHandler = executionHandler;
			
			this.breakpointView.getGlobalBreakpoint().addSelectionListener(this);
			this.breakpointView.getStatementBreakpoint().addSelectionListener(this);
			this.breakpointView.getAddButton().addSelectionListener(this);
			editorframe.getLineNumbers().addMouseListener(this);
		}				
		
		@Override
		public void mouseDoubleClick(MouseEvent e) {
            if (e.getSource() == editorframe.getLineNumbers()) {
                int offset = editorframe.getLineNumbers().getCaretOffset() / 2;
                int lineCount = editorframe.getTextField().getLineCount();
                if (offset > lineCount - 1 || editorframe.getTextField().getLine(offset) == null
                                || !(editorframe.getTextField().getLine(offset).contains(";")
    									|| editorframe.getTextField().getLine(offset).replaceAll(" ", "").contains("if(")
    									|| editorframe.getTextField().getLine(offset).replaceAll(" ", "").contains("else")
    									|| editorframe.getTextField().getLine(offset).replaceAll(" ", "").contains("while("))) {
                		return;
                }
                this.breakpointView.drawStatementBreakpoint(editor.getStatementBreakpoints());
            }
		}
		
		public void deactivateView() {
			this.breakpointView.getAddButton().removeSelectionListener(this);
			editorframe.getLineNumbers().removeMouseListener(this);
		}
		
		public void activateView() {
			this.breakpointView.getAddButton().addSelectionListener(this);
			editorframe.getLineNumbers().addMouseListener(this);
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			if(e.getSource() == this.breakpointView.getGlobalBreakpoint() && e.detail == SWT.CHECK) {
				Table table = this.breakpointView.getGlobalBreakpoint();		
				int i;
				for (i = 0; i < table.getItemCount(); i++) {
					if (e.item == table.getItem(i)) {
						break;
					}
				}			
				String expression = table.getItem(i).getText(1);
				if (editor.getGlobalBreakpoints().get(i).isActive()) {
					editor.getGlobalBreakpoints().get(i).setActive(false);
					System.out.println("Globalbreakpoint " + expression + " deactivated.");
				} else {
					editor.getGlobalBreakpoints().get(i).setActive(true);
					System.out.println("Globalbreakpoint " + expression + " activated.");
				} 
				
			} else if(e.getSource() == this.breakpointView.getStatementBreakpoint() && e.detail == SWT.CHECK) {
				Table table = this.breakpointView.getStatementBreakpoint();			
				int i;
				for (i = 0; i < table.getItemCount(); i++) {
					if (e.item == table.getItem(i)) {
						break;
					}
				}			
				String line = table.getItem(i).getText(1);
				if (editor.getStatementBreakpoints().get(i).isActive()) {
					editor.getStatementBreakpoints().get(i).setActive(false);
					System.out.println("Statementbreakpoint from line " + line + " deactivated.");
				} else {
					editor.getStatementBreakpoints().get(i).setActive(true);
					System.out.println("Statementbreakpoint from line " + line + " activated.");
				}
	
			} else if(e.getSource() == this.breakpointView.getAddButton()) {
				String expression = this.breakpointView.getAddTextField().getText();
				if (expression == null || expression.length() == 0) {
					return;
				}
				
				int i;
				for (i = 0; i < editor.getGlobalBreakpoints().size(); i++) {
					if (editor.getGlobalBreakpoints().get(i).getExpression().toString().replaceAll(" ", "").equals(expression.replaceAll(" ", ""))) {
						break;
					}				
				}	
				if (i >= editor.getGlobalBreakpoints().size()) {
					Expression exp = null;
					try {
						exp = this.executionHandler.getParserInterface().parseExpression(expression);
					} catch (RecognitionException e1) {
						System.out.println("Invalid expression!");
					}
					if (exp != null) {
						GlobalBreakpoint gBreakpoint = new GlobalBreakpoint(exp);
						editor.getGlobalBreakpoints().add(gBreakpoint);
					}
				} else {
					editor.getGlobalBreakpoints().remove(i);
				}
				this.breakpointView.drawGlobalBreakpointItem(editor.getGlobalBreakpoints());
			}	
		} 

		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
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
}
