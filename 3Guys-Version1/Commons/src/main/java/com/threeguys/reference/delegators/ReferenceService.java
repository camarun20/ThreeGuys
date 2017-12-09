package com.threeguys.reference.delegators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.threeguys.reference.db.model.ReferenceType;
import com.threeguys.reference.mongo.repository.IReferenceCRUDRepository;

@Service
public class ReferenceService {
	
	private static final Logger logger = LoggerFactory.getLogger(ReferenceService.class);
	
	@Autowired
	protected IReferenceCRUDRepository repo;
	
	 public void createReference(ReferenceType eventDetail )
	 {  
		 logger.info("Enter createReference");
		 
		 repo.save(eventDetail);
		 
		 logger.info("Exit createReference");
	 }
	 
	 public ReferenceType fetchReference( String refName  )
	 {  
		 logger.info("Enter fetchReference");
		 
		 ReferenceType referType = repo.findByname(refName);
		 
		 logger.info("Exit fetchReference");
		 
		 return  referType;
	 }
	 
	 

}
