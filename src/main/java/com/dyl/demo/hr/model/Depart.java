package com.dyl.demo.hr.model;
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

import com.dyl.demo.core.model.User;

/**
 * Depart entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "depart", catalog = "rgboa_db")
public class Depart implements java.io.Serializable {

	// Fields

	private String uuid;
	private Depart depart;
	private String departName;
	private String note;
	private Set<User> users = new HashSet<User>(0);
	private Set<Depart> departs = new HashSet<Depart>(0);

	// Constructors

	/** default constructor */
	public Depart() {
	}

	/** minimal constructor */
	public Depart(String uuid) {
		this.uuid = uuid;
	}

	/** full constructor */
	public Depart(String uuid, Depart depart, String departName, String note,
			Set<User> users, Set<Depart> departs) {
		this.uuid = uuid;
		this.depart = depart;
		this.departName = departName;
		this.note = note;
		this.users = users;
		this.departs = departs;
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
	public Depart getDepart() {
		return this.depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	@Column(name = "departName", length = 45)
	public String getDepartName() {
		return this.departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	@Column(name = "note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "depart")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "depart")
	public Set<Depart> getDeparts() {
		return this.departs;
	}

	public void setDeparts(Set<Depart> departs) {
		this.departs = departs;
	}

}