
/**
 *
 */
package com.sky.biz.sseries.usm.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import com.sky.biz.sseries.entity.AbstractEntity; 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "usm_user_account")
@SequenceGenerator(name = "seq_usm_user_account", sequenceName = "seq_usm_user_account")
@Entity
public class UserAccountEntity extends AbstractEntity {

	@Id 
 @Column(name = "id") 
 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "enabled")
	private boolean enabled;
	@Column(name = "valid_start")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validStart;
	@Column(name = "valid_end")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validEnd;
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) { 
		this.id = id;
	}
	
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
	
	public boolean getEnabled() {
		return this.enabled;
	}
	public void setEnabled(boolean enabled) { 
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
