package org.husby.mindthegap;


public class TopicsGroup {

	private Object[] entries;
	private String name;
	TopicsGroup parent;
	TopicsListener[] listeners;
	private int counter = 0;

	public TopicsGroup(TopicsGroup parent, String name) {
		this.parent = parent;
		this.name = name;
		entries = new Object[10];
		listeners = new TopicsListener[10];
	}

	public TopicsGroup getParent() {
		return parent;
	}
	public String getName() {
		return name;
	}
	public Object[] getEntries() {
		return entries;
	}
	public void rename(String name){
		this.name = name;
	}
	public void addEntry(Object entry){
		if(entry instanceof TopicsGroup){
			entries[counter++] = (TopicsGroup)entry;
		}else if(entry instanceof TopicEntry){
			entries[counter++] = (TopicEntry)entry;
		}
	}

	public void removeEntry(Object entry){
		// Bullshit, implemented later :-)
		entries[entries.length] = entry;
	}
	
	public void addTopicListener(TopicsListener topicsListener) {
		listeners[0] = topicsListener;
		
	}
	
	public void removeTopicListener() {
		// Implement later
	}

	public void addTopicListener(ITopicsListener iTopicsListener) {
		// TODO Auto-generated method stub
		
	}
	
}
