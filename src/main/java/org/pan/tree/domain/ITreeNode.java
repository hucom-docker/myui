package org.pan.tree.domain;

import java.util.List;

public interface ITreeNode {

	public String getName();
	
	public String setName(String name);
	
	public boolean getChecked();
	
	public void setChecked(boolean checked);
	
	public List getChildren();
	
	public void setChildren(List list);
	
}
