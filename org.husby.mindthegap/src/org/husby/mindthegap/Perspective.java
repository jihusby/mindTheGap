package org.husby.mindthegap;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		layout.addView(TopicsView.ID, IPageLayout.LEFT, 0.2f, layout.getEditorArea());
	}
}
