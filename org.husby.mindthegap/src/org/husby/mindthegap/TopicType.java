package org.husby.mindthegap;


public class TopicType {

	private Topic[] topics;

	public void initTopics(){
		topics = new Topic[5]; 
		topics[0]= new Topic("Java");
		topics[1]= new Topic("C++");
		topics[2]= new Topic("Fortran");
		topics[3]= new Topic("Pascal");
		topics[4]= new Topic("Delphi");
	}

	public Object getParent() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getName() {
		return "Languages";
	}
	public Topic[] getEntries() {
		return topics;
	}
	
}
