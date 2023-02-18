package com.esolution.family.validation.constraints;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.marker.MarkerUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.dialogs.ListDialog;

import com.esolution.family.validation.Activator;

public class BatchValidate implements IViewActionDelegate {
		final private static Logger logger = Logger.getLogger(BatchValidate.class);
				
		protected Collection<EObject> selectedEObjects = null;
		protected Shell shell = null;
		
		@Override
		public void run(IAction action) {
			ValidationDelegateClientSelector.running = true;
			
			IValidator<EObject> validator = ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
			validator.setOption(IBatchValidator.OPTION_INCLUDE_LIVE_CONSTRAINTS, true);
			validator.setOption(IBatchValidator.OPTION_TRACK_RESOURCES, true);
			
			IStatus results = validator.validate(selectedEObjects);
			
			if (results.isOK()) {
				MessageDialog.openInformation(shell, "Verification", "Sucessfull verification");
			} else {
				ListDialog dialog = new ListDialog(shell);
				dialog.setInput(results);
				dialog.setTitle("Verification");
				dialog.setContentProvider(new IStructuredContentProvider() {

					@Override
					public Object[] getElements(Object inputElement) {
						if (results != null && results.isMultiStatus() && results == inputElement) {
							return results.getChildren();
						} else if (results != null && results == inputElement) {
							return new Object[] {results};
						}
						return new Object[0];
					}

					@Override
					public void dispose() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
						// TODO Auto-generated method stub
						
					}
				});
				dialog.setLabelProvider(new LabelProvider() {
					@Override
					public String getText(Object element) {
						if (element instanceof IStatus) {
							return ((IStatus)element).getMessage();
						}
						return null;
					}
				});
				dialog.setBlockOnOpen(true);
				dialog.setMessage("Verifications erreurs");
				
				if (Window.OK == dialog.open()) {
					Set<EObject> errorSelections = new HashSet<EObject>();
					if (!results.isMultiStatus()) {
						IConstraintStatus cstatus = (IConstraintStatus)results;
						errorSelections.add(cstatus.getTarget());
					} else {
						IStatus[] children = results.getChildren();
						for (IStatus element : children) {
							IConstraintStatus cstatus = (IConstraintStatus)element;
							errorSelections.add(cstatus.getTarget());
						}
					}
//					editor.setSelectionToViewer(errorSelections);
				}
				
			}
			
			logger.debug("run");
			
			ValidationDelegateClientSelector.running = false;
			
			try {
				MarkerUtil.updateMarkers(results);
			} catch (CoreException ce) {
				Activator.getDefault().getLog().log(ce.getStatus());
			}
		}

		@Override
		public void selectionChanged(IAction action, ISelection selection) {
			this.selectedEObjects = null;
			try {
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					this.selectedEObjects = structuredSelection.toList();
				}
			} catch (Exception e) {
				// Exceptions are not expected
				logger.error(e.getMessage());
				throw new RuntimeException(e);
			} finally {
				action.setEnabled((null != selectedEObjects));
			}
			
			for (Object next : selectedEObjects) {
				if (!(next instanceof EObject)) {
					action.setEnabled(false);
				}
			}
			
			logger.debug("selectionChanged");
			
		}

		@Override
		public void init(IViewPart view) {
			logger.debug("init");
			this.shell = view.getViewSite().getShell();
			
		}

}
