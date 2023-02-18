package com.esolution.family.view.ui.provider;

import org.eclipse.emf.parsley.ui.provider.EClassToEStructuralFeatureAsStringsMap;
import org.eclipse.emf.parsley.ui.provider.FeaturesProvider;

@SuppressWarnings("all")
public class ViewFeaturesProvider extends FeaturesProvider {
  @Override
  public void buildStringMap(final EClassToEStructuralFeatureAsStringsMap stringMap) {
    super.buildStringMap(stringMap);
    
    stringMap.mapTo("com.esolution.family.model.family.Woman",
      "name", "age", "parents", "children");
    stringMap.mapTo("com.esolution.family.model.family.Man",
      "name", "age", "parents", "children");
  }
}
