package com.sky.biz.sseries.apm.services;
import com.sky.biz.sseries.apm.dto.RoomStatusDTO;
import com.sky.biz.sseries.apm.entity.RoomStatusEntity;
import com.sky.biz.sseries.services.ISSeriesServices;

import java.util.List;
@SuppressWarnings("rawtypes")
public interface IRoomStatusService extends ISSeriesServices {

	public RoomStatusDTO saveNew(RoomStatusDTO dto) throws Exception;
	public RoomStatusDTO update(RoomStatusDTO dto) throws Exception;
	public void delete(RoomStatusDTO dto) throws Exception;
	public List<RoomStatusDTO> loadActiveRoomStatus();
	public static RoomStatusDTO buildRoomStatusDTO(RoomStatusEntity entity) {return null;}
	public static List<RoomStatusDTO> buildRoomStatusDTO(List<RoomStatusEntity> entities){return null;}
	public List<RoomStatusEntity> buildRoomStatusEntity(List<RoomStatusDTO> dtoList);
	public RoomStatusEntity buildRoomStatusEntity(RoomStatusDTO dto);
	public RoomStatusDTO getDefaultRoomStatus();
	}
