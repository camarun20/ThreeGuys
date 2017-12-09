package com.threeguys.reference.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threeguys.reference.db.model.ReferenceType;
import com.threeguys.reference.db.model.ReferenceValue;
import com.threeguys.reference.delegators.ReferenceService;

@RestController
public class ReferenceController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReferenceController.class);

	@Autowired
	protected  ReferenceService services;
	
	 @RequestMapping("/reference/create")
	 public void createReference(@RequestBody ReferenceType referenceInfo)
	 {  
		 logger.info("Enter createReference");
		 
		 services.createReference(referenceInfo);
		 
		 logger.info("Exit createReference");
	 } 
	 
	 @RequestMapping("/reference/{reference-name}")
	 public ReferenceType fetchReference(@PathVariable(value="reference-name") String refName)
	 {  
		 logger.info("Enter createReference");
		 
		 ReferenceType referenceType = services.fetchReference(refName);
		 
		 logger.info("Exit createReference");
		 return referenceType ;
	 }	 

	 
}
