package com.threeguys.events.db.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EventTypeDao {
	
	@Id
	private String eventTypeID;
	
	private String eventType;

	public String getEventTypeID() {
		return eventTypeID;
	}

	public void setEventTypeID(String eventTypeID) {
		this.eventTypeID = eventTypeID;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	

}
