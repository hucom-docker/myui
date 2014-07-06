package org.pan.tree.domain;

import java.util.ArrayList;
import java.util.List;

public class City implements ITreeNode {

	private String name;
	private boolean checked;
	private List<City> children = new ArrayList<City>();

	public City() {
	}

	public City(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String setName(String name) {
		return this.name = name;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<City> getChildren() {
		return this.children;
	}

	public void setChildren(List list) {
		this.children.clear();
		this.children.addAll(children);
	}

	@Override
	public String toString() {
		return "City [name=" + name + "]";
	}

}
