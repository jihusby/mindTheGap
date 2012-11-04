package org.husby.mindthegap;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.husby.mindthegap.model.Category;
import org.husby.mindthegap.model.Gap;
import org.husby.mindthegap.model.Topic;
import org.husby.mindthegap.model.User;

public class GapDetailContentProvider implements IContentProvider{

	private List<Gap> gaps;

	public GapDetailContentProvider() {
		gaps = new ArrayList<Gap>();
		createMockGaps();
	}

	public List<Gap> getGaps(Object input) {
		if(input!=null){
			ArrayList<Gap> l = new ArrayList<Gap>();
			if(input instanceof Category) {
				for(Topic t : ((Category) input).getTopics()){
					l.addAll(getGapList(t));
				}
			}else if (input instanceof Topic) {
				l.addAll(getGapList((Topic) input));
			}
			return l;
		}
		return null;
	}
	
	private List<Gap> getGapList(Topic input) {
		List<Gap> l = new ArrayList<Gap>();
		for(Gap gap : gaps){
			if(isCorrectTopicInGap(gap, input)){
				l.add(gap);
			}
		}
		return l;
	}

	private boolean isCorrectTopicInGap(Gap gap, Topic t) {
		return ((Topic)gap.getTopic()).getSummary().equals(t.getSummary());
	}

	private void createMockGaps() {
		User user1 = new User("Jan Inge Husby");
		User user2 = new User("Vegar Beider");
		User user3 = new User("Per Kele");
		 
		
		Topic javaTopic = new Topic("Java");
		Topic cTopic = new Topic("Objective-C");
		Topic dotNetTopic = new Topic(".NET");
		Topic scrumTopic = new Topic("Scrum");
		gaps.add(new Gap(javaTopic, user1, 1, 4, true));
		gaps.add(new Gap(javaTopic, user2, 2, 4, true));
		gaps.add(new Gap(javaTopic, user3, 4, 4, false));
		gaps.add(new Gap(dotNetTopic, user1, 2, 3, true));
		gaps.add(new Gap(dotNetTopic, user2, 2, 3, false));
		gaps.add(new Gap(dotNetTopic, user3, 4, 4, false));
		gaps.add(new Gap(cTopic, user3, 2, 2, false));
		gaps.add(new Gap(scrumTopic, user3, 2, 2, false));
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
//		this.gaps = (List<Gap>) newInput;		
	}

}