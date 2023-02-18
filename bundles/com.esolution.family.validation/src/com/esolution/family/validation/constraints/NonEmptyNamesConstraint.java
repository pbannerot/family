package com.esolution.family.validation.constraints;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import com.esolution.family.model.family.Family;
import com.esolution.family.model.family.Person;

public class NonEmptyNamesConstraint extends org.eclipse.emf.validation.AbstractModelConstraint {
	final private static Logger logger = Logger.getLogger(NonEmptyNamesConstraint.class);

	public NonEmptyNamesConstraint() {
		logger.debug("Create constraint model");
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		logger.debug("Call validate");
		
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {
			String name = null;
			
			if (eObj instanceof Family) {
				name = ((Family) eObj).getName();
			}
			
			if (eObj instanceof Person) {
				name = ((Person) eObj).getName();
			}
			
			
			if (name == null || name.length() == 0) {
				return ctx.createFailureStatus(new Object[] {eObj.eClass().getName()});
			}
		} // In the case of live mode.
	else {
		Object newValue = ctx.getFeatureNewValue();
		
		if (newValue == null || ((String)newValue).length() == 0) {
			return ctx.createFailureStatus(new Object[] {eObj.eClass().getName()});
		}
	}
		
		return ctx.createSuccessStatus();
	}

}
