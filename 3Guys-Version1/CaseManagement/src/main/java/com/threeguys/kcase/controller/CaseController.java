package com.threeguys.kcase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.threeguys.events.delegators.CaseServices;
import com.threeguys.kcase.db.models.Case;
import com.threeguys.kcase.db.models.CaseNotes;

@RestController
public class CaseController {
	
	@Autowired
	protected CaseServices services;
	
	private static final Logger logger = LoggerFactory.getLogger(CaseController.class);
	
	 @RequestMapping("/case/create")
	 public void createCase(@RequestBody Case caseDetails )
	 {  
		 logger.info("Enter caseDetails");
		 
		services.createCase(caseDetails);
		 
		 logger.info("Exit CaseDetails");
	 }	 

	 @RequestMapping("/case/update")
	 public void updateCase(@RequestBody Case caseDetails)
	 {  
		 logger.info("Enter updateUser");
		 
		 services.updateCase(caseDetails);		
		 
		 logger.info("Exit updateUser");
	 }	 
	 
	 
	 @RequestMapping(value = "/case/{case-id}", method = RequestMethod.GET)
	 public Case fetchCase(@PathVariable(value="case-id") String caseID)
	 {  		 
		 logger.info("Enter fetchCase");
		 
		Case caseDeatils =  services.fetchCaseByID(caseID);		  
		 
		logger.info("Exit fetchCase");
		return caseDeatils ;
		 
	 }
	 
	 
	 @RequestMapping(value = "/case/{case-id}/delete", method = RequestMethod.GET)
	 public void deleteCase(@PathVariable(value="case-id") String caseID)
	 {  		 
		 logger.info("Enter deleteUser");
		 
		 services.deleteCase(caseID);		  
		 
		 logger.info("exit deleteUser");
	 }
	 
	 
	 @RequestMapping(value = "/case/{case-id}/user/{user-id}/close", method = RequestMethod.GET)
	 public void closeCase(@PathVariable(value="case-id") String caseID , @PathVariable(value="user-id") String userID )
	 {  		 
		 logger.info("Enter deleteUser");
		 
		 services.closeCase(caseID , userID);		  
		 
		 logger.info("exit deleteUser");
	 }
	 	 
	 @RequestMapping(value = "/case/{case-id}/addNotes" )
	 public void addNotesToCase(@PathVariable(value="case-id") String caseID , @RequestBody CaseNotes caseNotes )
	 {  		 
		 logger.info("Enter deleteUser");
		 
		 services.addNotesToCase(caseID , caseNotes);		  
		 
		 logger.info("exit deleteUser");
	 }
	 
	 @RequestMapping(value = "/case/{case-id}/notes/{notes-id}/delete", method = RequestMethod.GET)
	 public void deleteNotes(@PathVariable(value="case-id") String caseID , @PathVariable(value="user-id") String userID )
	 {  		 
		 logger.info("Enter deleteUser");
		 
		 //services.deleteNotes(caseID , userID);		  
		 
		 logger.info("exit deleteUser");
	 }
	 

}
