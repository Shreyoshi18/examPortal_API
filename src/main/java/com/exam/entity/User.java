package com.exam.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
@Entity
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userName;
	private String password;
	private String fName;
	private String lName;
	private String email;
	@Column(length = 10)
	private String pNum;
	private boolean enabled = true;
	private String profile;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	private Set<UserRoles> userRoles;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long id, String userName, String password, String fName, String lName, String email, String pNum,
			boolean enabled, String profile, Set<UserRoles> userRoles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pNum = pNum;
		this.enabled = enabled;
		this.profile = profile;
		this.userRoles = userRoles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getpNum() {
		return pNum;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Authority> s = new HashSet();
		for(UserRoles u:userRoles)
		{
			s.add(new Authority(u.getRole().getRoleName()));		}
		return s;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
