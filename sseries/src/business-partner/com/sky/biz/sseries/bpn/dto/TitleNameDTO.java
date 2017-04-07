/**
 *
 */
package com.sky.biz.sseries.bpn.dto;
import java.util.Calendar;

import com.sky.biz.sseries.dto.AbstractDTO; 
@SuppressWarnings("serial")
public class TitleNameDTO extends AbstractDTO {

	
	public Boolean isActive;
	
	public String name;
	
	public String abbrname;
	
	public String description;


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
	
	public String getAbbrname() {
		return this.abbrname;
	}
	public void setAbbrname(String abbrname) { 
		this.abbrname = abbrname;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) { 
		this.description = description;
	}

}
