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
	/**
	 * Find the keywords in the given source and add them to the list of keywords
	 * (@see {@link Editor#colorArray}).
	 * 
	 * @param source the text which should be searched
	 */
	private void findKeywords(String source) {
		this.colorArray.clear();
		int position = 0;
		StringTokenizer tokenizer = new StringTokenizer(source);
		//TODO MIND: "if(", "true;", ...
		//TODO Enter/Absatz macht Positionen kaputt!
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if(token.equals("if")) {
				this.colorArray.add(new Keyword(position,token.length(),"0000FF"));
			} else if(token.equals("while")) {
				this.colorArray.add(new Keyword(position,token.length(),"0000FF"));
			} else if(token.equals("true")) {
				this.colorArray.add(new Keyword(position,token.length(),"00FF00"));
			} else if(token.equals("false")) {
				this.colorArray.add(new Keyword(position,token.length(),"FF0000"));
			} else if(token.equals("int")) {
				this.colorArray.add(new Keyword(position,token.length(),"0000FF"));
			} else if(token.equals("boolean")) {
				this.colorArray.add(new Keyword(position,token.length(),"0000FF"));
			}
			position += (token.length() + 1);
			System.out.println(position);
		}
	}
}
