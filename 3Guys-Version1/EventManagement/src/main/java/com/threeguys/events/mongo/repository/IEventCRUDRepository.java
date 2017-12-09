package com.threeguys.events.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.threeguys.events.db.models.EventDao;

@Transactional
public interface IEventCRUDRepository extends MongoRepository<EventDao, String> {

    @Query("{ 'eventStatus' : ?0 }")
	public EventDao findByUserID(@Param("eventStatus") String  eventStatus);	  
	
	public EventDao findByeventID(String  eventID);
	  
}
