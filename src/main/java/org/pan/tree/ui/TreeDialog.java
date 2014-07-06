package org.pan.tree.ui;

import java.util.Arrays;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.pan.tree.domain.City;
import org.pan.tree.domain.ITreeNode;

public class TreeDialog {

	protected Shell shell;
	private CheckboxTreeViewer treeViewer;
	private Tree tree;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TreeDialog window = new TreeDialog();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout());

		SashForm sashForm = new SashForm(shell, SWT.NONE);

		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new FillLayout());

		treeViewer = new CheckboxTreeViewer(composite, SWT.BORDER|SWT.CHECK);
		treeViewer.setLabelProvider(new TreeLabelProvider());
		treeViewer.setContentProvider(new TreeContentProvider());
		tree = treeViewer.getTree();
		
		initTree();
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);

		sashForm.setWeights(new int[] { 2, 3 });
		
		treeViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent arg0) {
				CheckboxTreeViewer checkboxTreeViewer = (CheckboxTreeViewer)arg0.getSource();
				boolean checked = arg0.getChecked();
				checkboxTreeViewer.setSubtreeChecked(arg0.getElement(), checked);
				
				TreeItem ti = (TreeItem)checkboxTreeViewer.testFindItem(arg0.getElement());
				tree.setSelection(ti);
				TreeItem parent = ti.getParentItem();
				if(parent == null){
					return;
				}
				TreeItem[] items = parent.getItems();
				int checkItems = 0;
				for (TreeItem treeItem : items) {
					if(treeItem.getChecked() && !treeItem.getGrayed()){
						checkItems = checkItems + 1;
					}
				}
				ti.setChecked(checked);
				if(checkItems == 0){
					parent.setChecked(false);
					return;
				}
				if(checkItems == items.length){
					parent.setGrayed(false);
					parent.setChecked(true);
					return;
				}
				if(checkItems != items.length){
					parent.setChecked(true);
					parent.setGrayed(true);
					return;
				}
			}
		});
	}

	public void initTree() {
		City city = new City("大中国");

		City city2 = new City("湖北");
		city.getChildren().add(city2);

		City city3 = new City("咸宁");
		city2.getChildren().add(city3);

		City city4 = new City("武汉");
		city2.getChildren().add(city4);

		City city5 = new City("湖南");
		city.getChildren().add(city5);

		treeViewer.setInput(Arrays.asList(city));

	}
}
