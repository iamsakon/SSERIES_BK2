package com.sky.biz.sseries.apm.services;
import com.sky.biz.sseries.apm.dto.BuildingDTO;
import com.sky.biz.sseries.apm.dto.FloorDTO;
import com.sky.biz.sseries.apm.entity.FloorEntity;
import com.sky.biz.sseries.services.ISSeriesServices;

import java.util.List;
@SuppressWarnings("rawtypes")
public interface IFloorService extends ISSeriesServices {

	public FloorDTO saveNew(FloorDTO dto) throws Exception;
	public FloorDTO update(FloorDTO dto) throws Exception;
	public void delete(FloorDTO dto) throws Exception;
	public List<FloorDTO> loadActiveFloor();
	public static FloorDTO buildFloorDTO(FloorEntity entity) {return null;}
	public static List<FloorDTO> buildFloorDTO(List<FloorEntity> entities){return null;}
	public List<FloorEntity> buildFloorEntity(List<FloorDTO> dtoList);
	public FloorEntity buildFloorEntity(FloorDTO dto);
	public List<FloorDTO> generateFloor(BuildingDTO buildingDto,int floorAmount) throws Exception;
	
}
