/**
 *
 */
package com.sky.biz.sseries.apm.dto;
import java.util.Calendar;

import com.sky.biz.sseries.dto.AbstractDTO; 
@SuppressWarnings("serial")
public class FloorDTO extends AbstractDTO {

	
	public Boolean isActive;
	
	public String code;
	
	public String name;
	
	public String description;

	
	public BuildingDTO building;

	public Boolean getIsActive() {
		return this.isActive;
	}
	public void setIsActive(Boolean isActive) { 
		this.isActive = isActive;
	}
	
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) { 
		this.code = code;
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

	public BuildingDTO getBuilding() {
		return this.building;
	}
	public void setBuilding(BuildingDTO building) { 
		this.building = building;
	}
}
