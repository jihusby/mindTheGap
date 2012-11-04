package org.husby.mindthegap.editors;

import java.util.Date;

import javax.swing.event.DocumentEvent.EventType;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class GapEditor extends EditorPart {
	
	public static String ID = "org.husby.mindthegap.editors.gap";
	private Text gapdetails;
	private Text entry;
	public Object topic;
	
	public GapEditor() {
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
		setPartName(getTopic());
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		top.setLayout(layout);
		
		gapdetails = new Text(top, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		gapdetails.setLayoutData(new GridData(
				GridData.FILL, GridData.FILL, true, true));
		gapdetails.setEditable(false);
		gapdetails.setForeground(gapdetails.getDisplay().getSystemColor(SWT.COLOR_INFO_FOREGROUND));
		
		entry = new Text(top, SWT.BORDER | SWT.WRAP);
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.heightHint = entry.getLineHeight() * 4;
		entry.setLayoutData(gridData);
		
		
		entry.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				if(event.character == SWT.CR) {
					addComment(entry.getText());
					event.doit = false;
				}
			}

			private void addComment(String input) {
				System.out.println("addComments() invoked: " + input);
				entry.setText("");
				gapdetails.setText(new Date() + ":\n" + input + "\n\n" + gapdetails.getText());
			}
		});
	}
	
	private String getTopic() {
		return getEditorInput().getName();
	};
	
	@Override
	public void setFocus() {
		if(entry == null && !entry.isDisposed()) {
			entry.setFocus();
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

}
