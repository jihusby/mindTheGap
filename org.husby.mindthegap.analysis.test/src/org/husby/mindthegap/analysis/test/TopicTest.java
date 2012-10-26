package org.husby.mindthegap.analysis.test;

import static org.junit.Assert.*;

import org.husby.mindthegap.analysis.Topic;
import org.junit.Before;
import org.junit.Test;

public class TopicTest {

	private Topic topic;

	@Before
	public void setUp() throws Exception {
		topic = new Topic("Java");
	}

	@Test
	public void testTopicIsCreatedWithCorrectName() {
		assertEquals("Java", topic.getName());
	}

}
