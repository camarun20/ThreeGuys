package com.threeguys.events.db.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="event")
public class EventDao{

	@Id
	private String eventID;
	
	private String eventName;
	
	private String eventDescription;
	
	private Date eventDateTime;
	
	private String eventStatus;
	
	private EventTypeDao eventType;
	
	private List<String> eventParticipants;	
		
	private List<String> eventOrganisor;

    private String eventCreator; 
	
	private Date eventCreationDate;
	
	private int accepted;
	
	private int declined;
	
	private int noResponse;
		
	
	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public Date getEventDateTime() {
		return eventDateTime;
	}

	public void setEventDateTime(Date eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(int eventAccepted) {
		this.accepted = eventAccepted;
	}

	public int getDeclined() {
		return declined;
	}

	public void setDeclined(int eventDeclined) {
		this.declined = eventDeclined;
	}

	public int getNoResponse() {
		return noResponse;
	}

	public void setNoResponse(int eventNoResponse) {
		this.noResponse = eventNoResponse;
	}		
	
	public EventTypeDao getEventType() {
		return eventType;
	}

	public void setEventType(EventTypeDao eventType) {
		this.eventType = eventType;
	}
	
	public String getEventCreator() {
		return eventCreator;
	}

	public void setEventCreator(String eventCreator) {
		this.eventCreator = eventCreator;
	}

	public Date getEventCreationDate() {
		return eventCreationDate;
	}

	public void setEventCreationDate(Date eventCreationDate) {
		this.eventCreationDate = eventCreationDate;
	}
	
	public List<String> getEventParticipants() {
		return eventParticipants;
	}

	public void setEventParticipants(List<String> eventParticipants) {
		this.eventParticipants = eventParticipants;
	}

	public List<String> getEventOrganisor() {
		return eventOrganisor;
	}

	public void setOrganisor(List<String> organisor) {
		this.eventOrganisor = organisor;
	}


}
