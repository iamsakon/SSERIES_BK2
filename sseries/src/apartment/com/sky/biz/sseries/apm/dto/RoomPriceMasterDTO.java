/**
 *
 */
package com.sky.biz.sseries.apm.dto;
import java.util.Calendar;

import com.sky.biz.sseries.dto.AbstractDTO; 
@SuppressWarnings("serial")
public class RoomPriceMasterDTO extends AbstractDTO {

	
	public Boolean isActive;
	
	public String code;
	
	public String name;
	
	public String description;

	
	public RoomTypeDTO roomType;

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

	public RoomTypeDTO getRoomType() {
		return this.roomType;
	}
	public void setRoomType(RoomTypeDTO roomType) { 
		this.roomType = roomType;
	}
}
