package com.threeguys.events.api.models;

import java.util.List;

public class SearchResult<T> {
	
	private List<T> resultData ;	
	private int totalCount =0;
	
	public List<T> getResultData() {
		return resultData;
	}
	public void setResultData(List<T> resultData) {
		this.resultData = resultData;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
