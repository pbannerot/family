package com.esolution.family.members.view;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.parsley.views.OnSelectionTableView;

import com.esolution.family.model.family.FamilyPackage;

public class ViewOnSelectionTableView extends OnSelectionTableView {
	@Override
	protected EClass getEClass() {
		return FamilyPackage.Literals.PERSON;
	}
	
}
