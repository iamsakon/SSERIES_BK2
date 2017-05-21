package com.sky.biz.sseries.apm.services;
import com.sky.biz.sseries.apm.dto.BuildingDTO;
import com.sky.biz.sseries.apm.dto.FloorDTO;
import com.sky.biz.sseries.apm.dto.RoomDTO;
import com.sky.biz.sseries.apm.dto.RoomTypeDTO;
import com.sky.biz.sseries.apm.entity.RoomEntity;
import com.sky.biz.sseries.services.ISSeriesServices;

import java.util.List;
@SuppressWarnings("rawtypes")
public interface IRoomService extends ISSeriesServices {

	public RoomDTO saveNew(RoomDTO dto) throws Exception;
	public RoomDTO update(RoomDTO dto) throws Exception;
	public void delete(RoomDTO dto) throws Exception;
	public List<RoomDTO> loadActiveRoom();
	public static RoomDTO buildRoomDTO(RoomEntity entity) {return null;}
	public static List<RoomDTO> buildRoomDTO(List<RoomEntity> entities){return null;}
	public List<RoomEntity> buildRoomEntity(List<RoomDTO> dtoList);
	public RoomEntity buildRoomEntity(RoomDTO dto);
	public List<RoomDTO> generateRoom(FloorDTO floorDto,RoomTypeDTO roomTypeDto,int amount,int startFrom) throws Exception;
	public boolean generateRoom(List<FloorDTO> floorDto,RoomTypeDTO roomTypeDto,int amount) throws Exception;
}
