package com.eventmate.ChatModule.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConversationDo {

	private long id;
	private UserDo currentUser;
	private List<UserDo> otherUsers;
	private String message;
	public static Map<Long,ConversationDo> conversationMap;
	
	static{
		conversationMap = new LinkedHashMap<Long,ConversationDo>();
	}
	
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
