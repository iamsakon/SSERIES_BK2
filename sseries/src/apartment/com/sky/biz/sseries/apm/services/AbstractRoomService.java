package com.sky.biz.sseries.apm.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.apm.dto.*;
import com.sky.biz.sseries.apm.entity.*;
import com.sky.biz.sseries.apm.specification.*;

import java.util.*;
public class AbstractRoomService extends ApmService {

	public RoomDTO loadById(Long id){
		return buildRoomDTO(roomRepository.findOne(id));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public PageDTOUtil<RoomDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<RoomDTO> dtoList = new ArrayList<RoomDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<RoomEntity> entityPage =  roomRepository.findAll(RoomSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractRoomService.buildRoomDTO(entityPage.getContent());
		PageDTOUtil<RoomDTO> pageDTO = new PageDTOUtil<RoomDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	public PageDTOUtil<RoomDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}
	public RoomDTO saveNew(RoomDTO dto) throws Exception{
		RoomEntity entity = this.buildRoomEntity(dto);
		entity.setCreatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCreatedDate(Calendar.getInstance());
		entity.setVersion(0);
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity =  roomRepository.save(entity);
		return buildRoomDTO(entity);
	}
	public RoomDTO update(RoomDTO dto) throws Exception{
		RoomEntity entity = this.buildRoomEntity(dto);
		entity.setId(dto.getId());
		entity.setUpdatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity.setUpdatedDate(Calendar.getInstance());
		entity =  roomRepository.save(entity);
		return buildRoomDTO(entity);
	}
	public void delete(RoomDTO dto) throws Exception{
		RoomEntity entity = roomRepository.findByCompCodeAndIdAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),dto.getId(),false);
		entity.setMarkDelete(true);
		roomRepository.save(entity);
		dto = buildRoomDTO(entity);
	}
	public List<RoomDTO> loadActiveRoom(){
		List <RoomDTO>resultList = new ArrayList<RoomDTO>();
		List<RoomEntity> listEntity =  roomRepository.findByCompCodeAndIsActiveAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),true,false);
		resultList = buildRoomDTO(listEntity);
		return resultList;
	}
	public static RoomDTO buildRoomDTO(RoomEntity entity){
		if(entity == null)
			return null;
		RoomDTO dto = null;
		dto = new RoomDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setFloor(AbstractFloorService.buildFloorDTO(entity.getFloor()));
		dto.setRoomType(AbstractRoomTypeService.buildRoomTypeDTO(entity.getRoomType()));
		dto.setRoomStatus(AbstractRoomStatusService.buildRoomStatusDTO(entity.getRoomStatus()));
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;
	}
	public static List<RoomDTO> buildRoomDTO(List<RoomEntity> entities){
		List<RoomDTO> listReturn = new ArrayList<RoomDTO>();
		Iterator<RoomEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoomDTO((RoomEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<RoomEntity> buildRoomEntity(List<RoomDTO> dtoList){ 
		List<RoomEntity> listReturn = new ArrayList<RoomEntity>();
		Iterator<RoomDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoomEntity((RoomDTO)iterator.next()));
		}
		return listReturn;
	}
	public RoomEntity buildRoomEntity(RoomDTO dto) {
		RoomEntity entity = null;
		if(dto.getId() == null)
			entity = (RoomEntity)DtoEntityUtil.initEntity(new RoomEntity());
		else
			entity = roomRepository.findOne(dto.getId());
		entity.setIsActive(dto.getIsActive());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		if(dto.getFloor() != null && dto.getFloor().getId() !=null)
		 entity.setFloor(floorRepository.findOne(dto.getFloor().getId()));
		if(dto.getRoomType() != null && dto.getRoomType().getId() !=null)
		 entity.setRoomType(roomTypeRepository.findOne(dto.getRoomType().getId()));
		if(dto.getRoomStatus() != null && dto.getRoomStatus().getId() != null)
			entity.setRoomStatus(roomStatusRepository.findOne(dto.getRoomStatus().getId()));
		return entity;
	}
}
