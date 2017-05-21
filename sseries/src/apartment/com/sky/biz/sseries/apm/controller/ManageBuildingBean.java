package com.sky.biz.sseries.apm.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.sky.biz.sseries.apm.dto.ManageBuildingDTO;
import com.sky.biz.sseries.apm.dto.RoomTypeDTO;
import com.sky.biz.sseries.apm.services.IManageBuildingService;
import com.sky.biz.sseries.apm.services.IRoomTypeService;
import com.sky.biz.sseries.util.JsfUtil;

import java.util.List;
@ManagedBean(name = "manageBuildingBean")
@SessionScoped
public class ManageBuildingBean {

	private List<RoomTypeDTO> roomTypeList;
	
	private ManageBuildingDTO manageBuilding;
	
	@ManagedProperty(value="#{manageBuildingService}")
	private IManageBuildingService manageBuildingService;
	
	@ManagedProperty(value="#{roomTypeService}")
	private IRoomTypeService roomTypeService;
	
	@PostConstruct
	public void init(){
		manageBuilding = new ManageBuildingDTO();
		manageBuilding.setFloorAmount(1);
		manageBuilding.setRoomPerFloorAmount(1);
		//Load Room Type List
		this.roomTypeList = this.roomTypeService.loadActiveRoomType();
		if((roomTypeList == null || roomTypeList.size() <= 0))
			JsfUtil.addErrorMessage("กรุณากำหนดข้อมูลประเภทห้อง");
	}
	
	/**
	 * Generate Building,Floor and Room
	 */
	public void generateBuilding(ActionEvent actionEvent){
		try{
			boolean generateResult = manageBuildingService.generateBuilding(manageBuilding);
			
			if(generateResult){
				
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	
	}

	public List<RoomTypeDTO> getRoomTypeList() {
		return roomTypeList;
	}

	public void setRoomTypeList(List<RoomTypeDTO> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}

	public ManageBuildingDTO getManageBuilding() {
		return manageBuilding;
	}

	public void setManageBuilding(ManageBuildingDTO manageBuilding) {
		this.manageBuilding = manageBuilding;
	}

	public IRoomTypeService getRoomTypeService() {
		return roomTypeService;
	}

	public void setRoomTypeService(IRoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}

	public IManageBuildingService getManageBuildingService() {
		return manageBuildingService;
	}

	public void setManageBuildingService(IManageBuildingService manageBuildingService) {
		this.manageBuildingService = manageBuildingService;
	}
	
}
