package com.sky.biz.sseries.apm.services;

import java.util.List;

import com.sky.biz.sseries.apm.dto.BuildingDTO;
import com.sky.biz.sseries.apm.entity.BuildingEntity;
import com.sky.biz.sseries.services.ISSeriesServices;

@SuppressWarnings("rawtypes")
public interface IBuildingService extends ISSeriesServices {

	public BuildingDTO saveNew(BuildingDTO dto) throws Exception;
	public BuildingDTO update(BuildingDTO dto) throws Exception;
	public void delete(BuildingDTO dto) throws Exception;
	public List<BuildingDTO> loadActiveBuilding();
	public static BuildingDTO buildBuildingDTO(BuildingEntity entity) {return null;}
	public static List<BuildingDTO> buildBuildingDTO(List<BuildingEntity> entities){return null;}
	public List<BuildingEntity> buildBuildingEntity(List<BuildingDTO> dtoList);
	public BuildingEntity buildBuildingEntity(BuildingDTO dto);
}
