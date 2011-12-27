package gui.controller;

import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

import gui.EditorView;
import misc.Editor;

public class EditorController implements ModifyListener, VerifyListener, VerifyKeyListener {
	private EditorView editorframe;
	private Editor editor;
	public EditorController(EditorView editorframe, Editor editor) {
		this.editorframe = editorframe;
		this.editor = editor;
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
	public void verifyKey(VerifyEvent event) {
		// TODO need?
	}

}
