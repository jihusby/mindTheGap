package org.husby.mindthegap;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.husby.mindthegap.editors.GapEditor;

public class GapEditorInput implements IEditorInput {

	private String topic;

	public GapEditorInput(String topic) {
		super();
		Assert.isNotNull(topic);
		this.topic = topic;
	}
	
	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public String getName() {
		return topic;
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return null;
	}
	
	public boolean equals(Object obj) {
		if(super.equals(obj)) return true;
		if(!(obj instanceof GapEditorInput)) return false;
		GapEditor other = (GapEditor) obj;
		return topic.equals(other.topic);
	}
	
//	public int hashCode {
//		return participant.hashCode();
//	}

}
