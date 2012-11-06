package org.husby.mindthegap.perspectives;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.husby.mindthegap.views.GapDetailView;
import org.husby.mindthegap.views.GapSummaryView;
import org.husby.mindthegap.views.TopicsView;

public class MainPerspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.addView(TopicsView.ID, IPageLayout.LEFT, 0.2f, layout.getEditorArea());
		layout.addView(GapDetailView.ID, IPageLayout.RIGHT, 0.5f, layout.getEditorArea());
		layout.addView(GapSummaryView.ID, IPageLayout.RIGHT, 0.5f, layout.getEditorArea());
		
	}
}
