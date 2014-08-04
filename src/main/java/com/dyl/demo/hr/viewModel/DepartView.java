package com.dyl.demo.hr.viewModel;

import java.util.List;


public class DepartView {
	
	//private String id;
	private String uuid;
	private String pid;
	private String text;
	private boolean leaf;
	private String note;
	private List<DepartView> children;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<DepartView> getChildren() {
		return children;
	}
	public void setChildren(List<DepartView> children) {
		this.children = children;
	}
	/*public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}*/
	
	
	
}
