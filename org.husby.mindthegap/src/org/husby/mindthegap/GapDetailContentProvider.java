package org.husby.mindthegap;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.husby.mindthegap.model.Category;
import org.husby.mindthegap.model.Gap;
import org.husby.mindthegap.model.Topic;
import org.husby.mindthegap.persistence.GapMockModel;

public class GapDetailContentProvider implements IContentProvider {

	private List<Gap> gaps;
//	private GapMockModel model;

	public GapDetailContentProvider() {
		gaps = new GapMockModel().getGaps();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		System.out.println("FAEN!!");
//		this.model = (GapMockModel) newInput;
	}

	public List<Gap> getGaps(Object input) {
		if (input != null) {
			ArrayList<Gap> l = new ArrayList<Gap>();
			if (input instanceof Category) {
				for (Topic t : ((Category) input).getTopics()) {
					l.addAll(getGapList(t));
				}
			} else if (input instanceof Topic) {
				l.addAll(getGapList((Topic) input));
			}
			return l;
		}
		return null;
	}

	private List<Gap> getGapList(Topic input) {
		List<Gap> l = new ArrayList<Gap>();
		for (Gap gap : gaps) {
			if (isCorrectTopicInGap(gap, input)) {
				l.add(gap);
			}
		}
		return l;
	}

	private boolean isCorrectTopicInGap(Gap gap, Topic t) {
		return ((Topic) gap.getTopic()).getSummary().equals(t.getSummary());
	}

	@Override
	public void dispose() {

	}

}