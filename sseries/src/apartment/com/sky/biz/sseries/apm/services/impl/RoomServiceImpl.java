package com.sky.biz.sseries.apm.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sky.biz.sseries.apm.services.IRoomService;
import com.sky.biz.sseries.apm.services.IRoomStatusService;
import com.sky.biz.sseries.apm.dto.FloorDTO;
import com.sky.biz.sseries.apm.dto.RoomDTO;
import com.sky.biz.sseries.apm.dto.RoomStatusDTO;
import com.sky.biz.sseries.apm.dto.RoomTypeDTO;
import com.sky.biz.sseries.apm.services.AbstractRoomService;
import com.sky.biz.sseries.services.ISSeriesServices;
@SuppressWarnings("rawtypes")
@Service ("roomService")
public class RoomServiceImpl extends AbstractRoomService implements IRoomService, ISSeriesServices {

	@Autowired
	private IRoomStatusService roomStatusService;
	
	@Transactional
	public List<RoomDTO> generateRoom(FloorDTO floorDto,RoomTypeDTO roomTypeDto,int amount,int startFrom) throws Exception{
		List<RoomDTO> roomDtoList=new ArrayList<RoomDTO>();
		RoomStatusDTO defaultRoomStatus = roomStatusService.getDefaultRoomStatus();
		for(int i=0; i<amount; i++){
			RoomDTO room = new RoomDTO();
			room.setFloor(floorDto);
			room.setRoomType(roomTypeDto);
			room.setRoomStatus(defaultRoomStatus);
			room.setCode(""+ (startFrom+(i+1)));
			room.setName(""+ (startFrom+(i+1)));
			room.setDescription("");
			room.setIsActive(true);
			room = this.saveNew(room);
		}
		return roomDtoList;
	}
	@Transactional
	public boolean generateRoom(List<FloorDTO> floorDto,RoomTypeDTO roomTypeDto,int amount) throws Exception{
		boolean returnResult = false;
		for(int i=0; i<floorDto.size(); i++){
			this.generateRoom(floorDto.get(i),roomTypeDto,amount,((i+1)*100));
		}
		return returnResult;
	}
	public IRoomStatusService getRoomStatusService() {
		return roomStatusService;
	}
	public void setRoomStatusService(IRoomStatusService roomStatusService) {
		this.roomStatusService = roomStatusService;
	}
}
