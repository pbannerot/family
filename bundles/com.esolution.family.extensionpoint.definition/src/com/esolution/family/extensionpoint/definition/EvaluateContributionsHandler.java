package com.esolution.family.extensionpoint.definition;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;

public class EvaluateContributionsHandler extends AbstractHandler {
	final private static Logger logger = Logger.getLogger(EvaluateContributionsHandler.class);
	private static final String IGREETER_ID = "com.esolution.family.extensionpoint.definition.greeter";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
        IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(IGREETER_ID);
        try {
            for (IConfigurationElement e : config) {
                logger.debug("Evaluating extension");
                final Object o =
                        e.createExecutableExtension("class");
                if (o instanceof IGreeter) {
                    executeExtension(o);
                }
            }
        } catch (CoreException ex) {
            logger.error(ex.getMessage());
        }
        
        return null;
    }

    private void executeExtension(final Object o) {
        ISafeRunnable runnable = new ISafeRunnable() {
            @Override
            public void handleException(Throwable e) {
                logger.error("Exception in client");
            }

            @Override
            public void run() throws Exception {
                ((IGreeter) o).greet();
            }
        };
        SafeRunner.run(runnable);
    }
}
