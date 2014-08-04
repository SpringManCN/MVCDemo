package com.dyl.demo.sysm.viewModel;

import java.util.List;

public class MenuView {
	
	private String uuid;
	private String pid;
	private String text;
	private boolean leaf;
	private String view;
	private String contr;
	private List<MenuView> children;
	
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
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getContr() {
		return contr;
	}
	public void setContr(String contr) {
		this.contr = contr;
	}
	public List<MenuView> getChildren() {
		return children;
	}
	public void setChildren(List<MenuView> children) {
		this.children = children;
	}
	
	

}
