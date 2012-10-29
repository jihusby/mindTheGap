package org.husby.mindthegap;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.model.WorkbenchAdapter;

public class AdapterFactory implements IAdapterFactory {

	private IWorkbenchAdapter groupAdapter = new IWorkbenchAdapter() {
		
		@Override
		public Object getParent(Object o) {
			return ((TopicType)o).getParent();
		}
		
		@Override
		public String getLabel(Object o) {
			return ((TopicType)o).getName();
		}
		
		@Override
		public ImageDescriptor getImageDescriptor(Object object) {
			return null;
		}
		
		@Override
		public Object[] getChildren(Object o) {
			return ((TopicType)o).getEntries();
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
				adaptableObject instanceof TopicType){
			return groupAdapter;
		}
		
		if(adapterType == IWorkbenchAdapter.class && 
				adaptableObject instanceof TopicEntry){
			return entryAdapter;
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return null;
	}

}
