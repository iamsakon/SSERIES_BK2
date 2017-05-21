/**
 * 
 */
package com.sky.biz.sseries.apm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sky.biz.sseries.apm.dto.BuildingDTO;
import com.sky.biz.sseries.apm.dto.FloorDTO;
import com.sky.biz.sseries.apm.dto.ManageBuildingDTO;
import com.sky.biz.sseries.apm.services.IBuildingService;
import com.sky.biz.sseries.apm.services.IFloorService;
import com.sky.biz.sseries.apm.services.IManageBuildingService;
import com.sky.biz.sseries.apm.services.IRoomService;
import com.sky.biz.sseries.util.JsfUtil;

/**
 * @author User
 *
 */
@Service ("manageBuildingService")
public class ManageBuildingServiceImpl implements IManageBuildingService {

	@Autowired
	private IBuildingService buildingService;
	@Autowired
	private IFloorService floorService;
	@Autowired
	private IRoomService roomService;
	
	@Transactional
	public boolean generateBuilding(ManageBuildingDTO manageBuildingDto) throws Exception{
		boolean generateStatus = false;
		BuildingDTO buildingDto = this.get(manageBuildingDto);
		buildingDto = this.buildingService.saveNew(buildingDto);
		List<FloorDTO> floorDtoList = this.floorService.generateFloor(buildingDto,manageBuildingDto.getFloorAmount());
		this.roomService.generateRoom(floorDtoList,manageBuildingDto.getRoomType(),manageBuildingDto.getRoomPerFloorAmount());				
		JsfUtil.addSuccessMessage("Generate Building Success !!!!");
		return generateStatus;
	}
	
	private BuildingDTO get(ManageBuildingDTO manageBuildingDto){
		BuildingDTO buildingDto = new BuildingDTO();
		buildingDto.setCode(manageBuildingDto.getBuildingCode());
		buildingDto.setName(manageBuildingDto.getBuildingName());
		buildingDto.setDescription(manageBuildingDto.getBuildingDescription());
		buildingDto.setIsActive(true);
		return buildingDto;
	}

	public IBuildingService getBuildingService() {
		return buildingService;
	}

	public void setBuildingService(IBuildingService buildingService) {
		this.buildingService = buildingService;
	}

	public IFloorService getFloorService() {
		return floorService;
	}

	public void setFloorService(IFloorService floorService) {
		this.floorService = floorService;
	}

	public IRoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(IRoomService roomService) {
		this.roomService = roomService;
	}
	
}
