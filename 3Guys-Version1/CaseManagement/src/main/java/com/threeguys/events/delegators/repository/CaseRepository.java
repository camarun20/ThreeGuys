package com.threeguys.events.delegators.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.threeguys.common.CaseCommonUtils;
import com.threeguys.events.mongo.repository.ICaseCRUDRepository;
import com.threeguys.kcase.api.models.SearchCriteria;
import com.threeguys.kcase.api.models.SearchResult;
import com.threeguys.kcase.db.models.Case;
import com.threeguys.kcase.db.models.CaseNotes;

@Service
public class CaseRepository implements ICaseRepository {

	@Autowired
	protected ICaseCRUDRepository caseRepository;
	
    @Autowired
    protected MongoTemplate mongoTemplate;

	
	@Override
	public String createCase(Case caseDetails) {
		Case resCase =caseRepository.save(caseDetails);
		if(resCase !=null){
			return  resCase.getCaseID() ;
		}
		return null;
	}
	
	@Override
	public boolean updateCase(Case caseDetails) {
		caseRepository.save(caseDetails);
		return Boolean.TRUE;
	}
	
	@Override
	public boolean deleteCase(String  caseID) {		
		caseRepository.delete(caseID);		
		return  Boolean.TRUE;
	}

	@Override
	public Case fetchCaseByID(String caseID) {
		return 	caseRepository.findOne(caseID);		
	}
	
	@Override
	public boolean addNotesToCase(String caseID , CaseNotes caseNotes) {
		
		
//	 	Case kcase = caseRepository.findOne(caseID);
//		  
//	  if(kcase !=null){
//		  kcase.getCaseNotes().
//	  }

		mongoTemplate.updateFirst(  Query.query( Criteria.where("id").is(caseID)),   new Update().push("caseNotes", caseNotes), CaseNotes.class);
		
		return Boolean.TRUE;
	}
		
	@Override
	public SearchResult searchCase(SearchCriteria searchCriteria) {
			
        Query query = new Query( prepareGlobalSearch(searchCriteria) );
        
        int total = mongoTemplate.find(query, Case.class).size();
        
        if ( ! CaseCommonUtils.isStringEmpty(searchCriteria.getSort())){        	
            query.with(new Sort(Direction.DESC, searchCriteria.getSort()));
        }        
          	
        query.skip(searchCriteria.getStartIndex());
        query.limit(searchCriteria.getMaxResults());
       
        System.out.println(" Uqrey "+ query.toString());
        SearchResult<Case> result = new SearchResult<Case>();
        
        result.setResultData(mongoTemplate.find(query, Case.class));
        result.setTotalCount(total);
        
		return  result ;

	}
	
	
	public Criteria prepareGlobalSearch(SearchCriteria searchCriteria){
		
		if(searchCriteria== null){
			return null ;
		}
		
		Criteria mainCriteria = new Criteria();
		String strFilter = searchCriteria.getFilter();
		
		if (! CaseCommonUtils.isStringEmpty(strFilter))
		{
			List<Criteria> andCriteriaList = new ArrayList<Criteria>();
			List<Criteria> orCriteriaList = new ArrayList<Criteria>();		
			
			String[] parameter = strFilter.split("&"); 
			
			for (int i = 0; i < parameter.length; i++) {
				  
				 String[] value = parameter[i].split("=");
				 if(value !=null && value.length>1){					 
					 String[] values = value[1].split(","); 
					 andCriteriaList.add( new Criteria().where(value[0]).in( Arrays.asList(values)));
				  }				 
			 }	
			 
			 if(andCriteriaList.size() >0){
				 
				 Criteria criteria = new Criteria();				 
				 criteria.andOperator(andCriteriaList.toArray(new Criteria[andCriteriaList.size()]));
				 
				 System.out.println("After  "+ criteria );				 
				 return criteria ;				 
			 }			 
			 return null ;			 
		}
		
		return mainCriteria;
	}
	
}
