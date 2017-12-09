package com.threeguys.events.delegators.repository;

import com.threeguys.events.api.models.SearchCriteria;
import com.threeguys.events.api.models.SearchResult;
import com.threeguys.events.db.models.EventDao;
import com.threeguys.events.db.models.EventTypeDao;

public interface IEventRepository {

	public  String createEvent(EventDao eventDetails);
	public  boolean updateEvent(EventDao eventDetails);
	public  boolean deleteEvent(String  eventID);
	public  EventDao  fetchEventByID(String  eventID);
	public  SearchResult<EventDao>  searchEvent(SearchCriteria searchCriteria);
	
	//public EventTypeDao fetchEventTypes();
	
}
