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
@Table(name = "apm_room")
@SequenceGenerator(name = "seq_apm_room", sequenceName = "seq_apm_room")
@Entity
public class RoomEntity extends AbstractEntity {
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
	@JoinColumn(name="floor_id")
	private FloorEntity floor;
	@ManyToOne 
	@JoinColumn(name="room_type_id")
	private RoomTypeEntity roomType;
	@ManyToOne
	@JoinColumn(name="room_status_id")
	private RoomStatusEntity roomStatus;
	
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
	public FloorEntity getFloor() {
		return this.floor;
	}
	public void setFloor(FloorEntity floor) { 
		this.floor = floor;
	}
	
	public RoomTypeEntity getRoomType() {
		return this.roomType;
	}
	public void setRoomType(RoomTypeEntity roomType) { 
		this.roomType = roomType;
	}
	public RoomStatusEntity getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(RoomStatusEntity roomStatus) {
		this.roomStatus = roomStatus;
	}
}
