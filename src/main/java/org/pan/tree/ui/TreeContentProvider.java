package org.pan.tree.ui;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.pan.tree.domain.ITreeNode;

public class TreeContentProvider implements ITreeContentProvider {

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof List) {
			List input = (List) inputElement;
			return input.toArray();
		}
		return new Object[0];
	}

	public Object[] getChildren(Object parentElement) {
		ITreeNode node = (ITreeNode) parentElement;
		List list = node.getChildren();
		if (list == null) {
			return new Object[0];
		}
		return list.toArray();
	}

	public boolean hasChildren(Object element) {
		ITreeNode node = (ITreeNode) element;
		List list = node.getChildren();
		return !(list == null || list.isEmpty());
	}

	// ������������������Ҫ���
	public Object getParent(Object element) {
		return null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

}
