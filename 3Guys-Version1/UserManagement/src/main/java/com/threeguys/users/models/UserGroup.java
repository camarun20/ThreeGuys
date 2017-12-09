package com.threeguys.users.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserGroup {
	
	@Id
	private String userGroupId;
	
	private User[] userDetails;
	
	private boolean active;

	public String getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public User[] getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User[] userIds) {
		this.userDetails = userIds;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	


}
