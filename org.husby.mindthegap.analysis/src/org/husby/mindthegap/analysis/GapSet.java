package org.husby.mindthegap.analysis;

import java.util.LinkedList;

public class GapSet {

	private LinkedList<Gap> gaps;
	private User user;

	public GapSet() {
		super();
		gaps = new LinkedList<Gap>();
	}

	public void add(Gap gap) {
		this.gaps.add(gap);
	}

	public Gap getGapAt(int index) {
		return gaps.get(index);
	}

	public Object size() {
		return gaps.size();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
