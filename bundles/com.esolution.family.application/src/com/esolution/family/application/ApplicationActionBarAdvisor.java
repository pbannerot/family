package com.esolution.family.application;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

//	private IWorkbenchAction newAction;
//	private IWorkbenchAction openAction;
	private IWorkbenchAction saveAction;
//	private IWorkbenchAction importAction;
//	private IWorkbenchAction exportAction;
	private IWorkbenchAction exitAction;
	
	private IWorkbenchAction undoAction;
	private IWorkbenchAction redoAction;
	private IWorkbenchAction cutAction;
	private IWorkbenchAction copyAction;
	private IWorkbenchAction pasteAction;
	private IWorkbenchAction deleteAction;
	
	private IWorkbenchAction aboutAction;

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}
	
	@Override
	protected void makeActions(final IWorkbenchWindow window) {
		// Creates the actions and registers them.
		// Registering is needed to ensure that key bindings work.
		// The corresponding commands keybindings are defined in the plugin.xml file.
		// Registering also provides automatic disposal of the actions when
		// the window is closed.
		
		exitAction = ActionFactory.QUIT.create(window);
        register(exitAction);
			
//		newAction = ActionFactory.NEW.create(window);
//		register(newAction);
		
//		openAction = ActionFactory.OPEN.create(window);
//		register(openAction);
		
//		importAction = ActionFactory.IMPORT.create(window);
//		register(importAction);
		
//		exportAction = ActionFactory.EXPORT.create(window);
//		register(exportAction);
		
		saveAction = ActionFactory.SAVE.create(window);
		register(saveAction);
		
		undoAction = ActionFactory.UNDO.create(window);
		register(undoAction);
		
		redoAction = ActionFactory.REDO.create(window);
		register(redoAction);
		
		cutAction = ActionFactory.CUT.create(window);
		register(cutAction);
		
		copyAction = ActionFactory.COPY.create(window);
		register(copyAction);
		
		pasteAction = ActionFactory.PASTE.create(window);
		register(pasteAction);
		
		deleteAction = ActionFactory.DELETE.create(window);
		register(deleteAction);
		
		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);
	}

	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
		MenuManager editMenu = new MenuManager("&Edit", IWorkbenchActionConstants.M_EDIT);
		MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		// Add a group marker indicating where action set menus will appear.
		menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuBar.add(helpMenu);
		
		// File
//		fileMenu.add(newAction);
//		fileMenu.add(openAction);
		fileMenu.add(saveAction);
		fileMenu.add(new Separator());
//		fileMenu.add(importAction);
//		fileMenu.add(exportAction);
		fileMenu.add(exitAction);
		
		// Edit
		editMenu.add(undoAction);
		editMenu.add(redoAction);
		fileMenu.add(new Separator());
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		fileMenu.add(new Separator());
		editMenu.add(deleteAction);
		
		// Help
		helpMenu.add(aboutAction);
	}

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		IToolBarManager mainToolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
		mainToolbar.add(saveAction);
		mainToolbar.add(deleteAction);
		coolBar.add(new ToolBarContributionItem(mainToolbar, "main"));

		IToolBarManager perspectiveToolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
		coolBar.add(new ToolBarContributionItem(perspectiveToolbar, "perspective"));
	}

}

