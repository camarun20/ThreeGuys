package com.threeguys.events.delegators.validators;

import org.springframework.core.ExceptionDepthComparator;

import com.threeguys.events.db.models.EventDao;
import com.threeguys.exception.MissingInputException;

public class EventValidator {
		
	public  boolean creatEventValidation( EventDao event){
			
	   if (event == null){
		   throw new MissingInputException("Event Details missing in the input");
	   }
	   if(isStringEmpty(event.getEventName())){
		   throw new MissingInputException("Event Name missing in the input");
	   }
	   if(isStringEmpty(event.getEventDescription())){
		   throw new MissingInputException("Event Description missing in the input");   
	   }
	   if ( event.getEventDateTime() == null){
		   throw new MissingInputException("Event Date missing in the input");
	   }
	   if ( event.getEventParticipants() == null || event.getEventParticipants().isEmpty() ){
		   throw new MissingInputException("Event Date missing in the input");
	   }
		
		return Boolean.TRUE ;
	}
	
	public  boolean updateEventValidation( EventDao event){
		
		   if (event == null){
			   throw new MissingInputException("Event Details missing in the input");
		   }
		   if(isStringEmpty(event.getEventID())){
			   throw new MissingInputException("Event ID missing in the input");
		   }
		 	
			return Boolean.TRUE ;
		}
	
	
	public boolean isStringEmpty(String strValue){
		
		if(strValue == null || strValue.trim().length() == 0 ){
			return Boolean.TRUE ;
		}
		return Boolean.FALSE ;
	}

}
