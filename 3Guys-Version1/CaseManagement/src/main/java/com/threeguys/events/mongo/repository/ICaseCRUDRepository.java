package com.threeguys.events.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.threeguys.kcase.db.models.Case;

@Transactional
public interface ICaseCRUDRepository extends MongoRepository<Case, String> {

    @Query("{ 'eventStatus' : ?0 }")
	public Case findByUserID(@Param("eventStatus") String  eventStatus);	  
	
	public Case findBycaseID(String  caseID);

}
