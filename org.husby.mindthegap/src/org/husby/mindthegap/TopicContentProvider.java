package org.husby.mindthegap;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.husby.mindthegap.model.Category;

public class TopicContentProvider implements ITreeContentProvider {

  private TopicMockModel model;

  @Override
  public void dispose() {
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    this.model = (TopicMockModel) newInput;
  }

  @Override
  public Object[] getElements(Object inputElement) {
    return model.getCategories().toArray();
  }

  @Override
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof Category) {
      Category category = (Category) parentElement;
      return category.getTopics().toArray();
    }
    return null;
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof Category) {
      return true;
    }
    return false;
  }
  
} 
