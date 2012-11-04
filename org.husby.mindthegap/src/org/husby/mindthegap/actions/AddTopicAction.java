package org.husby.mindthegap.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.husby.mindthegap.AddTopicDialog;
import org.husby.mindthegap.model.Category;
import org.husby.mindthegap.model.Topic;

public class AddTopicAction extends Action implements ISelectionListener, IWorkbenchAction {

	private final IWorkbenchWindow window;
	public final static String ID = "no.husby.mindthegap.addTopic";
	private IStructuredSelection selection;
	
	public AddTopicAction(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Add Topic...");
		setToolTipText("Add a new public topic to the list");
		window.getSelectionService().addSelectionListener(this);
	}
	
	@Override
	public void run() {
		AddTopicDialog d = new AddTopicDialog(window.getShell());
		d.create();
		int code = d.open();
		
		if(code == 0){
			saveNewTopicFromDialog(d);
		}
	}
	
	private void saveNewTopicFromDialog(AddTopicDialog dialog) {
		selection = (IStructuredSelection) window.getSelectionService().getSelection();
		if(selection!=null) {
			Object item = selection.getFirstElement();
			Category category = (Category) item;
			Topic topic = new Topic(dialog.getValue());
			category.addTopic(topic);
			System.out.println("topic is " + topic.getSummary());
			// TODO: Get the f***ing tree to update
		}
	}

	@Override
	public void dispose() {
		window.getSelectionService().removeSelectionListener(this);
	}
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection incoming) {
		if(incoming instanceof IStructuredSelection) {
			selection = (IStructuredSelection) incoming;
			setEnabled(selection.size() == 1 && 
					selection.getFirstElement() instanceof Category);
		}else{
			setEnabled(false);
		}
	}
}
