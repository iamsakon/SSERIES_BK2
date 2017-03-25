/**
 *
 */
package com.sky.biz.sseries.bpn.dto;
import java.util.Calendar;

import com.sky.biz.sseries.dto.AbstractDTO; 
@SuppressWarnings("serial")
public class BusinessPartnerGroupDTO extends AbstractDTO {
	
	public String name;
	
	public Boolean defaultGroup;
	
	public String description;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	
	public Boolean getDefaultGroup() {
		return this.defaultGroup;
	}
	public void setDefaultGroup(Boolean defaultGroup) { 
		this.defaultGroup = defaultGroup;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) { 
		this.description = description;
	}
}
