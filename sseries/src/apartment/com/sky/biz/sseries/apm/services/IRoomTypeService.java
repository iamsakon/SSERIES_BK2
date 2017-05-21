package com.sky.biz.sseries.apm.services;
import com.sky.biz.sseries.apm.dto.RoomTypeDTO;
import com.sky.biz.sseries.apm.entity.RoomTypeEntity;
import com.sky.biz.sseries.services.ISSeriesServices;

import java.util.List;
@SuppressWarnings("rawtypes")
public interface IRoomTypeService extends ISSeriesServices {

	public RoomTypeDTO saveNew(RoomTypeDTO dto) throws Exception;
	public RoomTypeDTO update(RoomTypeDTO dto) throws Exception;
	public void delete(RoomTypeDTO dto) throws Exception;
	public List<RoomTypeDTO> loadActiveRoomType();
	public static RoomTypeDTO buildRoomTypeDTO(RoomTypeEntity entity) {return null;}
	public static List<RoomTypeDTO> buildRoomTypeDTO(List<RoomTypeEntity> entities){return null;}
	public List<RoomTypeEntity> buildRoomTypeEntity(List<RoomTypeDTO> dtoList);
	public RoomTypeEntity buildRoomTypeEntity(RoomTypeDTO dto);
	}
