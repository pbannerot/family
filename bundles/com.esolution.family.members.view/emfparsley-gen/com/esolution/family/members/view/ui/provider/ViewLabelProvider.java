package com.esolution.family.members.view.ui.provider;

import com.esolution.family.model.family.Family;
import com.esolution.family.model.family.Man;
import com.esolution.family.model.family.Person;
import com.esolution.family.model.family.Woman;
import com.google.inject.Inject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.parsley.ui.provider.ViewerLabelProvider;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ViewLabelProvider extends ViewerLabelProvider {
  @Inject
  public ViewLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }

  public String text(final Family it) {
    String _xifexpression = null;
    String _name = it.getName();
    boolean _tripleNotEquals = (null != _name);
    if (_tripleNotEquals) {
      _xifexpression = it.getName();
    } else {
      _xifexpression = "";
    }
    String _plus = ("Famille " + _xifexpression);
    return _plus;
  }

  public String text(final Person it) {
    String _xifexpression = null;
    String _name = it.getName();
    boolean _tripleEquals = (null == _name);
    if (_tripleEquals) {
      _xifexpression = "";
    } else {
      _xifexpression = StringExtensions.toFirstUpper(it.getName());
    }
    return _xifexpression;
  }

  public Object image(final Family it) {
    return "Family.gif";
  }

  public Object image(final Woman it) {
    return "Woman.gif";
  }

  public Object image(final Man it) {
    return "Man.gif";
  }
}
