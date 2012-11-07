package org.husby.mindthegap.persistence;

import java.util.ArrayList;
import java.util.List;

import org.husby.mindthegap.model.Gap;
import org.husby.mindthegap.model.Topic;
import org.husby.mindthegap.model.User;

public class GapMockModel {

	public List<Gap> getGaps() {
		List<Gap> gaps = new ArrayList<Gap>();
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

		return gaps;
	}

}