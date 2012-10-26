package org.husby.mindthegap.analysis.test;

import static org.junit.Assert.*;

import org.husby.mindthegap.analysis.User;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User("Jan Inge");
	}

	@Test
	public void testUserIsCreated() {
		assertNotNull(user);
	}

	@Test
	public void testUserHasName() {
		assertEquals("Jan Inge", user.getName());
	}
	
}
