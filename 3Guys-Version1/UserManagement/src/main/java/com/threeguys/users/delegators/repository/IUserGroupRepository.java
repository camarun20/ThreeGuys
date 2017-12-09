package com.threeguys.users.delegators.repository;

import com.threeguys.users.models.UserGroup;



public interface IUserGroupRepository {

	public  String createUserGroup(UserGroup userDetails);
	public  boolean updateUserGroup(UserGroup userDetails);
	public  boolean addUsersToUserGroup(UserGroup userDetails);
	public  UserGroup[]  findUserGroupOfUser(String  userID);
	public UserGroup[] findUsersBelongingToUserGroup(String userGroupId);
	
}
