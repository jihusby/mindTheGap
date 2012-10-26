package org.husby.mindthegap.analysis;

import java.util.Date;
import java.util.LinkedList;

public class Result {

	private User user;
	private Date commitDate;
	private LinkedList<ResultDetail> resultDetails = new LinkedList<ResultDetail>();

	public boolean isEmpty() {
		return true;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Object getUser() {
		return user;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;		
	}

	public Date getCommitDate() {
		return commitDate;
	}

	public void addResultDetail(ResultDetail resultDetail) {
		resultDetails.add(resultDetail);
	}

	public LinkedList<ResultDetail> getResultDetails() {
		return resultDetails;
	}

}
