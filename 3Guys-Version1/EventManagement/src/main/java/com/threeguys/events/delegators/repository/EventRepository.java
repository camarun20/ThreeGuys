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
import org.springframework.stereotype.Service;

import com.threeguys.common.CommonUtils;
import com.threeguys.events.api.models.SearchCriteria;
import com.threeguys.events.api.models.SearchResult;
import com.threeguys.events.db.models.EventDao;
import com.threeguys.events.db.models.EventTypeDao;
import com.threeguys.events.mongo.repository.IEventCRUDRepository;

@Service
public class EventRepository implements IEventRepository {

	@Autowired
	protected IEventCRUDRepository eventRepository;
	
    @Autowired
    protected MongoTemplate mongoTemplate;

	
	@Override
	public String createEvent(EventDao eventDetails) {
		EventDao resEvents =eventRepository.save(eventDetails);
		if(resEvents !=null){
			return  resEvents.getEventID() ;
		}
		return null;
	}
	
	@Override
	public boolean updateEvent(EventDao eventDetails) {
		eventRepository.save(eventDetails);
		return Boolean.TRUE;
	}
	
	@Override
	public boolean deleteEvent(String  eventID) {		
		eventRepository.delete(eventID);		
		return  Boolean.TRUE;
	}

	@Override
	public EventDao fetchEventByID(String eventID) {
		return 	eventRepository.findOne(eventID);		
	}
	
	
	@Override
	public SearchResult searchEvent(SearchCriteria searchCriteria) {
			
        Query query = new Query( prepareGlobalSearch(searchCriteria) );
        
        int total = mongoTemplate.find(query, EventDao.class).size();
        
        if ( ! CommonUtils.isStringEmpty(searchCriteria.getSort())){        	
            query.with(new Sort(Direction.DESC, searchCriteria.getSort()));
        }        
          	
        query.skip(searchCriteria.getStartIndex());
        query.limit(searchCriteria.getMaxResults());
       
        System.out.println(" Uqrey "+ query.toString());
        SearchResult<EventDao> result = new SearchResult<EventDao>();
        
        result.setResultData(mongoTemplate.find(query, EventDao.class));
        result.setTotalCount(total);
        
		return  result ;

	}
	
	
	public Criteria prepareGlobalSearch(SearchCriteria searchCriteria){
		
		if(searchCriteria== null){
			return null ;
		}
		
		Criteria mainCriteria = new Criteria();
		String strFilter = searchCriteria.getFilter();
		
		if (! CommonUtils.isStringEmpty(strFilter))
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
