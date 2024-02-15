package com.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SupportAnalyst {
	@Id
	@GeneratedValue
	private int supportAnalyst_id=0;
	private String username="";
	private String password="";
	private String supportlevel="";

	public String getUsername() {
		return username;
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

	public int getSupportAnalyst_id() {
		return supportAnalyst_id;
	}

	public void setSupportAnalyst_id(int supportAnalyst_id) {
		this.supportAnalyst_id = supportAnalyst_id;
	}

	public String getSupportlevel() {
		return supportlevel;
	}

	public void setSupportlevel(String supportlevel) {
		this.supportlevel = supportlevel;
	}

	

	
}
