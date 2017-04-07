/**
 *
 */
package com.sky.biz.sseries.bpn.dto;
import java.util.Calendar;

import com.sky.biz.sseries.dto.AbstractDTO; 
@SuppressWarnings("serial")
public class PartnerGroupDTO extends AbstractDTO {

	
	public Boolean isActive;
	
	public Boolean defaultGroup;
	
	public String name;
	
	public String description;


	public Boolean getIsActive() {
		return this.isActive;
	}
	public void setIsActive(Boolean isActive) { 
		this.isActive = isActive;
	}
	
	public Boolean getDefaultGroup() {
		return this.defaultGroup;
	}
	public void setDefaultGroup(Boolean defaultGroup) { 
		this.defaultGroup = defaultGroup;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) { 
		this.description = description;
	}

}
