
/**
 *
 */
package com.sky.biz.sseries.usm.dto;
import java.util.Calendar;

import com.sky.biz.sseries.dto.AbstractDTO; 
public class UserAccountRoleDTO extends AbstractDTO {
	private Long id;
	
	public Calendar effectiveEnd;
	
	public String deleteFlag;
	
	public Calendar effectiveStart;
	
	public String activeFlag;
	
	public UserAccountDTO userAccount;
	
	public RoleDTO role;
	public Calendar getEffectiveEnd() {
		return this.effectiveEnd;
	}
	public void setEffectiveEnd(Calendar effectiveEnd) { 
		this.effectiveEnd = effectiveEnd;
	}
	
	public String getDeleteFlag() {
		return this.deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) { 
		this.deleteFlag = deleteFlag;
	}
	
	public Calendar getEffectiveStart() {
		return this.effectiveStart;
	}
	public void setEffectiveStart(Calendar effectiveStart) { 
		this.effectiveStart = effectiveStart;
	}
	
	public String getActiveFlag() {
		return this.activeFlag;
	}
	public void setActiveFlag(String activeFlag) { 
		this.activeFlag = activeFlag;
	}
	public UserAccountDTO getUserAccount() {
		return this.userAccount;
	}
	public void setUserAccount(UserAccountDTO userAccount) { 
		this.userAccount = userAccount;
	}
	
	public RoleDTO getRole() {
		return this.role;
	}
	public void setRole(RoleDTO role) { 
		this.role = role;
	}
}
