package com.esolution.family.view;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.parsley.views.SaveableTreeFormView;

public class ViewSaveableTreeFormView extends SaveableTreeFormView {
	final private static Logger logger = Logger.getLogger(ViewSaveableTreeFormView.class);
	// The plug-in ID
	public static final String PLUGIN_ID = "com.esolution.family.view"; //$NON-NLS-1$

	@Override
	protected URI createResourceURI() {
		logger.debug("Family loaded");
		return URI.createFileURI(System.getProperty("user.home") + "/my.family");
	}
}
