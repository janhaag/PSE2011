package gui;

import gui.controller.EditorController;
import gui.controller.MainController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;


public class MenuBar {
	private Menu menu;
	private MenuItem newFileItem;
	private MenuItem exitItem;
	private MenuItem loadItem;
	private MenuItem saveItem;
	private MenuItem helpItem;
	private MenuItem cutItem;
	private MenuItem copyItem;
	private MenuItem pasteItem;
	private MenuItem undoItem;
	private MenuItem redoItem;
	private MenuItem settingsItem;
	private MenuItem runItem;
	private MenuItem stepItem;
	private MenuItem aboutItem;
	private MenuItem randomTestItem;
	
	public MenuBar(MainController controller, Shell shell) {
		initiateMenuBar(controller, null, shell);
	}
	public MenuItem getMenuBarItemNewFile() {
		return this.newFileItem;
	}
	public MenuItem getMenuBarItemExit() {
		return this.exitItem;
	}
	public MenuItem getMenuBarItemLoad() {
		return this.loadItem;
	}
	public MenuItem getMenuBarItemSave() {
		return this.saveItem;
	}
	public MenuItem getMenuBarItemSettings() {
		return this.settingsItem;
	}
	public MenuItem getMenuBarItemRun() {
		return this.runItem;
	}
	public MenuItem getMenuBarItemStep() {
		return this.stepItem;
	}
	public MenuItem getMenuBarItemRandomTest() {
		return this.randomTestItem;
	}
	public MenuItem getMenurBarItemAbout() {
		return this.aboutItem;
	}
	public MenuItem getMenuBarItemHelp() {
		return this.helpItem;
	}
	public MenuItem getMenurBarItemUndo() {
		return this.undoItem;
	}
	public MenuItem getMenuBarItemRedo() {
		return this.redoItem;
	}
	public MenuItem getMenuBarItemCut() {
		return this.cutItem;
	}
	public MenuItem getMenuBarItemCopy() {
		return this.copyItem;
	}
	public MenuItem getMenuBarItemPaste() {
		return this.pasteItem;
	}
	
	private void initiateMenuBar(MainController controller, EditorController editorController, Shell shell) {
		menu = new Menu(shell,SWT.BAR);
		
		final MenuItem file = new MenuItem(menu, SWT.CASCADE);
		file.setText("File");
		final Menu filemenu = new Menu(shell, SWT.DROP_DOWN);
		file.setMenu(filemenu);
		newFileItem = new MenuItem(filemenu, SWT.PUSH);
		newFileItem.setText("New");
		newFileItem.addSelectionListener(controller);
		new MenuItem(filemenu, SWT.SEPARATOR);
		loadItem = new MenuItem(filemenu, SWT.PUSH);
		loadItem.setText("Load");
		loadItem.addSelectionListener(controller);
		saveItem = new MenuItem(filemenu, SWT.PUSH);
		saveItem.setText("Save");
		saveItem.addSelectionListener(controller);
		new MenuItem(filemenu, SWT.SEPARATOR);
		exitItem = new MenuItem(filemenu, SWT.PUSH);
		exitItem.setText("Exit");
		exitItem.addSelectionListener(controller);
		
		final MenuItem edit = new MenuItem(menu, SWT.CASCADE);
		edit.setText("Edit");
		final Menu editmenu = new Menu(shell, SWT.DROP_DOWN);
		edit.setMenu(editmenu);
		this.undoItem = new MenuItem(editmenu, SWT.PUSH);
		this.undoItem.setText("Undo");
		this.undoItem.addSelectionListener(controller);
		this.redoItem = new MenuItem(editmenu, SWT.PUSH);
		this.redoItem.setText("Redo");
		this.redoItem.addSelectionListener(controller);
		new MenuItem(editmenu, SWT.SEPARATOR);
		this.cutItem = new MenuItem(editmenu, SWT.PUSH);
		this.cutItem.setText("Cut");
		this.cutItem.addSelectionListener(controller);
		this.copyItem = new MenuItem(editmenu, SWT.PUSH);
		this.copyItem.setText("Copy");
		this.copyItem.addSelectionListener(controller);
		this.pasteItem = new MenuItem(editmenu, SWT.PUSH);
		this.pasteItem.setText("Paste");
		this.pasteItem.addSelectionListener(controller);
		new MenuItem(editmenu, SWT.SEPARATOR);
		settingsItem = new MenuItem(editmenu, SWT.PUSH);
		settingsItem.setText("Settings");
		settingsItem.addSelectionListener(controller);
				
		final MenuItem run = new MenuItem(menu, SWT.CASCADE);
		run.setText("Run");
		final Menu runmenu = new Menu(shell, SWT.DROP_DOWN);
		run.setMenu(runmenu);
		runItem = new MenuItem(runmenu, SWT.PUSH);
		runItem.setText("Run");
		runItem.addSelectionListener(controller);
		stepItem = new MenuItem(runmenu, SWT.PUSH);
		stepItem.setText("Single Step");
		stepItem.addSelectionListener(controller);
		new MenuItem(runmenu, SWT.SEPARATOR);
		randomTestItem = new MenuItem(runmenu, SWT.PUSH);
		randomTestItem.setText("Random Tests");
		randomTestItem.addSelectionListener(controller);
		new MenuItem(runmenu, SWT.SEPARATOR);
		final MenuItem verItem = new MenuItem(runmenu, SWT.PUSH);
		verItem.setText("Verify");
		
		final MenuItem help = new MenuItem(menu, SWT.CASCADE);
		help.setText("Help");
		final Menu helpmenu = new Menu(shell, SWT.DROP_DOWN);
		help.setMenu(helpmenu);
		this.helpItem = new MenuItem(helpmenu, SWT.PUSH);
		this.helpItem.setText("Help");
		this.helpItem.addSelectionListener(controller);
		this.aboutItem = new MenuItem(helpmenu, SWT.PUSH);
		this.aboutItem.setText("About");
		this.aboutItem.addSelectionListener(controller);
		
		shell.setMenuBar(menu);
	}
}
