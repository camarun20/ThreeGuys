package com.threeguys.events.delegators.repository;

import com.threeguys.kcase.api.models.SearchCriteria;
import com.threeguys.kcase.api.models.SearchResult;
import com.threeguys.kcase.db.models.Case;
import com.threeguys.kcase.db.models.CaseNotes;


public interface ICaseRepository {

	public  String createCase(Case eventDetails);
	public  boolean updateCase(Case eventDetails);
	public  boolean deleteCase(String  eventID);	
	public Case fetchCaseByID(String caseID) ;
	
	public SearchResult searchCase(SearchCriteria searchCriteria);
	
	public boolean  addNotesToCase(String caseID , CaseNotes caseNotes) ;
}
