package com.threeguys.common;

public class CommonUtils {
	
	
	public static final String  AND =    "&" ;
	public static final String  EQUALS =  "=";
	
	
	public static boolean isStringEmpty(String strValue){
		
		if(strValue == null || strValue.trim().length() == 0 ){
			return Boolean.TRUE ;
		}
		return Boolean.FALSE ;
	}


}
