package com.sky.biz.sseries.apm.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sky.biz.sseries.apm.dto.BuildingDTO;
import com.sky.biz.sseries.apm.dto.FloorDTO;
import com.sky.biz.sseries.apm.services.IFloorService;
import com.sky.biz.sseries.apm.services.AbstractFloorService;
import com.sky.biz.sseries.services.ISSeriesServices;
@SuppressWarnings("rawtypes")
@Service ("floorService")
public class FloorServiceImpl extends AbstractFloorService implements IFloorService,ISSeriesServices {

	@Transactional
	public List<FloorDTO> generateFloor(BuildingDTO buildingDto,int floorAmount) throws Exception{
		List<FloorDTO> floorDtoList=new ArrayList<FloorDTO>();
		for(int i = 0; i< floorAmount; i++){
			FloorDTO floorDto = new FloorDTO();
			floorDto.setBuilding(buildingDto);
			floorDto.setCode("F" + (i+1));
			floorDto.setName("F" + (i+1));
			floorDto.setDescription("");
			floorDto.setIsActive(true);
			floorDto = saveNew(floorDto);
			floorDtoList.add(floorDto);
		}
		return floorDtoList;
	}
}
