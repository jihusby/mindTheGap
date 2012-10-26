package org.husby.mindthegap.analysis.test;

import static org.junit.Assert.*;

import org.husby.mindthegap.analysis.Detail;
import org.husby.mindthegap.analysis.Topic;
import org.junit.Before;
import org.junit.Test;

public class TopicTest {

	private Topic topic;
	private Detail detail1;
	private Detail detail2;

	@Before
	public void setUp() throws Exception {
		topic = new Topic();
		detail1 = new Detail(1);
		detail2 = new Detail(2);
	}

	@Test
	public void testTopicEmpty() {
		assertNotNull(topic);
		assertTrue(topic.isEmpty());
	}

	@Test
	public void testGivenTopicWithDetail_NotEmpty() {
		topic.addDetail(detail1);
		assertEquals(false, topic.isEmpty());
	}
	
	@Test
	public void testGivenTopicWithDetail_ReturnsCorrectDetail() {
		topic.addDetail(detail1);
		assertEquals(detail1, topic.getDetails().get(0));		
	}

	@Test
	public void testGivenTopicWithTwoDetails_ReturnsCorrectDetail() {
		topic.addDetail(detail1);
		topic.addDetail(detail2);
		assertEquals(detail1, topic.getDetailById(1));
		assertEquals(detail2, topic.getDetailById(2));
	}

	@Test
	public void testGivenEmptyTopic_ReturnsNullWhenSearchingForDetail() {
		assertNull(topic.getDetailById(2));
	}
	
	@Test
	public void testGivenTopicWithDetail_ReturnsNullWhenSearchingForUnexpectedDetail() {
		topic.addDetail(detail1);
		assertNull(topic.getDetailById(2));
	}

	
}
