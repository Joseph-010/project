package com.organization.tourism.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "UserManage")
@Table(name = "user_manage")
public class UserManage {
	
	private String username;
	@Id
	private String password;
	
	public UserManage() {
		
	}

	public String getUsername() {
		return username;
	}
	
	
	public UserManage(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

}
