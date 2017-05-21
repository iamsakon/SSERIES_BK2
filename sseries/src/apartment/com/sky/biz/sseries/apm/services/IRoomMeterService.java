package com.sky.biz.sseries.apm.services;
import com.sky.biz.sseries.apm.dto.RoomMeterDTO;
import com.sky.biz.sseries.apm.entity.RoomMeterEntity;
import com.sky.biz.sseries.services.ISSeriesServices;

import java.util.List;
@SuppressWarnings("rawtypes")
public interface IRoomMeterService extends ISSeriesServices {

	public RoomMeterDTO saveNew(RoomMeterDTO dto) throws Exception;
	public RoomMeterDTO update(RoomMeterDTO dto) throws Exception;
	public void delete(RoomMeterDTO dto) throws Exception;
	public List<RoomMeterDTO> loadActiveRoomMeter();
	public static RoomMeterDTO buildRoomMeterDTO(RoomMeterEntity entity) {return null;}
	public static List<RoomMeterDTO> buildRoomMeterDTO(List<RoomMeterEntity> entities){return null;}
	public List<RoomMeterEntity> buildRoomMeterEntity(List<RoomMeterDTO> dtoList);
	public RoomMeterEntity buildRoomMeterEntity(RoomMeterDTO dto);
	}
