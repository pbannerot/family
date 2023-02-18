package com.esolution.family.view.handlers;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class CallGreetingHandler extends AbstractHandler {
	final private static Logger logger = Logger.getLogger(CallGreetingHandler.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		logger.debug("Call greeting execute event " + event.getCommand().getId());
		
		return null;
	}

}
