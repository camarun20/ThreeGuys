package com.threeguys.reference.db.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="reference")
public class ReferenceType {
	
	private String name ;	
	private String  id ;
	private String  description ;	
	private ReferenceValue[] refValue ;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ReferenceValue[] getRefValue() {
		return refValue;
	}
	public void setRefValue(ReferenceValue[] refValue) {
		this.refValue = refValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}		
}
