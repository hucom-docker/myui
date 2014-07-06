package org.pan.tree.ui;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.pan.tree.domain.ITreeNode;

public class TreeLabelProvider extends LabelProvider implements ILabelProvider {

	public String getText(Object element) {
		ITreeNode node = (ITreeNode) element;
		return node.getName();
	}

	public Image getImage(Object element) {
		return null;
	}

}
