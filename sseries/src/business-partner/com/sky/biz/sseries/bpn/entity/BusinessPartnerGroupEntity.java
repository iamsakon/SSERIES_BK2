/**
 *
 */
package com.sky.biz.sseries.bpn.entity;

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
@Table(name = "bpn_business_partner_group")
@SequenceGenerator(name = "seq_bpn_business_partner_group", sequenceName = "seq_bpn_business_partner_group")
@Entity
public class BusinessPartnerGroupEntity extends AbstractEntity {
	@Id 
	@Column(name = "id") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "default_group")
	private Boolean defaultGroup;
	@Column(name = "description")
	private String description;
	@Column(name = "name")	
	private String name;
	@Column(name = "is_active")
	private Boolean isActive;
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) { 
		this.id = id;
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
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
