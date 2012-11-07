package org.husby.mindthegap.views;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.husby.mindthegap.GapSummaryContentProvider;
import org.husby.mindthegap.model.Category;
import org.husby.mindthegap.model.Gap;
import org.husby.mindthegap.model.Topic;

public class GapSummaryView extends ViewPart {

	public static final String ID = "org.husby.mindthegap.views.gapsummary";
	private ISelectionListener listener;
	String input = "";
	TableViewer viewer;
	private Topic currentTopic;
	private Category currentCategory;

	public GapSummaryView() {
		listener = new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part,
					ISelection incoming) {
				System.out.println("GapSummaryView.selectionChanged invoked");
				IStructuredSelection selection;
				if (incoming instanceof IStructuredSelection) {
					selection = (IStructuredSelection) incoming;
					if (selection.getFirstElement() instanceof Topic) {
						currentTopic = ((Topic) selection.getFirstElement());
						input = currentTopic.getSummary();
						viewer.setInput(new GapSummaryContentProvider().getGaps(currentTopic));
					} else if (selection.getFirstElement() instanceof Category) {
						currentCategory = ((Category) selection.getFirstElement());
						input = currentCategory.getName();
						viewer.setInput(new GapSummaryContentProvider().getGaps(currentCategory));
					}
					
					viewer.refresh();
				}
			}
		};
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);
		createViewer(parent);
		getSite().getPage().addSelectionListener(listener);
	}
	
	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(listener);
	}

	private void createViewer(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		createColumns(parent, viewer);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Get the content for the viewer, setInput will call getElements in the
		// contentProvider
		// Make the selection available to other views
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setInput(new GapSummaryContentProvider().getGaps(currentTopic));
		getSite().setSelectionProvider(viewer);
		// Set the sorter for the table

		// Layout the viewer
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		viewer.getControl().setLayoutData(gridData);
	}

	private void createColumns(final Composite parent, final TableViewer viewer) {
		String[] titles = { "Emne", "Konsulent", "Nåværende", "Ønsket", "Gap",
				"Kurs" };
		int[] bounds = { 120, 120, 70, 70, 70, 70 };

		TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Gap g = (Gap) element;
				return ((Topic)g.getTopic()).getSummary();
			}
		});

		col = createTableViewerColumn(titles[1], bounds[1], 1);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Gap g = (Gap) element;
				return g.getUser().getName();
			}
		});

		col = createTableViewerColumn(titles[2], bounds[2], 2);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Gap g = (Gap) element;
				return ((Integer) g.getCurrent()).toString();
			}
		});

		col = createTableViewerColumn(titles[3], bounds[3], 3);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Gap g = (Gap) element;
				return ((Integer) g.getWanted()).toString();
			}
		});

		col = createTableViewerColumn(titles[4], bounds[4], 4);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Gap g = (Gap) element;
				return ((Integer) g.getGapResult()).toString();
			}
		});

		col = createTableViewerColumn(titles[5], bounds[5], 5);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (((Gap) element).isTrainingRequested()) {
					return "Kurs";
				} else {
					return "";
				}
			}
		});

	}

	private TableViewerColumn createTableViewerColumn(String title, int bound,
			final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	public TableViewer getViewer() {
		return viewer;
	}

	@Override
	public void setFocus() {

	}

}
