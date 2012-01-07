package misc;


import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

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
		this.source = source;
		findKeywords(source);
		this.editorview.updateView();
	}
	public void undo() {
		if(!this.undoMemento.empty()) {
			EditorMemento memento = this.undoMemento.pop();
			this.redoMemento.push(this.createMemento());
			this.setSource(memento.getSource());
		}
	}
	public void redo() {
		if(!this.redoMemento.empty()) {
			EditorMemento memento = this.redoMemento.pop();
			this.undoMemento.push(this.createMemento());
			this.setSource(memento.getSource());
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
		for(int i = 0; i < source.length(); i++) {
			char currentchar = source.charAt(i);
			if(currentchar == (' ') || currentchar == ('\r') || currentchar == '\n') {
				position = i+1;
			} else {
				Keyword word = this.addKeyWordColor(position, source.substring(position, (i + 1)));
				if(word != null) {
					this.colorArray.add(word);
				}
			}
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
		} else if(keyword.equals("boolean")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("while")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else if(keyword.equals("else")) {
			return new Keyword(position,keyword.length(),"0000FF");
		} else {
			return null;
		}
	}
}
