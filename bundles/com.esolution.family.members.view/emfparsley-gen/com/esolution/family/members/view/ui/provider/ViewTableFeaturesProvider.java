package com.esolution.family.members.view.ui.provider;

import org.eclipse.emf.parsley.ui.provider.EClassToEStructuralFeatureAsStringsMap;
import org.eclipse.emf.parsley.ui.provider.TableFeaturesProvider;

@SuppressWarnings("all")
public class ViewTableFeaturesProvider extends TableFeaturesProvider {
  @Override
  public void buildStringMap(final EClassToEStructuralFeatureAsStringsMap stringMap) {
    super.buildStringMap(stringMap);
    
    stringMap.mapTo("com.esolution.family.model.family.Person",
      "name", "age", "mother", "father");
  }
}
