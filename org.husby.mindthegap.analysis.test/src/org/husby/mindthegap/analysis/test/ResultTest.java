package org.husby.mindthegap.analysis.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.husby.mindthegap.analysis.Detail;
import org.husby.mindthegap.analysis.Result;
import org.husby.mindthegap.analysis.ResultDetail;
import org.husby.mindthegap.analysis.User;
import org.junit.Before;
import org.junit.Test;

public class ResultTest {

	private Result result;
	private User user;
	private Date commitDate;
	private ResultDetail resultDetail1;

	@Before
	public void setUp() throws Exception {
		result = new Result();
		commitDate = new Date();
		result.setCommitDate(commitDate);
		user = new User();
		user.setName("Jan Inge");
		Detail detail1 = new Detail(0);
		resultDetail1 = new ResultDetail(user, detail1);
	}

	@Test
	public void testResultIsEmpty() {
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void testGivenResultHasUser_ReturnsCorrectUser() {
		result.setUser(user);
		assertEquals(user, result.getUser());
	}

	@Test
	public void testGivenResultHasDate_ReturnsCorrectDate() {
		result.setCommitDate(commitDate);
		assertEquals(commitDate, result.getCommitDate());
	}
	
	@Test
	public void testGivenResultHasResultDetail_ReturnsLengthOne() {
		result.addResultDetail(resultDetail1);
		assertEquals(1, result.getResultDetails().size());
	}
	
	@Test
	public void testGivenResultHasResultDetail_ReturnsCorrectResultDetail() {
		result.addResultDetail(resultDetail1);
		assertEquals(resultDetail1, result.getResultDetails().get(0));
	}

}
