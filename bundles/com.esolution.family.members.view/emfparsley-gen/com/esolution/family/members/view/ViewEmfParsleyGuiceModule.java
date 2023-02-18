package com.esolution.family.members.view;

import com.esolution.family.members.view.edit.action.ViewMenuBuilder;
import com.esolution.family.members.view.ui.provider.ViewFeatureCaptionProvider;
import com.esolution.family.members.view.ui.provider.ViewLabelProvider;
import com.esolution.family.members.view.ui.provider.ViewTableFeaturesProvider;
import org.eclipse.emf.parsley.EmfParsleyGuiceModule;
import org.eclipse.emf.parsley.edit.action.EditingMenuBuilder;
import org.eclipse.emf.parsley.edit.ui.provider.TableViewerContentProvider;
import org.eclipse.emf.parsley.ui.provider.FeatureCaptionProvider;
import org.eclipse.emf.parsley.ui.provider.TableFeaturesProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * com.esolution.family.members.view EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class ViewEmfParsleyGuiceModule extends EmfParsleyGuiceModule {
  public ViewEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }

  @Override
  public Class<? extends TableViewerContentProvider> bindTableViewerContentProvider() {
    return MyTableViewerContentProvider.class;
  }

  @Override
  public Class<? extends ILabelProvider> bindILabelProvider() {
    return ViewLabelProvider.class;
  }

  @Override
  public Class<? extends FeatureCaptionProvider> bindFeatureCaptionProvider() {
    return ViewFeatureCaptionProvider.class;
  }

  @Override
  public Class<? extends TableFeaturesProvider> bindTableFeaturesProvider() {
    return ViewTableFeaturesProvider.class;
  }

  @Override
  public Class<? extends EditingMenuBuilder> bindEditingMenuBuilder() {
    return ViewMenuBuilder.class;
  }
}
