package com.threeguys.events.delegators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeguys.events.api.models.SearchCriteria;
import com.threeguys.events.api.models.SearchResult;
import com.threeguys.events.controller.EventsController;
import com.threeguys.events.db.models.EventDao;
import com.threeguys.events.delegators.repository.EventRepository;
import com.threeguys.events.delegators.validators.EventValidator;


@Service
public class EventServices {

    @Autowired
	public EventRepository eventRepo ;
    
    private static final Logger logger = LoggerFactory.getLogger(EventServices.class);
	
	public void createEvent(EventDao event)
	{
		logger.info("Enter createEvents");
		
		EventValidator validator = new EventValidator();
		if(validator.creatEventValidation(event)){
			eventRepo.createEvent(event);
		}
		
		logger.info("Exit createEvents");
	}
	
	public boolean updateEvent(EventDao event)
	{
		logger.info("Enter updateEvent");
		
		EventValidator validator = new EventValidator(); 
		if(validator.updateEventValidation(event)){
			eventRepo.updateEvent(event);
		}
		
		logger.info("Exit updateEvent");
		
	 	return true ;
	}
	
	public boolean deleteEvent(String  eventID)
	{
		logger.info("Enter deleteEvent");
		
	 	eventRepo.deleteEvent(eventID);
	 	
	 	logger.info("Exit deleteEvent");	 	
	 	return true ;
	}
	
	public EventDao fetchEventID(String  eventID)
	{
		logger.info("Enter fetchEventID");
		
		EventDao event = eventRepo.fetchEventByID(eventID);
		
		logger.info("Exit fetchEventID");		
		return  event;
	}
	
	
	public SearchResult<EventDao> searchEvent(SearchCriteria searchCriteria)
	{	
		logger.info("Enter searchEvent");
		
		SearchResult<EventDao> event =  eventRepo.searchEvent(searchCriteria);
		
		logger.info("Exit searchEvent");
		return event ;
	}
	
	
	public boolean acceptRejectEvent(String eventid , int flag){
		
		logger.info("Enter searchEvent");
		
		EventDao event = eventRepo.fetchEventByID(eventid);
		
		if (flag==1){
			int count = event.getAccepted();
			event.setAccepted(++count);			
		}else if(flag==2){
			int count = event.getDeclined();
			event.setDeclined(++count);
		}
		
		eventRepo.updateEvent(event);
		
		logger.info("Exit searchEvent");
		
		return Boolean.TRUE;
	}
	
	
}
