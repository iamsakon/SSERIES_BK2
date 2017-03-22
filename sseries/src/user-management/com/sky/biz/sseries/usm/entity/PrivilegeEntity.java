
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
@Table(name = "usm_privilege")
@SequenceGenerator(name = "seq_usm_privilege", sequenceName = "seq_usm_privilege")
@Entity
public class PrivilegeEntity extends AbstractEntity {
	@Column(name = "delete_flag")
	private String deleteFlag;
	@Column(name = "code")
	private String code;
	@Column(name = "description")
	private String description;
	@Id 
	@Column(name = "id") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "active_flag")
	private String activeFlag;
	public String getDeleteFlag() {
		return this.deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) { 
		this.deleteFlag = deleteFlag;
	}
	
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) { 
		this.code = code;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) { 
		this.description = description;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) { 
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	
	public String getActiveFlag() {
		return this.activeFlag;
	}
	public void setActiveFlag(String activeFlag) { 
		this.activeFlag = activeFlag;
	}
}
