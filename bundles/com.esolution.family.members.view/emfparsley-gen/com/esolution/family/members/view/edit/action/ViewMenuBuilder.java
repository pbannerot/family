package com.esolution.family.members.view.edit.action;

import com.esolution.family.model.family.Person;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.parsley.edit.action.EditingMenuBuilder;
import org.eclipse.emf.parsley.edit.action.IMenuContributionSpecification;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class ViewMenuBuilder extends EditingMenuBuilder {
  public List<IMenuContributionSpecification> menuContributions(final Person p) {
    IMenuContributionSpecification _actionDelete = this.actionDelete();
    return Collections.<IMenuContributionSpecification>unmodifiableList(CollectionLiterals.<IMenuContributionSpecification>newArrayList(_actionDelete));
  }

  public List<IMenuContributionSpecification> emfMenuContributions(final Person p) {
    return Collections.<IMenuContributionSpecification>unmodifiableList(CollectionLiterals.<IMenuContributionSpecification>newArrayList());
  }
}
