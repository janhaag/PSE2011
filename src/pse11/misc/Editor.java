package misc;


import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import gui.EditorView;

public class Editor {
	private String source;
	private EditorView editorview;
	private ArrayList<Keyword> colorArray;
	private Stack<EditorMemento> undoMemento;
	private Stack<EditorMemento> redoMemento;
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
