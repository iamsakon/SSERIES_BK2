
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
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sky.biz.sseries.entity.AbstractEntity; 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "usm_role_privilege")
@SequenceGenerator(name = "seq_usm_role_privilege", sequenceName = "seq_usm_role_privilege")
@Entity
public class RolePrivilegeEntity extends AbstractEntity {
	@Id 
	@Column(name = "id") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "effective_start")@Temporal(TemporalType.TIMESTAMP)
	private Calendar effectiveStart;
	@Column(name = "effective_end")@Temporal(TemporalType.TIMESTAMP)
	private Calendar effectiveEnd;
	@Column(name = "delete_flag")
	private String deleteFlag;
	@Column(name = "active_flag")
	private String activeFlag;
	@ManyToOne 
	@JoinColumn(name="role_id")
	private RoleEntity role;
	@ManyToOne 
	@JoinColumn(name="privilege_id")
	private PrivilegeEntity privilege;
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) { 
		this.id = id;
	}
	
	public Calendar getEffectiveStart() {
		return this.effectiveStart;
	}
	public void setEffectiveStart(Calendar effectiveStart) { 
		this.effectiveStart = effectiveStart;
	}
	
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
	
	public String getActiveFlag() {
		return this.activeFlag;
	}
	public void setActiveFlag(String activeFlag) { 
		this.activeFlag = activeFlag;
	}
	public RoleEntity getRole() {
		return this.role;
	}
	public void setRole(RoleEntity role) { 
		this.role = role;
	}
	
	public PrivilegeEntity getPrivilege() {
		return this.privilege;
	}
	public void setPrivilege(PrivilegeEntity privilege) { 
		this.privilege = privilege;
	}
}
