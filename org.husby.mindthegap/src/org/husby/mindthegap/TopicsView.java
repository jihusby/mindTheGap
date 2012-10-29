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
	private Session session;

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
		treeViewer.setInput(session.getRoot());
		session.getRoot().addTopicListener(new ITopicsListener(){
			@Override
			public void topicsChanged(TopicsGroup topics, TopicEntry entry) {
				treeViewer.refresh();
			}
		});
	}

	private void initializeBogusTopics() {
		session = new Session();
		TopicsGroup root = session.getRoot();
		TopicsGroup languageGroup = new TopicsGroup(root, "Programming languages");
		languageGroup.addEntry(new TopicEntry(languageGroup, "Java"));
		languageGroup.addEntry(new TopicEntry(languageGroup, "C++"));
		languageGroup.addEntry(new TopicEntry(languageGroup, "Pascal"));
		languageGroup.addEntry(new TopicEntry(languageGroup, "Cobol"));
		root.addEntry(languageGroup);
	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

}
