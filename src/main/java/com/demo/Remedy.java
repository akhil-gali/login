package com.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq", initialValue = 456987, allocationSize = 147852369)
public class Remedy {
	@Id
	@GeneratedValue
	private int remedy_id;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int remedy_number;
	private String username;
	private int support_id;
	private String remedyselect = "";
	private String statement = "";
	private int user_id = 0;
	private String mobilenumber = "";
	private String seat_no = "";
	private String pc_number = "";
	private String ip_address = "";
	private String status = "";

	public String getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}

	public String getPc_number() {
		return pc_number;
	}

	public void setPc_number(String pc_number) {
		this.pc_number = pc_number;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public int getRemedy_id() {
		return remedy_id;
	}

	public void setRemedy_id(int remedy_id) {
		this.remedy_id = remedy_id;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRemedy_number() {
		return remedy_number;
	}

	public void setRemedy_number(int remedy_number) {
		this.remedy_number = remedy_number;
	}

	public String getRemedyselect() {
		return remedyselect;
	}

	public void setRemedyselect(String remedyselect) {
		this.remedyselect = remedyselect;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSupport_id() {
		return support_id;
	}

	public void setSupport_id(int support_id) {
		this.support_id = support_id;
	}

	
}
