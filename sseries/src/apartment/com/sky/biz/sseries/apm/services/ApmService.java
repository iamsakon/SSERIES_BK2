package com.sky.biz.sseries.apm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sky.biz.sseries.apm.repositories.*;

@Service
public class ApmService {

	@Autowired
	protected BuildingRepository buildingRepository;
	@Autowired
	protected FloorRepository floorRepository;
	@Autowired
	protected RoomRepository roomRepository;
	@Autowired
	protected RoomStatusRepository roomStatusRepository;
	@Autowired
	protected RoomTypeRepository roomTypeRepository;
	@Autowired
	protected RoomPriceMasterRepository roomPriceMasterRepository;
	@Autowired
	protected RoomMeterRepository roomMeterRepository;
	@Autowired
	protected MeterTypeRepository meterTypeRepository;
}
