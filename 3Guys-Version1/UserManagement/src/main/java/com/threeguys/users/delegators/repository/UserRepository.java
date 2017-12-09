package com.threeguys.users.delegators.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeguys.users.models.User;
import com.threeguys.users.mongo.repository.IUserCRUDRepository;

@Service
public class UserRepository implements IUserRepository {

	@Autowired
	IUserCRUDRepository userRepository;

	@Override
	public String createUser(User userDetails) {
		User createUser =userRepository.save(userDetails);
		if(createUser !=null){
			return  createUser.getUserId();
		}
		return null;
	}
	
	@Override
	public boolean updateUser(User eventDetails) {
		//eventRepository.save(eventDetails);
		return Boolean.TRUE;
	}
	
	@Override
	public boolean deleteUser(String  eventID) {		
		//eventRepository.delete(eventID);		
		return  Boolean.TRUE;
	}

	@Override
	public User fetchUser(String eventID) {
		//return 	eventRepository.findByeventID(eventID);
		return null;
	}

	
	
	
	
}
