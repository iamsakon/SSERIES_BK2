package com.sky.biz.sseries.dto;

import java.io.Serializable;

public class MenuItemDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6795854332880665250L;

	private String name;
	
	private String outcome;

	public MenuItemDto(String name,String outcome){
		this.name = name;
		this.outcome = outcome;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
}
