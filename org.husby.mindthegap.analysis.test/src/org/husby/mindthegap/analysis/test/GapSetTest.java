package org.husby.mindthegap.analysis.test;

import static org.junit.Assert.*;

import org.husby.mindthegap.analysis.Gap;
import org.husby.mindthegap.analysis.GapSet;
import org.husby.mindthegap.analysis.User;
import org.junit.Before;
import org.junit.Test;

public class GapSetTest {

	private GapSet gapSet;
	private User user;

	@Before
	public void setUp() throws Exception {
		gapSet = new GapSet();
		user = new User("Jan Inge");
		gapSet.setUser(user);
	}

	@Test
	public void testGapSetWithUserIsCreated() {
		assertEquals(user, gapSet.getUser());
	}
	
	@Test
	public void testGapSetWithoutGap_ReturnsZeroSize() {
		assertEquals(0, gapSet.size());
	}
	
	@Test
	public void testGapSetWithGap_ReturnsSizeOne() {
		gapSet.add(new Gap(0, 0));
		assertEquals(1, gapSet.size());
	}

	@Test
	public void testGapSetWithOneGap_ReturnsOneCorrectGap() {
		Gap gap = new Gap(0, 0);
		gapSet.add(gap);
		assertEquals(gap, gapSet.getGapAt(0));
	}

	@Test
	public void testGapSetWithTwoGaps_ReturnsTwoCorrectGaps() {
		Gap gap1 = new Gap(0, 0);
		Gap gap2 = new Gap(0, 1);
		gapSet.add(gap1);
		gapSet.add(gap2);
		assertEquals(2, gapSet.size());
		assertEquals(gap1, gapSet.getGapAt(0));
		assertEquals(gap2, gapSet.getGapAt(1));
	}
	
}
