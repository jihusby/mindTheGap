package org.husby.mindthegap;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;

public class AddTopicDialog extends InputDialog {

	public AddTopicDialog(Shell parentShell, String dialogTitle,
			String dialogMessage, String initialValue, IInputValidator validator) {
		super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
		// TODO Auto-generated constructor stub
	}

	public AddTopicDialog(Shell parentShell) {
		super(parentShell, "Add new topic", "Add a topic to the database", "", new IInputValidator() {
			
			@Override
			public String isValid(String text) {
				if (text == null || text.length() == 0) {
		            return "Enter a name for the new topic";
		        }
				return null;
			}
		});
	}
	

}
