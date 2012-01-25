package misc;

import interpreter.GlobalBreakpoint;
import interpreter.StatementBreakpoint;

import java.util.ArrayList;
import java.util.Stack;

import gui.EditorView;

/**
 * This class provides an instance of an editor with several features:<ul>
 * <li>undo/redo function</li>
 * <li>Syntax HL</li>
 * <li>interface for one view</li>
 * </ul>
 *
 * @version 1.0
 */
public class Editor {
	/**
	 * the source the editor is working with
	 */
	private String source;
	/**
	 * the of the editor
	 */
	private EditorView editorview;
	/**
	 * a list of keywords
	 */
	private ArrayList<Keyword> colorArray;
	/**
	 * a list of past versions which have been changed trough user action or through
	 * the redo function
	 */
	private Stack<EditorMemento> undoMemento;
	/**
	 * a list of past versions which have been changed trough the undo function
	 */
	private Stack<EditorMemento> redoMemento;

	private ArrayList<StatementBreakpoint> statementBreakpoints;

	/**
	 * Constructs a new instance of Editor.
	 *
	 * The source will be initialized to an empty String.
	 */
	public Editor() {
		this.source = "";
		this.colorArray = new ArrayList<Keyword>();
		this.undoMemento = new Stack<EditorMemento>();
		this.redoMemento = new Stack<EditorMemento>();
		
		this.statementBreakpoints = new ArrayList<StatementBreakpoint>();
	}
	public void setView(EditorView view) {
		this.editorview = view;
	}
	public ArrayList<Keyword> getColorArray() {
		return this.colorArray;
	}
	public String getSource() {
		return this.source;
	}
	public void setSource(String source) {
		if(!this.undoMemento.empty()) {
			if(!this.undoMemento.peek().equals(this.createMemento())) {
				//System.out.println(this.undoMemento.peek().getSource() + " __ " + this.source);
				this.undoMemento.push(this.createMemento());
			} else {
				System.out.println("NE");
			}
		} else {
			this.undoMemento.push(this.createMemento());
		}
		this.source = source;
		findKeywords(source);
		this.editorview.updateView();
	}
	public void undo() {
		if(!this.undoMemento.empty()) {
			EditorMemento memento = this.undoMemento.pop();
			if(!this.redoMemento.empty()) {
				if(!this.redoMemento.peek().equals(this.createMemento()))
					this.redoMemento.push(this.createMemento());
			} else {
				this.redoMemento.push(this.createMemento());
			}
			this.source = memento.getSource();
			this.editorview.updateView();
		}
		//System.out.println(this.undoMemento.size());
	}
	public void redo() {
		if(!this.redoMemento.empty()) {
			EditorMemento memento = this.redoMemento.pop();
			if(!this.undoMemento.empty()) {
				if(!this.undoMemento.peek().equals(this.createMemento()))
					this.undoMemento.push(this.createMemento());
			} else {
				this.undoMemento.push(this.createMemento());
			}
			this.source = memento.getSource();
			this.editorview.updateView();
		}
	}
	private EditorMemento createMemento() {
		return new EditorMemento(this.source);
	}
	/**
	 * Find the keywords in the given source and add them to the list of keywords
	 * (@see {@link Editor#colorArray}).
	 *
	 * @param source the text which should be searched
	 */
	private void findKeywords(String source) {
		this.colorArray.clear();
		int position = 0;
		String word = "";
		ArrayList <Keyword> tmplist = new ArrayList<Keyword>();
		for(int i = 0; i < source.length(); i++) {
			char currentchar = source.charAt(i);
			if(currentchar == (' ') || currentchar == ('\r') || currentchar == '\n' || currentchar == '\t') {
				String[] keywords = word.split("\\W");
				int positionplus = 0;
				for(String subword : keywords) {
					Keyword keyword = this.addKeyWordColor(position+positionplus, subword);
					positionplus += (subword.length() + 1);
					if(keyword != null) {
						this.colorArray.add(keyword);
					}
				}
				word = "";
				position = i+1;
				tmplist.clear();
			} else {
				this.colorArray.removeAll(tmplist);
				word += source.charAt(i);
				String[] keywords = word.split("\\W");
				int positionplus = 0;
				for(String subword : keywords) {
					Keyword keyword = this.addKeyWordColor(position+positionplus, subword);
					positionplus += (subword.length() + 1);
					if(keyword != null) {
						this.colorArray.add(keyword);
						tmplist.add(keyword);
					}
				}
			}
		}
		Keyword keyword = this.addKeyWordColor(position, word);
		if(keyword != null) {
			this.colorArray.add(keyword);
		}
	}
	private Keyword addKeyWordColor(int position, String keyword) {
		if(keyword.equals("if")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("while")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("true")) {
			return new Keyword(position,keyword.length(),"00FF00");
		} else if(keyword.equals("false")) {
			return new Keyword(position,keyword.length(),"FF0000");
		} else if(keyword.equals("int")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("bool")) {
			return new Keyword(position,keyword.length(),"0000FF");
        } else if(keyword.equals("array")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("else")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("return")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("assert")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("assume")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("axiom")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("ensure")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("invariant")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("forall")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("exists")) {
			return new Keyword(position,keyword.length(),"0000FF");
		}else if(keyword.equals("main")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.matches("\\d+")) {
			return new Keyword(position,keyword.length(),"FF8000");
		}  else {
			return null;
		}
	}
	
	public int addBreakpoint(int line) {
		for (int i = 0; i < this.statementBreakpoints.size(); i++) {
			if (this.statementBreakpoints.get(i).getLine() == line) {
				this.statementBreakpoints.remove(i);
				return 0;
			}
		}
		StatementBreakpoint newStatementBreakpoint = new StatementBreakpoint(line);
		this.statementBreakpoints.add(newStatementBreakpoint);
		return 1;
	}
	
	public ArrayList<StatementBreakpoint> getStatementBreakpoints() {
		return this.statementBreakpoints;
	}
}
