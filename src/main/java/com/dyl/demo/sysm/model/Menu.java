package com.dyl.demo.sysm.model;
// default package

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menu", catalog = "rgboa_db")
public class Menu implements java.io.Serializable {

	// Fields

	private String uuid;
	private Menu menu;
	private String text;
	private String view;
	private String contr;
	private Set<Menu> menus = new HashSet<Menu>(0);

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(String uuid) {
		this.uuid = uuid;
	}

	/** full constructor */
	public Menu(String uuid, Menu menu, String text, String view, String contr,
			Set<Menu> menus) {
		this.uuid = uuid;
		this.menu = menu;
		this.text = text;
		this.view = view;
		this.contr = contr;
		this.menus = menus;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 32)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid")
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Column(name = "text", length = 45)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "view", length = 45)
	public String getView() {
		return this.view;
	}

	public void setView(String view) {
		this.view = view;
	}

	@Column(name = "contr", length = 45)
	public String getContr() {
		return this.contr;
	}

	public void setContr(String contr) {
		this.contr = contr;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

}