package gui.controller;

import interpreter.GlobalBreakpoint;

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

import gui.BreakpointView;
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
        
        @Override
        public void modifyText(ModifyEvent e) {
                // TODO REST
                editor.setSource(editorframe.getText());
        }
        @Override
        public void verifyText(VerifyEvent e) {
                // TODO need?
//              System.out.println(e.character);
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
                // TODO Auto-generated method stub
                System.out.println("focus");
                int test;
                //TODO nicht vorhandene zeilen
                //TODO nur doppelklick funktioniert
                // => ZUM TESTEN: Focus nur auf vorhandene Zeilen, daher erst enter drücken
                System.out.println(test = editorframe.getLineNumbers().getCaretOffset());
                System.out.println(test = editorframe.getLineNumbers().getLineAtOffset(test));
                editorframe.getTextField().setFocus();
                int pos = 0;
                for(int i = 0; i < test; i++) {
                        int linelength;
                        if(i < this.editorframe.getTextField().getLineCount()) {
                                linelength = this.editorframe.getTextField().getLine(i).length();
                        } else {
                                linelength = 0;
                        }
                        if(linelength == 0) {
                                pos += 2;
                        } else {
                                pos += linelength+2;
                        }
                }
                if(pos % 2 != 0) {
                        pos++;
                }
                //TODO WEG
                //editorframe.getTextField().setCaretOffset(pos);
                System.out.println(pos); 
        	
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
			
			public BreakpointViewController(BreakpointView breakpointView) {
				this.breakpointView = breakpointView;			
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
					
					boolean contains = false;
					for (GlobalBreakpoint g : editor.getGlobalBreakpoints()) {
						if (g.getExpression().toString().equals(expression)) 
							contains = true;
					}	
					if (!contains) {
						//GlobalBreakpoint gBreakpoint = new GlobalBreakpoint(null);
						//this.execution.createStatementBreakpoint(expression);
						//this.breakpointView.setGlobalBreakpointItem(expression);
					} else {
						//Remove global breakpoints
						//this.breakpointView.removeGlobalBreakpointItem();
					}
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
