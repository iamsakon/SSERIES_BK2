
/**
 *
 */
package com.sky.biz.sseries.usm.dto;
import java.util.Calendar;

import com.sky.biz.sseries.dto.AbstractDTO; 
public class RolePrivilegeDTO extends AbstractDTO {
	private Long id;
	
	public Calendar effectiveStart;
	
	public String deleteFlag;
	
	public String activeFlag;
	
	public Calendar effectiveEnd;
	
	public RoleDTO role;
	
	public PrivilegeDTO privilege;
	public Calendar getEffectiveStart() {
		return this.effectiveStart;
	}
	public void setEffectiveStart(Calendar effectiveStart) { 
		this.effectiveStart = effectiveStart;
	}
	
	public String getDeleteFlag() {
		return this.deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) { 
		this.deleteFlag = deleteFlag;
	}
	
	public String getActiveFlag() {
		return this.activeFlag;
	}
	public void setActiveFlag(String activeFlag) { 
		this.activeFlag = activeFlag;
	}
	
	public Calendar getEffectiveEnd() {
		return this.effectiveEnd;
	}
	public void setEffectiveEnd(Calendar effectiveEnd) { 
		this.effectiveEnd = effectiveEnd;
	}
	public RoleDTO getRole() {
		return this.role;
	}
	public void setRole(RoleDTO role) { 
		this.role = role;
	}
	
	public PrivilegeDTO getPrivilege() {
		return this.privilege;
	}
	public void setPrivilege(PrivilegeDTO privilege) { 
		this.privilege = privilege;
	}
}
