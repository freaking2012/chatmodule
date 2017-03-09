package com.eventmate.ChatModule.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String password;
	private String emailId;
	private String phoneNumber;
	private int isLoggedIn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(int isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
