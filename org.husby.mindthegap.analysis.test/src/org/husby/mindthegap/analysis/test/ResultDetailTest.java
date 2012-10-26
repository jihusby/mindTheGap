package org.husby.mindthegap.analysis.test;

import static org.junit.Assert.*;

import org.husby.mindthegap.analysis.ResultDetail;
import org.husby.mindthegap.analysis.ResultDetail.EmptyResultDetailException;
import org.junit.Before;
import org.junit.Test;

public class ResultDetailTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test (expected=EmptyResultDetailException.class)
	public void testNullValueResultDetail_ThrowsException() {
		ResultDetail resultDetail = new ResultDetail(null, null);
	}

}
