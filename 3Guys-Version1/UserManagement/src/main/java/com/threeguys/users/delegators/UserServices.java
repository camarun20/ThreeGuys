package com.threeguys.users.delegators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeguys.users.delegators.repository.UserRepository;
import com.threeguys.users.models.User;




@Service
public class UserServices {

    
    @Autowired
   	public UserRepository userRepository ;
	
	public void createUser(User userDetails)
	{
	 	userRepository.createUser(userDetails);
	}
	
	public boolean updateUser(User User)
	{
	 	userRepository.updateUser(User);
	 	return true ;
	}
	
	public boolean deleteUser(String  UserID)
	{
	 	userRepository.deleteUser(UserID);
	 	return true ;
	}
	
	public User fetchUser(String  UserID)
	{
		return  userRepository.fetchUser(UserID);	 	
	}
	
	
	
	
}
