
/**
 *
 */
package com.sky.biz.sseries.usm.dto;
import com.sky.biz.sseries.dto.AbstractDTO;
import java.util.Date;
public class UserAccountDTO extends AbstractDTO {
	
	
	public String username;
	
	public String password;
	
	public Boolean enabled;
	
	public Date validStart;
	
	public Date validEnd;
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) { 
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) { 
		this.password = password;
	}
	
	public Boolean getEnabled() {
		return this.enabled;
	}
	public void setEnabled(Boolean enabled) { 
		this.enabled = enabled;
	}
	public Date getValidStart() {
		return validStart;
	}
	public void setValidStart(Date validStart) {
		this.validStart = validStart;
	}
	public Date getValidEnd() {
		return validEnd;
	}
	public void setValidEnd(Date validEnd) {
		this.validEnd = validEnd;
	}

}
