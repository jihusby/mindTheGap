package org.husby.mindthegap.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.husby.mindthegap.GapEditorInput;
import org.husby.mindthegap.editors.GapEditor;
import org.husby.mindthegap.model.Topic;

public class GapDetailAction extends Action implements ISelectionListener, IWorkbenchAction {
	
	private final IWorkbenchWindow window;
	public final static String ID = "org.husby.mindthegap.gap";
	private IStructuredSelection selection;

	public GapDetailAction(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Gap");
		setToolTipText("Vis gap for valgt emne");
		window.getSelectionService().addSelectionListener(this);
	}
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection incoming) {
		if(incoming instanceof IStructuredSelection) {
			selection = (IStructuredSelection) incoming;
			setEnabled(selection.size() == 1 && 
					selection.getFirstElement() instanceof Topic);
		}else {
			setEnabled(false);
		}
	}

	@Override
	public void run() {
		Object item = selection.getFirstElement();
		Topic topic = (Topic) item;
		IWorkbenchPage page = window.getActivePage();
		GapEditorInput input = new GapEditorInput(topic.getSummary());
		try {
			page.openEditor(input, GapEditor.ID);
		}catch (PartInitException e) {
			 System.out.println("PartInitException " + e.getLocalizedMessage());
		}
	}

	@Override
	public void dispose() {
		window.getSelectionService().removeSelectionListener(this);
	}

}
