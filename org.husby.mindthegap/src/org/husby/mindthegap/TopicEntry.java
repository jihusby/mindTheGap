package org.husby.mindthegap;

public class TopicEntry {
	private String name;
	private TopicsGroup group;
	private TopicEntry parent;
	
	public TopicEntry(TopicEntry parent, String name){
		this.name = name;
		this.parent = parent;
		this.group = new TopicsGroup(null, name);
	}

	public TopicEntry(TopicsGroup group, String name){
		this.name = name;
		this.group = group;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public TopicEntry getParent() {
		return parent;
	}

	public TopicsGroup getGroup() {
		return group;
	}
	
}
