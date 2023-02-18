package com.esolution.family.view;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.parsley.EmfParsleyJavaGuiceModule;
import org.eclipse.emf.parsley.junit4.AbstractEmfParsleyShellBasedTest;
import org.eclipse.jface.viewers.ILabelProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.esolution.family.view.ui.provider.ViewLabelProvider;
import com.google.inject.Inject;

public class FamilyLabelProviderTest extends AbstractEmfParsleyShellBasedTest {
	final private static Logger logger = Logger.getLogger(FamilyLabelProviderTest.class);
	
	@Inject
	private ILabelProvider labelProvider;

	@Before
	public void setupLabelProvider() {
		createInjector(new EmfParsleyJavaGuiceModule() {
			@Override
			public Class<? extends ILabelProvider> bindILabelProvider() {
				return ViewLabelProvider.class;
			}
		}).
		injectMembers(this);
	}

	@Test
	public void testLabelProviderForEClass() {
		EClass eclass = EcorePackage.eINSTANCE.getEClass();
		logger.debug(labelProvider.getText(eclass));
		Assert.assertEquals("EClass -> EClassifier [org.eclipse.emf.ecore.EClass]", labelProvider.getText(eclass));
	}

	@Test
	public void testLabelProviderForEDataType() {
		Assert.assertEquals("EString [java.lang.String]",
				labelProvider.getText(EcorePackage.eINSTANCE.getEString()));
	}
}
