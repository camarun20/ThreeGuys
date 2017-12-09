package com.threeguys.events.delegators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threeguys.events.delegators.repository.CaseRepository;
import com.threeguys.kcase.api.models.SearchCriteria;
import com.threeguys.kcase.api.models.SearchResult;
import com.threeguys.kcase.db.models.Case;
import com.threeguys.kcase.db.models.CaseNotes;

@Service
public class CaseServices {

    @Autowired
	public CaseRepository caseRepo ;
    
    private static final Logger logger = LoggerFactory.getLogger(CaseServices.class);
	
    public String createCase(Case caseDetails){
    	
    	return caseRepo.createCase(caseDetails) ;
    }
    
    public boolean updateCase(Case caseDetails){
    	
    	return caseRepo.updateCase(caseDetails) ;
    }
    
    
    public boolean deleteCase(String caseID){
    	
    	return caseRepo.deleteCase(caseID);
    }
    
    
    
	public Case fetchCaseByID(String caseID) {
		
		return 	caseRepo.fetchCaseByID(caseID);		
	}
	
	public SearchResult searchCase(SearchCriteria searchCriteria) {
		
		return 	caseRepo.searchCase(searchCriteria);
		
	}
	
	public boolean  closeCase(String caseID , String closedBy) {
		
		Case caseInfo = fetchCaseByID(caseID) ;
		
		if(caseInfo != null){
			caseInfo.setCaseStatus("closed");
			caseInfo.setClosedBy(closedBy);
		}
		
		caseRepo.updateCase(caseInfo);
		return Boolean.TRUE;
		
	}
	
	
	public boolean addNotesToCase(String caseID , CaseNotes caseNotes){
		
		caseRepo.addNotesToCase(caseID, caseNotes);
		
		
		return Boolean.TRUE;
	}
	
	
	
	
    
}
