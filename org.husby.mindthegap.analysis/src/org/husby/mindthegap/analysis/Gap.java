package org.husby.mindthegap.analysis;

public class Gap {

	private int current;
	private int wanted;
	private int upperBound = 4;
	private boolean trainingRequested;
	private Topic topic;

	public Gap(int current, int wanted) {
		if(isUpperBoundExeeded(current, wanted, upperBound)){
			throw new UpperBoundExeededException();
		}
		if(isNegativeValues(current, wanted)){
			throw new NegativeValuesException();
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

	private boolean isUpperBoundExeeded(int current, int wanted, int upperBound) {
		return current > upperBound || wanted > upperBound;
	}
			
	private boolean isExpert(int current) {
		return current==upperBound;
	}

	private boolean isNegativeValues(int current, int wanted) {
		return (current < 0) || wanted < 0;
	}
	
	
}
