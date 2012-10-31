package org.husby.mindthegap;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;

public class AdapterFactory implements IAdapterFactory {

	private IWorkbenchAdapter todoAdapter = new IWorkbenchAdapter() {
		
		@Override
		public Object getParent(Object o) {
			return ((TopicsGroup)o).getParent();
		}
		
		@Override
		public String getLabel(Object o) {
			TopicsGroup group = ((TopicsGroup)o);
			return group.getName();
		}
		
		@Override
		public ImageDescriptor getImageDescriptor(Object object) {
			return null;
		}
		
		@Override
		public Object[] getChildren(Object o) {
			return ((TopicsGroup)o).getEntries();
		}
	};
	
	private IWorkbenchAdapter entryAdapter = new IWorkbenchAdapter() {
		
		@Override
		public Object getParent(Object o) {
			return ((TopicEntry)o).getParent();
		}
		
		@Override
		public String getLabel(Object o) {
			TopicEntry entry = ((TopicEntry) o).getParent(); 
			return entry.getName();
		}
		
		@Override
		public ImageDescriptor getImageDescriptor(Object object) {
			return null;
		}
		
		@Override
		public Object[] getChildren(Object o) {
			return new Object[0];
		}
	};
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == IWorkbenchAdapter.class && 
				adaptableObject instanceof TopicsGroup){
			return todoAdapter;
		}
		
		if(adapterType == IWorkbenchAdapter.class && 
				adaptableObject instanceof TopicEntry){
			return entryAdapter;
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] {IWorkbenchAdapter.class};
	}

}
