package com.threeguys.users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.threeguys.users.delegators.UserGroupServices;
import com.threeguys.users.models.UserGroup;


@RestController
public class UserGroupController {
	
	@Autowired
	UserGroupServices services;
	
	private static final Logger logger = LoggerFactory.getLogger(UserGroupController.class);

	
	 @RequestMapping("/UserGroup/create")
	 public void createUserGroup(@RequestBody UserGroup UserGroupDetails )
	 {  
		 logger.info("Enter UserGroupDetails");
		 
		services.createUserGroup(UserGroupDetails);
		 
		 logger.info("Exit UserGroupDetails");
	 }	 

	 @RequestMapping("/UserGroup/update")
	 public void updateUserGroup(@RequestBody UserGroup UserGroupDetails)
	 {  
		 logger.info("Enter updateUserGroup");
		 
		 services.updateUserGroup(UserGroupDetails);		
		 
		 logger.info("Exit updateUserGroup");
	 }	 
	 
	 @RequestMapping(value = "/UserGroup/{UserGroup-id}/delete", method = RequestMethod.GET)
	 public void deleteUserGroup(@PathVariable(value="UserGroup-id") String eventID)
	 {  		 
		 logger.info("Enter deleteUserGroup");
		 
		 services.deleteUserGroup(eventID);		  
		 
		 logger.info("exit deleteUserGroup");
	 }

}
