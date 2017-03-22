/**
 * 
 */
package com.sky.biz.sseries.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
/**
 * @author MrMai
 * 
 */
@MappedSuperclass
public class AbstractEntity {

	/**
	 * 
	 */
	@Column(name = "comp_code")
	private String compCode;
	
	/**
	 * Indicate date and time that this entity is created
	 */
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdDate;	
	/**
	 * Indicate who created this entity
	 */
	@Column(name = "created_by")
	private Long createdBy;
	/**
	 * 
	 */
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedDate;
	/**
	 * 
	 */
	@Column(name = "updated_by")
	private Long updatedBy;	
	/**
	 * Whether this entity is active or not
	 */
	@Column(name = "is_active",nullable = false)
	private boolean isActive;
	
	@Column(name="mark_delete",nullable = false)
	private boolean markDelete;

	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public boolean isMarkDelete() {
		return markDelete;
	}
	public void setMarkDelete(boolean markDelete) {
		this.markDelete = markDelete;
	}
	@Version
	@Column(name = "version")
	private int version;
	
	
	public Calendar getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Calendar getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
}
