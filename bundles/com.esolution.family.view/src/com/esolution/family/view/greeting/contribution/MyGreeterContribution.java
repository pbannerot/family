package com.esolution.family.view.greeting.contribution;
import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.PlatformUI;

import com.esolution.family.extensionpoint.definition.IGreeter;

public class MyGreeterContribution implements IGreeter {
	final private static Logger logger = Logger.getLogger(MyGreeterContribution.class);

	@Override
	public void greet() {
		String message = "Call of My Greeter contribution implementation";
		logger.debug(message);
		
		MessageBox dialoig = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
		dialoig.setText("Greeting");
		dialoig.setMessage(message);
		
		logger.debug(dialoig.open());

	}

}
