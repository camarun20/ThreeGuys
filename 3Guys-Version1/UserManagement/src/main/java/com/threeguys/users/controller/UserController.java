package com.threeguys.users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.threeguys.users.delegators.UserServices;
import com.threeguys.users.models.User;
import com.threeguys.users.models.UserGroup;

@RestController
public class UserController {
	
	@Autowired
	UserServices services;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	 @RequestMapping("/user/create")
	 public void createUser(@RequestBody User userDetails )
	 {  
		 logger.info("Enter UserDetails");
		 
		services.createUser(userDetails);
		 
		 logger.info("Exit UserDetails");
	 }	 

	 @RequestMapping("/user/update")
	 public void updateUser(@RequestBody User userDetails)
	 {  
		 logger.info("Enter updateUser");
		 
		 services.updateUser(userDetails);		
		 
		 logger.info("Exit updateUser");
	 }	 
	 
	 @RequestMapping(value = "/user/{user-id}/delete", method = RequestMethod.GET)
	 public void deleteUser(@PathVariable(value="user-id") String eventID)
	 {  		 
		 logger.info("Enter deleteUser");
		 
		 services.deleteUser(eventID);		  
		 
		 logger.info("exit deleteUser");
	 }
	 	 
	   

}
