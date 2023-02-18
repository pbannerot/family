package com.esolution.family.view.edit.action;

import com.esolution.family.model.family.Family;
import com.esolution.family.model.family.FamilyFactory;
import com.esolution.family.model.family.Man;
import com.esolution.family.model.family.Person;
import com.esolution.family.model.family.Woman;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.parsley.edit.action.EditingMenuBuilder;
import org.eclipse.emf.parsley.edit.action.IMenuContributionSpecification;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class ViewMenuBuilder extends EditingMenuBuilder {
  public List<IMenuContributionSpecification> emfMenuContributions(final Family it) {
    IMenuContributionSpecification _actionAdd = this.<Woman>actionAdd("Add a female", it.getMembers(), FamilyFactory.eINSTANCE.createWoman());
    IMenuContributionSpecification _actionAdd_1 = this.<Man>actionAdd("Add a male", it.getMembers(), FamilyFactory.eINSTANCE.createMan());
    return Collections.<IMenuContributionSpecification>unmodifiableList(CollectionLiterals.<IMenuContributionSpecification>newArrayList(_actionAdd, _actionAdd_1));
  }

  public List<IMenuContributionSpecification> emfMenuContributions(final Person it) {
    return Collections.<IMenuContributionSpecification>unmodifiableList(CollectionLiterals.<IMenuContributionSpecification>newArrayList());
  }
}
