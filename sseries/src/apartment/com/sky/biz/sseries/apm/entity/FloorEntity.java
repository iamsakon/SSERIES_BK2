/**
 *
 */
package com.sky.biz.sseries.apm.entity;

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
@Table(name = "apm_floor")
@SequenceGenerator(name = "seq_apm_floor", sequenceName = "seq_apm_floor")
@Entity
public class FloorEntity extends AbstractEntity {
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Id 
	@Column(name = "id") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne 
	@JoinColumn(name="building_id")
	private BuildingEntity building;
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
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) { 
		this.id = id;
	}
	public BuildingEntity getBuilding() {
		return this.building;
	}
	public void setBuilding(BuildingEntity building) { 
		this.building = building;
	}
}
