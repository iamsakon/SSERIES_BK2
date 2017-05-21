/**
 *
 */
package com.sky.biz.sseries.ssd.entity;

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
@Table(name = "ssd_module")
@SequenceGenerator(name = "seq_ssd_module", sequenceName = "seq_ssd_module")
@Entity
public class ModuleEntity extends AbstractEntity {
	@Column(name = "code")
	private String code;
	@Column(name = "description")
	private String description;
	@Id 
	@Column(name = "id") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "name")
	private String name;
	@Column(name = "sort_key")
	private Double sortKey;
	@ManyToOne 
	@JoinColumn(name="product_id")
	private ProductEntity product;
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
	
	public Boolean getIsActive() {
		return this.isActive;
	}
	public void setIsActive(Boolean isActive) { 
		this.isActive = isActive;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) { 
		this.name = name;
	}
	
	public Double getSortKey() {
		return this.sortKey;
	}
	public void setSortKey(Double sortKey) { 
		this.sortKey = sortKey;
	}
	public ProductEntity getProduct() {
		return this.product;
	}
	public void setProduct(ProductEntity product) { 
		this.product = product;
	}
}
