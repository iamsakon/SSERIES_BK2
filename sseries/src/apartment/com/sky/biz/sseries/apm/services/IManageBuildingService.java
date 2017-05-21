package com.sky.biz.sseries.apm.services;

import com.sky.biz.sseries.apm.dto.ManageBuildingDTO;

public interface IManageBuildingService {

	public boolean generateBuilding(ManageBuildingDTO manageBuildingDto) throws Exception;
}
