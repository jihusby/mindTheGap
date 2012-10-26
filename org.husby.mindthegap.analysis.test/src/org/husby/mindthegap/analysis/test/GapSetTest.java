package org.husby.mindthegap.analysis.test;

import static org.junit.Assert.*;

import org.husby.mindthegap.analysis.Gap;
import org.husby.mindthegap.analysis.GapSet;
import org.junit.Before;
import org.junit.Test;

public class GapSetTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGapSetWithoutGap_ReturnsZeroSize() {
		GapSet gapSet = new GapSet();
		assertEquals(0, gapSet.size());
	}
	
	@Test
	public void testGapSetWithGap_ReturnsNotSizeOne() {
		GapSet gapSet = new GapSet();
		gapSet.add(new Gap(0, 0));
		assertEquals(1, gapSet.size());
	}

	@Test
	public void testGapSetWithOneGap_ReturnsCorrectGap() {
		GapSet gapSet = new GapSet();
		Gap gap = new Gap(0, 0);
		gapSet.add(gap);
		assertEquals(gap, gapSet.getGapAt(0));
	}

	@Test
	public void testGapSetWithTwoGaps_ReturnsCorrectGaps() {
		GapSet gapSet = new GapSet();
		Gap gap1 = new Gap(0, 0);
		Gap gap2 = new Gap(0, 1);
		gapSet.add(gap1);
		gapSet.add(gap2);
		assertEquals(gap1, gapSet.getGapAt(0));
		assertEquals(gap2, gapSet.getGapAt(1));
	}
	
}
