package com.threeguys.kcase.db.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class CaseNotes {
	
	@Id
	private int notesID;
	
	private String notes;
	
	private String creator;
	
	private Date creationDate;
	
	private String  viewMode;

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getViewMode() {
		return viewMode;
	}

	public void setViewMode(String viewMode) {
		this.viewMode = viewMode;
	}

}
