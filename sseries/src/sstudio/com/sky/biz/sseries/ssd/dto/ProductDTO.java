/**
 *
 */
package com.sky.biz.sseries.ssd.dto;
import java.util.Calendar;

import com.sky.biz.sseries.dto.AbstractDTO; 
@SuppressWarnings("serial")
public class ProductDTO extends AbstractDTO {

	
	public String code;
	
	public String description;
	
	public Boolean isActive;
	
	public String name;
	
	public Double sortKey;


	public String getCode() {
		return this.code;
	}
	public void setCode(String code) { 
		this.code = code;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) { 
		this.description = description;
	}
	
	public Boolean getIsActive() {
		return this.isActive;
	}
	public void setIsActive(Boolean isActive) { 
		this.isActive = isActive;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	
	public Double getSortKey() {
		return this.sortKey;
	}
	public void setSortKey(Double sortKey) { 
		this.sortKey = sortKey;
	}

}
