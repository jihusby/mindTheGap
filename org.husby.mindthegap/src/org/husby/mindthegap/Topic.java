package org.husby.mindthegap;

public class Topic {
	  private String summary = "";
	  private String description = "";

	  public Topic(String summary) {
	    this.summary = summary;
	  }

	  public Topic(String summary, String description) {
	    this.summary = summary;
	    this.description = description;

	  }

	  public String getSummary() {
	    return summary;
	  }

	  public void setSummary(String summary) {
	    this.summary = summary;
	  }

	  public String getDescription() {
	    return description;
	  }

	  public void setDescription(String description) {
	    this.description = description;
	  }

	}
