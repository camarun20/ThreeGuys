package com.threeguys.users.delegators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeguys.users.delegators.repository.UserGroupRepository;
import com.threeguys.users.models.User;
import com.threeguys.users.models.UserGroup;




@Service
public class UserGroupServices {

  
    
    @Autowired
   	public UserGroupRepository userGroupRepository ;
	
	public String createUserGroup(UserGroup userGroupDetails)
	{
		return userGroupRepository.createUserGroup(userGroupDetails);
	}
	
	public boolean updateUserGroup(UserGroup userGroupDetails)
	{
		return userGroupRepository.updateUserGroup(userGroupDetails);
	}
	
	public boolean deleteUserGroup(String  userGroupDetails)
	{
		//userGroupRepository.(userGroupDetails);
	 	return true ;
	}
	
	
	
	
}
