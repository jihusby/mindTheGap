package org.husby.mindthegap;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;

public class TopicsView extends ViewPart {
	
	public static final String ID = 
			"org.husby.mindthegap.views.topics";
	
	private TreeViewer treeViewer;
	private TopicType topicType;
	

	public TopicsView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		initializeBogusTopics();
		IAdapterFactory adapterFactory = new AdapterFactory();
		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		Platform.getAdapterManager().registerAdapters(adapterFactory, Topic.class);
		getSite().setSelectionProvider(treeViewer);
		treeViewer.setLabelProvider(new WorkbenchLabelProvider());
		treeViewer.setContentProvider(new BaseWorkbenchContentProvider());
		treeViewer.setInput(topicType);
//		topicType.getTopics().addTopicsListener(new ITopicsListener() {
//			public void topicsChanged(TopicType topics, TopicEntry entry) {
//				treeViever.refresh();
//			}
//		});
	}

	private void initializeBogusTopics() {
		topicType = new TopicType();
		topicType.initTopics();
		
	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

}
