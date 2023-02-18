package com.esolution.family.view;

import org.apache.log4j.Logger;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.parsley.composite.DialogControlFactory;
import org.eclipse.nebula.widgets.opal.nebulaslider.NebulaSlider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

@SuppressWarnings("all")
public class MyDialogReadOnlyControlFactory extends DialogControlFactory {
	final private static Logger logger = Logger.getLogger(MyDialogReadOnlyControlFactory.class);
	
	@Override
	public void init(Composite parent) {
		super.init(parent);
		setReadonly(true);
	}
	
	public Control control_Person_age(final IObservableValue observableValue, final EStructuralFeature feature) {
		  NebulaSlider control = new NebulaSlider(getParent(), SWT.NONE);
		  control.setMinimum(0);
		  control.setMaximum(125);
		  control.setValue((int) observableValue.getValue());
		  
		  control.addSelectionListener(new SelectionAdapter() {
			     @Override
			     public void widgetSelected(SelectionEvent e) {
			    	 observableValue.setValue(control.getValue());
			     }
		  });
		  
		  return control;
	  }

}
