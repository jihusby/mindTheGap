package org.husby.mindthegap;

import java.util.ArrayList;
import java.util.List;

public class TopicMockModel  {

	  public List<Category> getCategories() {
	    List<Category> categories = new ArrayList<Category>();
	    Category category = new Category();
	    category.setName("Utviklingsplatformer");
	    categories.add(category);
	    Topic todo = new Topic("Java");
	    category.getTopics().add(todo);
	    todo = new Topic(".NET");
	    category.getTopics().add(todo);
	    todo = new Topic("Objective-C");
	    category.getTopics().add(todo);
	    
	    category = new Category();
	    category.setName("Metodikker");
	    categories.add(category);
	    todo = new Topic("Scrum");
	    category.getTopics().add(todo);
	    
	    return categories;
	  }

	} 