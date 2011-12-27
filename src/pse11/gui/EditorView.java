package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import gui.controller.EditorController;
import misc.Editor;
import misc.Keyword;

public class EditorView {
	private Editor editor;
	private Display parentdisplay;
	private StyledText textfield;
	private Text linenumbers;
	public EditorView(Composite parent, int def) {
		this.textfield = new StyledText(parent, SWT.BORDER);
		this.textfield.setBounds(20,0,500,300);
		this.editor = new Editor(); 
		this.editor.setView(this);
		this.parentdisplay = parent.getDisplay();
		this.textfield.addModifyListener(new EditorController(this, editor));
		this.linenumbers = new Text(parent, SWT.BORDER | SWT.MULTI);
		this.linenumbers.setText("1\n\r2\n\r");
		this.linenumbers.setEditable(false);
		this.linenumbers.setEnabled(false);
		this.linenumbers.setBounds(0,0,20,300);
	}
	public void updateView() {
		textfield.setStyleRange(null);
		for(Keyword word : this.editor.getColorArray()) {
			StyleRange stylerange = new StyleRange();
			stylerange.start = word.getStart();
			stylerange.length = word.getLength();
			stylerange.fontStyle = SWT.BOLD;
			stylerange.foreground = new Color(this.textfield.getDisplay(), word.getColor());
			textfield.setStyleRange(stylerange);
		}
	}
	public String getText() {
		return this.textfield.getText();
	}
}
