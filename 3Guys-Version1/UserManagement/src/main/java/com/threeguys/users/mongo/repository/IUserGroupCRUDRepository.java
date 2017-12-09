package com.threeguys.users.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.threeguys.events.models.Event;
import com.threeguys.users.models.UserGroup;

@Transactional
public interface IUserGroupCRUDRepository extends MongoRepository<UserGroup, String> {
	
//	@Query("select * from event ref where ref.eventID = :eventID")
//	public Event findByEventID(@Param("siteId") String  eventID);	  
	
	//public Event findByeventID(String  eventID);
	  
}
