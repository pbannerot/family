package com.esolution.family.application;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	@Override	
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		
		IFolderLayout folder = layout.createFolder("SSPC", IPageLayout.TOP, 0.5f, editorArea);
		folder.addView("com.esolution.family.view");
		
		layout.getViewLayout("com.esolution.family.view").setCloseable(false);
	}
}
