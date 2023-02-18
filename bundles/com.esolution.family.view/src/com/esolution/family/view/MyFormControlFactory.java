package com.esolution.family.view;

import org.apache.log4j.Logger;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.parsley.composite.FormControlFactory;
import org.eclipse.emf.parsley.util.DatabindingUtil;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.nebula.widgets.opal.nebulaslider.NebulaSlider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("all")
public class MyFormControlFactory extends FormControlFactory {
	final private static Logger logger = Logger.getLogger(MyFormControlFactory.class);
	
	public Control control_Person_name(final IObservableValue observableValue, final EStructuralFeature feature) {
	    Control control = createControl_Person_name();
	    bindValue(
	    	feature,
	    	createTarget_Person_name(control),
	    	observableValue);
	    return control;
	  }
	  
	  protected Control createControl_Person_name() {
	    final Text t = this.createText("");
	    t.setEditable(true);
	    t.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
	    return t;
	  }
	  
	  protected IObservableValue createTarget_Person_name(final Control it) {
	    ISWTObservableValue _observeText = DatabindingUtil.observeText(it, SWT.Modify);
	    return _observeText;
	  }

	  public Control control_Person_age(final IObservableValue observableValue, final EStructuralFeature feature) {
		  NebulaSlider control = new NebulaSlider(getParent(), SWT.NONE);
		  control.setMinimum(0);
		  control.setMaximum(125);
		  control.setValue((int) observableValue.getValue());
		  control.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		  
		  control.addSelectionListener(new SelectionAdapter() {
			     @Override
			     public void widgetSelected(SelectionEvent e) {
			    	 observableValue.setValue(control.getValue());
			     }
		  });
		  
		  return control;
	  }
}
