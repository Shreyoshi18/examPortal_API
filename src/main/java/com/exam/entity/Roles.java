package com.exam.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Roles {

	@Id
	private long rId;
	private String roleName;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="role")
	private Set<UserRoles> userRoles;
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Roles(long rId, String roleName, Set<UserRoles> userRoles) {
		super();
		this.rId = rId;
		this.roleName = roleName;
		this.userRoles = userRoles;
	}
	public long getrId() {
		return rId;
	}
	public void setrId(long rId) {
		this.rId = rId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}
	
	
	
}
