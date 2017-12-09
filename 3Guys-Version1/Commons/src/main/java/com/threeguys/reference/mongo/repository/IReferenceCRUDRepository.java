package com.threeguys.reference.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import com.threeguys.reference.db.model.ReferenceType;

public interface IReferenceCRUDRepository extends MongoRepository<ReferenceType, String> {

	@Query("{ 'name' : ?0 }")
	public ReferenceType findByname(@Param("name") String  refName);	  
}
