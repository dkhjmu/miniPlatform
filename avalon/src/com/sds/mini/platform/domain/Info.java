package com.sds.mini.platform.domain;

import com.sds.mini.platform.minion.domain.GroupInfo;

public class Info {
	String name;
	String path;
	GroupInfo parent;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public GroupInfo getParent() {
		return parent;
	}
	public void setParent(GroupInfo group) {
		this.parent = group;
	}
}
