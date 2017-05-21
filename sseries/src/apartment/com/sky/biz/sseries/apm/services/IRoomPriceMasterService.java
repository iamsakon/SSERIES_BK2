package com.sky.biz.sseries.apm.services;
import com.sky.biz.sseries.apm.dto.RoomPriceMasterDTO;
import com.sky.biz.sseries.apm.entity.RoomPriceMasterEntity;
import com.sky.biz.sseries.services.ISSeriesServices;

import java.util.List;
@SuppressWarnings("rawtypes")
public interface IRoomPriceMasterService extends ISSeriesServices {

	public RoomPriceMasterDTO saveNew(RoomPriceMasterDTO dto) throws Exception;
	public RoomPriceMasterDTO update(RoomPriceMasterDTO dto) throws Exception;
	public void delete(RoomPriceMasterDTO dto) throws Exception;
	public List<RoomPriceMasterDTO> loadActiveRoomPriceMaster();
	public static RoomPriceMasterDTO buildRoomPriceMasterDTO(RoomPriceMasterEntity entity) {return null;}
	public static List<RoomPriceMasterDTO> buildRoomPriceMasterDTO(List<RoomPriceMasterEntity> entities){return null;}
	public List<RoomPriceMasterEntity> buildRoomPriceMasterEntity(List<RoomPriceMasterDTO> dtoList);
	public RoomPriceMasterEntity buildRoomPriceMasterEntity(RoomPriceMasterDTO dto);
	}
