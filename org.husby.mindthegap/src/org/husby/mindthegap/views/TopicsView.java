package org.husby.mindthegap.views;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.husby.mindthegap.Session;
import org.husby.mindthegap.TopicContentProvider;
import org.husby.mindthegap.TopicLabelProvider;
import org.husby.mindthegap.TopicMockModel;
import org.husby.mindthegap.Topic;

public class TopicsView extends ViewPart {
	
	public static final String ID = "org.husby.mindthegap.views.topics";
	
	private TreeViewer treeViewer;
	private Session session;

	public TopicsView() {
		super();
	}

	  public void createPartControl(Composite parent) {
	    treeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
	    treeViewer.setContentProvider(new TopicContentProvider());
	    treeViewer.setLabelProvider(new TopicLabelProvider());
	    // Expand the tree
	    treeViewer.setAutoExpandLevel(2);
	    // Provide the input to the ContentProvider
	    treeViewer.setInput(new TopicMockModel());

	    // Add a doubleclicklistener
	    treeViewer.addDoubleClickListener(new IDoubleClickListener() {

	      @Override
	      public void doubleClick(DoubleClickEvent event) {
	        TreeViewer viewer = (TreeViewer) event.getViewer();
	        IStructuredSelection thisSelection = (IStructuredSelection) event
	            .getSelection();
	        Object selectedNode = thisSelection.getFirstElement();
	        viewer.setExpandedState(selectedNode,
	            !viewer.getExpandedState(selectedNode));
	      }
	    });

	    treeViewer.getTree().addKeyListener(new KeyAdapter() {
	      @Override
	      public void keyReleased(final KeyEvent e) {
	        if (e.keyCode == SWT.DEL) {
	          final IStructuredSelection selection = (IStructuredSelection) treeViewer
	              .getSelection();
	          if (selection.getFirstElement() instanceof Topic) {
	            Topic o = (Topic) selection.getFirstElement();
	            // TODO Delete the selected element from the model
	          }

	        }
	      }
	    });

	  }

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

}
