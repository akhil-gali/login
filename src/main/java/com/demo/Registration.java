package com.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration {

	@Id
	@GeneratedValue
	private int Registration_id;

	private String username = "";

	private String password = "";
	private String Firstname;
	private String Lastname;
	private String Designation;
	private String Contactnumber;
	private String EmailId;
	private String Dob;
	private String Gender;
	private String role;
	private String Supportlevel;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int remedy_number;

	private String remedyselect = "";
	private String statement = "";
	private int user_id = 0;
	private String mobilenumber = "";
	private String seat_no = "";
	private String pc_number = "";
	private String ip_address = "";
	private String status="";

	public int getRegistration_id() {
		return Registration_id;
	}

	public void setRegistration_id(int registration_id) {
		Registration_id = registration_id;
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

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

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

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getContactnumber() {
		return Contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		Contactnumber = contactnumber;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSupportlevel() {
		return Supportlevel;
	}

	public void setSupportlevel(String supportlevel) {
		Supportlevel = supportlevel;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
