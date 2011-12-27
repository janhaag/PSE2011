package gui;

import gui.controller.MainController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;


public class MenuBar {
	private Menu menu;
	private MenuItem exitItem;
	private MenuItem helpItem;
	private MenuItem settingsItem;
	private MenuItem aboutItem;
	public MenuBar(MainController controller, Shell shell) {
		initiateMenuBar(controller, shell);
	}
	public MenuItem getMenuBarItemExit() {
		return this.exitItem;
	}
	public MenuItem getMenuBarItemHelp() {
		return this.helpItem;
	}
	public MenuItem getMenuBarItemSettings() {
		return this.settingsItem;
	}
	public MenuItem getMenurBarItemAbout() {
		return this.aboutItem;
	}
	private void initiateMenuBar(MainController controller, Shell shell) {
		menu = new Menu(shell,SWT.BAR);
		
		final MenuItem file = new MenuItem(menu, SWT.CASCADE);
		file.setText("File");
		final Menu filemenu = new Menu(shell, SWT.DROP_DOWN);
		file.setMenu(filemenu);
		final MenuItem newFileItem = new MenuItem(filemenu, SWT.PUSH);
		newFileItem.setText("New");
		final MenuItem loadItem = new MenuItem(filemenu, SWT.PUSH);
		loadItem.setText("Load");
		final MenuItem saveItem = new MenuItem(filemenu, SWT.PUSH);
		saveItem.setText("Save");
		exitItem = new MenuItem(filemenu, SWT.PUSH);
		exitItem.setText("Exit");
		exitItem.addSelectionListener(controller);
		
		final MenuItem edit = new MenuItem(menu, SWT.CASCADE);
		edit.setText("Edit");
		final Menu editmenu = new Menu(shell, SWT.DROP_DOWN);
		edit.setMenu(editmenu);
		final MenuItem undoItem = new MenuItem(editmenu, SWT.PUSH);
		undoItem.setText("Undo");
		final MenuItem redoItem = new MenuItem(editmenu, SWT.PUSH);
		redoItem.setText("Redo");
		settingsItem = new MenuItem(editmenu, SWT.PUSH);
		settingsItem.setText("Settings");
		settingsItem.addSelectionListener(controller);
		
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
