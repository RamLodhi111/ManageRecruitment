package com.app.models;

import java.util.List;

public class Reports {
	private String label;
	private String type;
	private String styleClass;
	private boolean expanded;
	private Data data;
	private List<Reports> children;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStyleClass() {
		return styleClass;
	}
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public List<Reports> getChildren() {
		return children;
	}
	public void setChildren(List<Reports> children) {
		this.children = children;
	}

}
