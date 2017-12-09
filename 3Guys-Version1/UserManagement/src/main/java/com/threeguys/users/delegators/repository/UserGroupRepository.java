package com.threeguys.users.delegators.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeguys.users.models.UserGroup;
import com.threeguys.users.mongo.repository.IUserGroupCRUDRepository;

@Service
public class UserGroupRepository implements IUserGroupRepository {

	@Autowired
	IUserGroupCRUDRepository userRepository;

	@Override
	public String createUserGroup(UserGroup userDetails) {
		UserGroup userGroup = userRepository.save(userDetails);
		if(userGroup.getUserGroupId() != null)
		{
			return userGroup.getUserGroupId();
		}
		return null;
	}

	@Override
	public boolean updateUserGroup(UserGroup userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUsersToUserGroup(UserGroup userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserGroup[] findUserGroupOfUser(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserGroup[] findUsersBelongingToUserGroup(String userGroupId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
