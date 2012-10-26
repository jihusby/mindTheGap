package org.husby.mindthegap.analysis;

import java.util.ArrayList;

public class Topic {

	private boolean empty = true;
	private ArrayList<Detail> details = new ArrayList<Detail>();

	public void addDetail(Detail detail) {
		empty = false;
		this.details.add(detail);
	}

	public boolean isEmpty() {
		return empty ;
	}

	public ArrayList<Detail> getDetails() {
		return details;
	}

	public Object getDetailById(int id) {
		for(Detail d : details){
			if(d.getId() == id){
				return d;
			}
		}
		return null;
	}

}
