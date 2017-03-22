package com.sky.biz.sseries.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public abstract class SpringDataUtil {
	
	public static Pageable createPageRequest() {
		return new PageRequest(0,100);
	    //return new PageRequest(1, 10, Sort.Direction.ASC, "title", "description");
	}
	
	public static Pageable createPageRequest(int start,int rowPerPage){
		return new PageRequest(start,rowPerPage);
	}
	
}
