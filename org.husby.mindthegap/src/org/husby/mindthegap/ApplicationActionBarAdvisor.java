package org.husby.mindthegap;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.husby.mindthegap.actions.AddTopicAction;
import org.husby.mindthegap.actions.GapDetailAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	
	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private AddTopicAction addTopicAction;
	private GapDetailAction gapDetailAction;
	
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	exitAction = ActionFactory.QUIT.create(window);
    	register(exitAction);
    	
    	aboutAction = ActionFactory.ABOUT.create(window);
    	register(aboutAction);
    	
    	addTopicAction = new AddTopicAction(window);
    	register(addTopicAction);
    	
    	gapDetailAction = new GapDetailAction(window);
    	register(gapDetailAction);
    	
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager mindTheGapMenu = new MenuManager("&Mind The Gap", "mindthegap");
    	mindTheGapMenu.add(addTopicAction);
    	mindTheGapMenu.add(gapDetailAction);
    	mindTheGapMenu.add(exitAction);
    	MenuManager helpMenu = new MenuManager("&Help", "help");
    	helpMenu.add(aboutAction);
    	menuBar.add(mindTheGapMenu);
    	menuBar.add(helpMenu);
    	
    }
    
}
