package com.eventmate.ChatModule.domain;

import java.util.List;

public class ConversationDo {

	private UserDo currentUser;
	private List<UserDo> otherUsers;
	private String message;
	public UserDo getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(UserDo currentUser) {
		this.currentUser = currentUser;
	}
	public List<UserDo> getOtherUsers() {
		return otherUsers;
	}
	public void setOtherUsers(List<UserDo> otherUsers) {
		this.otherUsers = otherUsers;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
