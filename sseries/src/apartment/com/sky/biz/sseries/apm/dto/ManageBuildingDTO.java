package com.sky.biz.sseries.apm.dto;

public class ManageBuildingDTO {

	private String buildingCode;
	
	private String buildingName;
	
	private String buildingDescription;
	
	private int floorAmount;
	
	private int roomPerFloorAmount;
	
	private RoomTypeDTO roomType;

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingDescription() {
		return buildingDescription;
	}

	public void setBuildingDescription(String buildingDescription) {
		this.buildingDescription = buildingDescription;
	}

	public int getFloorAmount() {
		return floorAmount;
	}

	public void setFloorAmount(int floorAmount) {
		this.floorAmount = floorAmount;
	}

	public RoomTypeDTO getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypeDTO roomType) {
		this.roomType = roomType;
	}

	public int getRoomPerFloorAmount() {
		return roomPerFloorAmount;
	}

	public void setRoomPerFloorAmount(int roomPerFloorAmount) {
		this.roomPerFloorAmount = roomPerFloorAmount;
	}
	
	
}
