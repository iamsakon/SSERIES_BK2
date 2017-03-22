package com.sky.biz.sseries.util;

import java.util.List;


public class PageDTOUtil<T> {

	int totalPage;
	
	long totalElements;
	
	List<T> contents;
	
	public PageDTOUtil(int totalPage,long totalElements,List<T> contents){
		this.totalPage = totalPage;
		this.totalElements = totalElements;
		this.contents = contents;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public List<T> getContents() {
		return contents;
	}

	public void setContents(List<T> contents) {
		this.contents = contents;
	}
}
