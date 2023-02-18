package com.esolution.family.members.view;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.parsley.edit.ui.provider.TableViewerContentProvider;

import com.esolution.family.model.family.Family;
import com.esolution.family.model.family.Person;
import com.google.inject.Inject;

public class MyTableViewerContentProvider extends TableViewerContentProvider {
	@Inject
	public MyTableViewerContentProvider(final AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Object elements(final Family family) {
		return family.getMembers();
	}
	
	public Object elements(final Person person) {
		return person;
	}
}
