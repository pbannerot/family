package com.esolution.family.view;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.parsley.resource.ResourceManager;

import com.esolution.family.model.family.Family;
import com.esolution.family.model.family.FamilyFactory;
import com.esolution.family.model.family.Man;
import com.esolution.family.model.family.Woman;

public class TreeformResourceManager extends ResourceManager {
	final private static Logger logger = Logger.getLogger(TreeformResourceManager.class);

	@Override
	public void initialize(Resource resource) {
		logger.debug("Initialize family");
		
		Family family = FamilyFactory.eINSTANCE.createFamily();
		family.setName("Ours");
		
		Woman mother = FamilyFactory.eINSTANCE.createWoman();
		mother.setName("Moman ourse");
		mother.setAge(53);
		
		family.getMembers().add(mother);
		
		Man father = FamilyFactory.eINSTANCE.createMan();
		father.setName("Papa ours");
		father.setAge(51);
		
		family.getMembers().add(father);
		
		Woman girl = FamilyFactory.eINSTANCE.createWoman();
		girl.setName("Grande ourse");
		girl.setAge(12);
		girl.setMother(mother);
		girl.setFather(father);
		
		family.getMembers().add(girl);
		
		Man boy = FamilyFactory.eINSTANCE.createMan();
		boy.setName("Petit ours brun");
		boy.setAge(7);
		boy.setMother(mother);
		boy.setFather(father);
		
		family.getMembers().add(boy);
		
		mother.getChildren().add(girl);
		father.getChildren().add(girl);
		mother.getChildren().add(boy);
		father.getChildren().add(boy);
		
		resource.getContents().add(family);
	}
}
