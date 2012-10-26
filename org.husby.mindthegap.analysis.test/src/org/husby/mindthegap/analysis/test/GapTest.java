package org.husby.mindthegap.analysis.test;

import static org.junit.Assert.*;

import org.husby.mindthegap.analysis.Gap;
import org.husby.mindthegap.analysis.Gap.UpperBoundExeeded;
import org.husby.mindthegap.analysis.User;
import org.junit.Before;
import org.junit.Test;

public class GapTest {

	private Gap gap;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGapResultIsOne() {
		createGapWithCurrentAndWanted(1, 2);
		assertEquals(1, gap.getGapResult());		
	}

	@Test
	public void testGapResultIsTwo() {
		createGapWithCurrentAndWanted(1, 3);
		assertEquals(2, gap.getGapResult());
	}

	@Test
	public void testNegativeGapIsTwo() {
		createGapWithCurrentAndWanted(3, 1);
		assertEquals(-2, gap.getGapResult());
	}
	
	@Test
	public void testChangeCurrentInExistingGap_ReturnsCorrectGapResult() {
		createGapWithCurrentAndWanted(1, 1);
		gap.setCurrent(2);
		assertEquals(-1, gap.getGapResult());
	}

	@Test
	public void testChangeWantedInExistingGap_ReturnsCorrectGapResult() {
		createGapWithCurrentAndWanted(1, 1);
		gap.setWanted(2);
		assertEquals(1, gap.getGapResult());
	}
	
	@Test(expected=UpperBoundExeeded.class)
	public void testUpperCurrentBoundaryMaxFour() {
		createGapWithCurrentAndWanted(5, 1);
	}

	@Test(expected=UpperBoundExeeded.class)
	public void testUpperWantedBoundaryMaxFour() {
		createGapWithCurrentAndWanted(1, 5);
	}
	
	@Test
	public void testTrainingIsRequested() {
		createGapWithCurrentAndWanted(1, 4);
		gap.setTrainingRequest(true);
		assertTrue(gap.isTrainingRequested());
	}

	@Test
	public void testTrainingIsNotRequested() {
		createGapWithCurrentAndWanted(1, 4);
		gap.setTrainingRequest(false);
		assertFalse(gap.isTrainingRequested());
	}

	@Test
	public void testGapWithUser_ReturnsCorrectUser() {
		createGapWithCurrentAndWanted(1, 4);
		User user = new User("Jan Inge");
		gap.setUser(user);
		assertEquals(user, gap.getUser());
	}
	
	@Test
	public void testGivenCurrentIsMax_TrainingIsNotRequested() {
		createGapWithCurrentAndWanted(3, 4);
		gap.setTrainingRequest(true);
		gap.setCurrent(4);
		assertFalse(gap.isTrainingRequested());
	}
	
	private void createGapWithCurrentAndWanted(int current, int wanted) {
		gap = new Gap(current, wanted);
	}
	
	
}
