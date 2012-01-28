package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.Bullet;
import org.eclipse.swt.custom.PaintObjectEvent;
import org.eclipse.swt.custom.PaintObjectListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ScrollBar;

import misc.Editor;
import misc.Keyword;

public class EditorView extends Composite {
	private Editor editor;
	private Display parentdisplay;
	private StyledText textfield;
	private StyledText linenumbers;
	
	private Image breakpoint;
	
	private static final int MAX_LINES = 500;
	
	public EditorView(Composite parent, int def, Editor editor) {
		super(parent, def);
		this.editor = editor; 
		this.editor.setView(this);
		
		//Setting the Layout
		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 35;
		gLayout.makeColumnsEqualWidth = true;
		this.setLayout(gLayout);
		GridData gData = new GridData(GridData.FILL_BOTH);
		this.setLayoutData(gData);
		
		//Initialize editor components
		this.parentdisplay = parent.getDisplay();
		
		//Text field for line numbers
		final ScrolledComposite sc1 = new ScrolledComposite (this, SWT.V_SCROLL 
				| SWT.H_SCROLL | SWT.RIGHT_TO_LEFT);
		this.linenumbers = new StyledText(sc1, SWT.MULTI | SWT.WRAP);	
		sc1.getVerticalBar().setEnabled(false);
		sc1.getHorizontalBar().setEnabled(false);
		this.linenumbers.setSize(35, 7500);
		
		String s = "";
		for (int i = 0; i < MAX_LINES - 1; i++) {
			s += " \n";
		}
		this.linenumbers.setText(s);
		
		for (int i = 0; i < MAX_LINES; i++) {		
			StyleRange style = new StyleRange();
			style.metrics = new GlyphMetrics(0, 0, 25);
			Bullet b = new Bullet(ST.BULLET_TEXT, style);
			if (i < 9) {
				b.text = "   " + (i + 1) + " ";
			}
			else if (i < 99) {
				b.text = "  " + (i + 1) + " ";
			}
			else {
				b.text = (i + 1) + " ";
			}
			this.linenumbers.setLineBullet(i, 1, b);
		}
		
		this.linenumbers.setEditable(false);
		this.linenumbers.setDoubleClickEnabled(false);
		this.linenumbers.setBackground(new Color(this.getDisplay(), 211, 211, 211));
		this.linenumbers.setCursor(new Cursor(parent.getDisplay(), SWT.CURSOR_HAND));
		sc1.setContent(this.linenumbers);
		
		//Text field for source code
		final ScrolledComposite sc2 = new ScrolledComposite (this, SWT.V_SCROLL | SWT.H_SCROLL);
		this.textfield = new StyledText(sc2, SWT.NONE);
		this.textfield.setLeftMargin(5);
		this.textfield.setSize(1200, 7500);
		this.textfield.setFocus();
		sc2.setContent(this.textfield);
		
		//Position the text fields
		gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan= 3;
		sc1.setLayoutData(gData);
		gData = new GridData(GridData.FILL_BOTH);
		gData.horizontalSpan= 32;
		sc2.setLayoutData(gData);
		
		//Simultaneous scrolling of the text fields
		final ScrollBar vBar1 = sc1.getVerticalBar();
		final ScrollBar vBar2 = sc2.getVerticalBar();
		SelectionListener listener = new SelectionAdapter () {
			public void widgetSelected (SelectionEvent e) {
				int x =  sc1.getOrigin().x;
				int y =  vBar2.getSelection() * (vBar1.getMaximum() - vBar1.getThumb()) 
						/ Math.max(1, vBar2.getMaximum() - vBar2.getThumb());
				sc1.setOrigin (x, y);
			}
		};
		vBar2.addSelectionListener(listener); 
		
		this.breakpoint = new Image(parentdisplay, MainFrame.class.getResourceAsStream("image/breakpoint.png")); 
		
		this.linenumbers.addPaintObjectListener(new PaintObjectListener() {
	        public void paintObject(PaintObjectEvent event) {
	          GC gc = event.gc;
	          StyleRange style = event.style;
              int x = event.x;
              int y = event.y + event.ascent - style.metrics.ascent;
              if ((Image)event.style.data != null) {
            	  gc.drawImage((Image)event.style.data, x, y);
              }
	        }
	      }); 
	}
	
	public void updateView() {
		//Source updates (necessary because of undo/redo functions)
		if(!this.textfield.getText().equals(this.editor.getSource())) {
			this.textfield.setText(editor.getSource());
		}
		//Syntax highlighting
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
	
	public void setStatementBreakpoint(int line, int set) {	
		StyleRange style = new StyleRange();
		style.start = line * 2 - 2;
		style.length = 1;
		if (set == 1) {
			style.data = this.breakpoint;
		}
		Rectangle rect = this.breakpoint.getBounds();
		style.metrics = new GlyphMetrics(rect.height, 0, rect.width);		
		this.linenumbers.setStyleRange(style);
	}
	
	public void markLine(int line) {
		this.textfield.setLineBackground(line, 1, new Color(this.parentdisplay, 249, 250, 158));
	}
	
	public void removeAllLineBackground() {
		this.textfield.setLineBackground(0, this.textfield.getLineCount(), null);
	}
	
	public String getText() {
		return this.textfield.getText();
	}
	public void setText(String text) {
		this.textfield.setText(text);
	}
	
	public StyledText getTextField() {
		return this.textfield;
	}
	public StyledText getLineNumbers() {
		return this.linenumbers;
	}
}
