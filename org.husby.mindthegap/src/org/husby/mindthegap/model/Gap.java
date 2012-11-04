package org.husby.mindthegap.model;

public class Gap {

	private int current;
	private int wanted;
	private int upperBound = 4;
	private boolean trainingRequested;
	private Topic topic;
	private User user;

	public Gap(Topic topic, User user, int current, int wanted, boolean trainingRequested) {
		if(isUpperBoundExeeded(current, wanted, upperBound)){
			throw new UpperBoundExeededException();
		}
		if(isNegativeValues(current, wanted)){
			throw new NegativeValuesException();
		}
		this.topic = topic;
		this.user = user;
		this.current = current;
		this.wanted = wanted;
		this.trainingRequested = trainingRequested;
	}

	public void setCurrent(int current) {
		this.current = current;
		if(isExpert(current)){
			trainingRequested = false;
		}
	}

	public User getUser() {
		return user;
	}
	
	public void setWanted(int wanted) {
		this.wanted = wanted;
	}
	
	public int getCurrent() {
		return current;
	}

	public int getWanted() {
		return wanted;
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

	private boolean isExpert(int current) {
		return current==upperBound;
	}

	private boolean isNegativeValues(int current, int wanted) {
		return (current < 0) || wanted < 0;
	}
	
	private boolean isUpperBoundExeeded(int current, int wanted, int upperBound) {
		return current > upperBound || wanted > upperBound;
	}
		

	public static class NegativeValuesException extends RuntimeException {
		private static final long serialVersionUID = -4159711657903452472L;
	}

	public static class UpperBoundExeededException extends RuntimeException {
		private static final long serialVersionUID = 3707181085491854994L;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Object getTopic() {
		return topic;
	}
	
}
