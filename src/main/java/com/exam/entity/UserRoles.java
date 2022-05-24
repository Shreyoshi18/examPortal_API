package com.exam.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long urId;
	@ManyToOne(cascade =CascadeType.ALL)
	private User user;
	@ManyToOne
	private Roles role;
	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRoles(long urId, User user, Roles role) {
		super();
		this.urId = urId;
		this.user = user;
		this.role = role;
	}
	public long getUrId() {
		return urId;
	}
	public void setUrId(long urId) {
		this.urId = urId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	
}
