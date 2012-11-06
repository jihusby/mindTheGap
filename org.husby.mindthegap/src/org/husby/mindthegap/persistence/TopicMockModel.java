package org.husby.mindthegap.persistence;

import java.util.ArrayList;
import java.util.List;

import org.husby.mindthegap.model.Category;
import org.husby.mindthegap.model.Topic;

public class TopicMockModel  {

	  public List<Category> getCategories() {
	    List<Category> categories = new ArrayList<Category>();
	    
	    Category category = new Category();
	    category.setName("Utviklingsplattformer");
	    categories.add(category);
	    Topic topic = new Topic("Java");
	    category.getTopics().add(topic);
	    
	    topic = new Topic(".NET");
	    category.getTopics().add(topic);
	    
	    topic = new Topic("Objective-C");
	    category.getTopics().add(topic);
	    
	    category = new Category();
	    category.setName("Metodikker");
	    categories.add(category);
	    
	    topic = new Topic("Scrum");
	    category.getTopics().add(topic);
	    
	    return categories;
	  }

	} 