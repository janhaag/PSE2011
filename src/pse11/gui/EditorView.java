package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import misc.Editor;
import misc.Keyword;

public class EditorView extends Composite {
	private Editor editor;
	private Display parentdisplay;
	private StyledText textfield;
	private StyledText linenumbers;
	public EditorView(Composite parent, int def, Editor editor) {
		super(parent, def);
		this.editor = editor; 
		this.editor.setView(this);
		
		//Setting the Layout
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		this.setLayout(gLayout);
		
		//Initialize editor components
		this.parentdisplay = parent.getDisplay();
		this.linenumbers = new StyledText(this, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		this.linenumbers.setText(" 1 \n 2 \n 3 \n 4 \n");
		this.linenumbers.setEditable(false);
		this.linenumbers.setBackground(new Color(this.getDisplay(), 211, 211, 211));
		this.linenumbers.setCursor(new Cursor(parent.getDisplay(), SWT.CURSOR_HAND));
		this.textfield = new StyledText(this, SWT.BORDER | SWT.V_SCROLL);
		this.textfield.setLeftMargin(20);
		////this.textfield.getVerticalBar().add
		//this.linenumbers.setBounds(0,0,20,300);
		
		//Position the text fields
		GridData gData = new GridData(GridData.FILL_VERTICAL);
		gData.horizontalAlignment = GridData.END;
		this.linenumbers.setLayoutData(gData);
		gData = new GridData(GridData.FILL_BOTH);
		this.textfield.setLayoutData(gData);
		gData = null;
	}
	public void updateView() {
		textfield.setStyleRange(null);
		for(Keyword word : this.editor.getColorArray()) {
			StyleRange stylerange = new StyleRange();
			System.out.println(word.getStart() + " ## " + this.textfield.getLineAtOffset(word.getStart()));
			stylerange.start = word.getStart();// + this.textfield.getLineAtOffset(word.getStart());
			stylerange.length = word.getLength();
			stylerange.fontStyle = SWT.BOLD;
			stylerange.foreground = new Color(this.textfield.getDisplay(), word.getColor());
			textfield.setStyleRange(stylerange);
		}
	}
	public String getText() {
		return this.textfield.getText();
	}
	public StyledText getTextField() {
		return this.textfield;
	}
	public StyledText getLineNumbers() {
		return this.linenumbers;
	}
}
