package com.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class logindetails {

	@Id
	@GeneratedValue
	private int logindetails_id;
	private String username="";
	private String password="";
	private String role="";

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "logindetails [id=" + getLogindetails_id() + ", username=" + username + ", password=" + password + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getLogindetails_id() {
		return logindetails_id;
	}

	public void setLogindetails_id(int logindetails_id) {
		this.logindetails_id = logindetails_id;
	}
}
