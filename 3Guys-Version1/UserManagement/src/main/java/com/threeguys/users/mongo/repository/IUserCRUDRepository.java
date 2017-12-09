package com.threeguys.users.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.threeguys.events.models.Event;
import com.threeguys.users.models.User;

@Transactional
public interface IUserCRUDRepository extends MongoRepository<User, String> {
	
	
	//public Event findByeventID(String  eventID);
	  
}
