package org.husby.mindthegap.analysis;

public class Gap {

	private int current;
	private int wanted;
	private int upperBound = 4;
	private boolean trainingRequested;
	private User user;

	public Gap(int current, int wanted) {
		if(isUpperBoundExeeded(current, wanted, upperBound)){
			throw new UpperBoundExeeded();
		}
		this.current = current;
		this.wanted = wanted;
	}

	public void setCurrent(int current) {
		this.current = current;
		if(isExpert(current)){
			trainingRequested = false;
		}
	}

	public void setWanted(int wanted) {
		this.wanted = wanted;
	}

	public int getGapResult() {
		return wanted-current;
	}
	
	public void setTrainingRequest(boolean trainingRequested) {
		this.trainingRequested = trainingRequested;
	}

	public boolean isTrainingRequested() {
		return trainingRequested;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	private boolean isExpert(int current) {
		return current==upperBound;
	}
	
	private boolean isUpperBoundExeeded(int current, int wanted, int upperBound) {
		return current > upperBound || wanted > upperBound;
	}
		

	public static class UpperBoundExeeded extends RuntimeException {
		private static final long serialVersionUID = 3707181085491854994L;
	}
	
	
}
