package com.threeguys.kcase.db.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="case")
public class Case{

	@Id
	private String caseID;
		
	private String caseDescription;
	
	private String caseType;
	
	private String caseStatus;
	
	private String caseOwnerGroup ;
	
	private String creator;
	
	private Date creationDate;
	
	private String closedBy;

	private List<CaseNotes> caseNotes ;
	
	//private CaseNotes[] caseNotes ;
	
	
	public String getCaseID() {
		return caseID;
	}

	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}

	public String getCaseDescription() {
		return caseDescription;
	}

	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public String getCaseOwnerGroup() {
		return caseOwnerGroup;
	}

	public void setCaseOwnerGroup(String caseOwnerGroup) {
		this.caseOwnerGroup = caseOwnerGroup;
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

	public List <CaseNotes> getCaseNotes() {
		return caseNotes;
	}
	
	public void  setCaseNotes(List <CaseNotes> caseNotes ) {
		this.caseNotes = caseNotes;
	}

	public void addCaseNotes(CaseNotes caseNotesDao) {
		if (caseNotes == null){
			caseNotes = new ArrayList<CaseNotes>();
		}
		caseNotes.add(caseNotesDao);		
	}
	
	public String getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}
	
}
