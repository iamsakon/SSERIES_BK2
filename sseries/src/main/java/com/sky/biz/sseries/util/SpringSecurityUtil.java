package com.sky.biz.sseries.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SpringSecurityUtil {

	public static String getUsername(){
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails.getUsername();
	}
	
	public static Long getCurrentUserAccountId(){
		getUsername();
		return -88888L;
	}
	
	public static String getCurrentCompCode(){
		return "SKY-SOFT";
	}
}
