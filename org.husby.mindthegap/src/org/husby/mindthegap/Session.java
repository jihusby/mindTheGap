package org.husby.mindthegap;

public class Session {
	
	private TopicsGroup rootGroup;
	private String name;
	private String server;

	public Session() {
		name = "The root";
		server = "The server";
		rootGroup = new TopicsGroup(null, "root");
	}
	
	public String getName() {
		return name;
	}

	public String getServer() {
		return server;
	}
	
	public TopicsGroup getRoot() {
		return rootGroup;
	}

}
