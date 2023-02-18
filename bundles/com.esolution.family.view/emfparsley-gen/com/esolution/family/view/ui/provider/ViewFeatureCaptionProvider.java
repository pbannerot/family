package com.esolution.family.view.ui.provider;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.parsley.ui.provider.FeatureCaptionProvider;

@SuppressWarnings("all")
public class ViewFeatureCaptionProvider extends FeatureCaptionProvider {
  public String text_Family_name(final EStructuralFeature it) {
    return "Nom ";
  }

  public String text_Person_name(final EStructuralFeature it) {
    return "Nom ";
  }

  public String text_Person_parents(final EStructuralFeature it) {
    return "Parents ";
  }

  public String text_Person_children(final EStructuralFeature it) {
    return "Enfants ";
  }

  public String text_Person_age(final EStructuralFeature it) {
    return "Age ";
  }
}
