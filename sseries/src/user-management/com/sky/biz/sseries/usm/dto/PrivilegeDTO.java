
/**
 *
 */
package com.sky.biz.sseries.usm.dto;
import java.util.Calendar;

import com.sky.biz.sseries.dto.AbstractDTO; 
public class PrivilegeDTO extends AbstractDTO {
	private Long id;
	
	public String code;
	
	public String activeFlag;
	
	public String description;
	
	public String name;
	
	public String deleteFlag;
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) { 
		this.code = code;
	}
	
	public String getActiveFlag() {
		return this.activeFlag;
	}
	public void setActiveFlag(String activeFlag) { 
		this.activeFlag = activeFlag;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) { 
		this.description = description;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	
	public String getDeleteFlag() {
		return this.deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) { 
		this.deleteFlag = deleteFlag;
	}
}
