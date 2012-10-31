package org.husby.mindthegap;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class TopicLabelProvider extends LabelProvider {
  
	@Override
  public String getText(Object element) {
    if (element instanceof Category) {
      Category category = (Category) element;
      return category.getName();
    }
    return ((Topic) element).getSummary();
  }

  @Override
  public Image getImage(Object element) {
    if (element instanceof Category) {
      return PlatformUI.getWorkbench().getSharedImages()
          .getImage(ISharedImages.IMG_OBJ_FOLDER);
    }
    return PlatformUI.getWorkbench().getSharedImages()
    .getImage(ISharedImages.IMG_OBJ_FILE);
  }

} 