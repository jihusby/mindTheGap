package org.husby.mindthegap.views;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.husby.mindthegap.TopicContentProvider;
import org.husby.mindthegap.TopicLabelProvider;
import org.husby.mindthegap.model.Topic;
import org.husby.mindthegap.persistence.TopicMockModel;

public class TopicsView extends ViewPart {

	public static final String ID = "org.husby.mindthegap.views.topics";

	private TreeViewer topicsTreeViewer;

	public TopicsView() {
		super();
	}

	public void createPartControl(Composite parent) {
		topicsTreeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		topicsTreeViewer.setContentProvider(new TopicContentProvider());
		topicsTreeViewer.setLabelProvider(new TopicLabelProvider());
		topicsTreeViewer.setAutoExpandLevel(2);
		topicsTreeViewer.setInput(new TopicMockModel());
		getSite().setSelectionProvider(topicsTreeViewer);

		topicsTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

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

		topicsTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				System.out.println("TopicsView.selectionChanged");
			}
		});

		topicsTreeViewer.getTree().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(final KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					final IStructuredSelection selection = (IStructuredSelection) topicsTreeViewer
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
		topicsTreeViewer.getControl().setFocus();
	}

}
