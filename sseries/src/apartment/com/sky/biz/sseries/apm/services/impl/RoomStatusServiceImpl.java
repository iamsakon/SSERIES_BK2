package com.sky.biz.sseries.apm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sky.biz.sseries.apm.dto.RoomStatusDTO;
import com.sky.biz.sseries.apm.entity.RoomStatusEntity;
import com.sky.biz.sseries.apm.services.AbstractRoomStatusService;
import com.sky.biz.sseries.apm.services.IRoomStatusService;
import com.sky.biz.sseries.services.ISSeriesServices;
@SuppressWarnings("rawtypes")
@Service ("roomStatusService")
public class RoomStatusServiceImpl extends AbstractRoomStatusService implements IRoomStatusService, ISSeriesServices {

	public RoomStatusDTO getDefaultRoomStatus(){
		RoomStatusDTO defaultRoomStatus = null;
		List<RoomStatusEntity> defaultRoomStatusList = roomStatusRepository.findByCompCodeAndIsActiveAndMarkDeleteAndDefaultStatus("FCNF",true,false,true);
		if(defaultRoomStatusList != null && defaultRoomStatusList.size() > 0){
			defaultRoomStatus = AbstractRoomStatusService.buildRoomStatusDTO(defaultRoomStatusList.get(0));
		}else{
			defaultRoomStatusList = roomStatusRepository.findByCompCodeAndIsActiveAndMarkDelete("FCNF",true,false);
			if(defaultRoomStatusList != null && defaultRoomStatusList.size() > 0){
				defaultRoomStatus = AbstractRoomStatusService.buildRoomStatusDTO(defaultRoomStatusList.get(0));
			}
		}
		return defaultRoomStatus;
	}
}
