package com.threeguys.events.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.threeguys.events.api.models.SearchCriteria;
import com.threeguys.events.api.models.SearchResult;
import com.threeguys.events.db.models.EventDao;
import com.threeguys.events.delegators.EventServices;

@RestController
public class EventsController {
	
	@Autowired
	protected  EventServices services;
	
	private static final Logger logger = LoggerFactory.getLogger(EventsController.class);

	
	 @RequestMapping("/event/create")
	 public void createEvents(@RequestBody EventDao eventDetail )
	 {  
		 logger.info("Enter createEvents");
		 
		 services.createEvent(eventDetail);
		 
		 logger.info("Exit createEvents");
	 }	 

	 @RequestMapping("/event/update")
	 public void updateEvents(@RequestBody EventDao eventDetail)
	 {  
		 logger.info("Enter updateEvents");
		 
		 services.updateEvent(eventDetail);		
		 
		 logger.info("Exit updateEvents");
	 }	 
	 
	 @RequestMapping(value = "/event/{event-id}/delete", method = RequestMethod.GET)
	 public void deleteEvent(@PathVariable(value="event-id") String eventID)
	 {  		 
		 logger.info("Enter deleteEvent");
		 
		 services.deleteEvent(eventID);		  
		 
		 logger.info("exit deleteEvent");
	 }
	 	 
	 @RequestMapping("/event/user/{user-id}")
	 public EventDao eventMonitoring(@PathVariable(value="user-id")  String email)
	 {  		   	       
		 logger.info("Enter eventMonitoring");
		 
		 return null;		 
		 
	 }	 
	 
	 @RequestMapping(value = "/event/{event-id}", method = RequestMethod.GET)
	 public EventDao fetchEvent(@PathVariable(value="event-id") String eventID)
	 {  
		 logger.info("Enter fetchEvent");
		 return services.fetchEventID(eventID);		  
	 }
	 
	 
	 @RequestMapping(value = "/event/search", method = RequestMethod.POST)
	 public SearchResult<EventDao> searchEvent(@RequestBody SearchCriteria searchCriteria )
	 {  
		 logger.info("Enter searchEvent");
		 return services.searchEvent(searchCriteria);		  
	 }	
	 
	 
	 @RequestMapping(value = "/event/{event-id}/accept", method = RequestMethod.GET)
	 public boolean acceptEvent(@PathVariable(value="event-id") String eventID)
	 {  
		 logger.info("Enter acceptEvent");
		 return services.acceptRejectEvent(eventID , 1);		  
	 }	
	 	 
	 @RequestMapping(value = "/event/{event-id}/reject", method = RequestMethod.GET)
	 public boolean rejectEvent(@PathVariable(value="event-id") String eventID)
	 {  
		 logger.info("Enter rejectEvent");
		 return services.acceptRejectEvent(eventID , 2);	  
	 }	
	 	
}
