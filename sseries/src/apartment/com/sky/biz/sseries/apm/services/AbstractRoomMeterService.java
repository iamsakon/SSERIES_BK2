package com.sky.biz.sseries.apm.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.apm.dto.*;
import com.sky.biz.sseries.apm.entity.*;
import com.sky.biz.sseries.apm.specification.*;

import java.util.*;
public class AbstractRoomMeterService extends ApmService {

	
	public RoomMeterDTO loadById(Long id){
		return buildRoomMeterDTO(roomMeterRepository.findOne(id));
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public PageDTOUtil<RoomMeterDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<RoomMeterDTO> dtoList = new ArrayList<RoomMeterDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<RoomMeterEntity> entityPage =  roomMeterRepository.findAll(RoomMeterSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractRoomMeterService.buildRoomMeterDTO(entityPage.getContent());
		PageDTOUtil<RoomMeterDTO> pageDTO = new PageDTOUtil<RoomMeterDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}
	
	public PageDTOUtil<RoomMeterDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}
	public RoomMeterDTO saveNew(RoomMeterDTO dto) throws Exception{
		RoomMeterEntity entity = this.buildRoomMeterEntity(dto);
		entity.setCreatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCreatedDate(Calendar.getInstance());
		entity.setVersion(0);
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity =  roomMeterRepository.save(entity);
		return buildRoomMeterDTO(entity);
	}
	public RoomMeterDTO update(RoomMeterDTO dto) throws Exception{
		RoomMeterEntity entity = this.buildRoomMeterEntity(dto);
		entity.setId(dto.getId());
		entity.setUpdatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity.setUpdatedDate(Calendar.getInstance());
		entity =  roomMeterRepository.save(entity);
		return buildRoomMeterDTO(entity);
	}
	public void delete(RoomMeterDTO dto) throws Exception{
		RoomMeterEntity entity = roomMeterRepository.findByCompCodeAndIdAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),dto.getId(),false);
		entity.setMarkDelete(true);
		roomMeterRepository.save(entity);
		dto = buildRoomMeterDTO(entity);
	}
	public List<RoomMeterDTO> loadActiveRoomMeter(){
		List <RoomMeterDTO>resultList = new ArrayList<RoomMeterDTO>();
		List<RoomMeterEntity> listEntity =  roomMeterRepository.findByCompCodeAndIsActiveAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),true,false);
		resultList = buildRoomMeterDTO(listEntity);
		return resultList;
	}
	public static RoomMeterDTO buildRoomMeterDTO(RoomMeterEntity entity){
		if(entity == null)
			return null;
		RoomMeterDTO dto = null;
		dto = new RoomMeterDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setRoom(AbstractRoomService.buildRoomDTO(entity.getRoom()));
		dto.setMeterType(AbstractMeterTypeService.buildMeterTypeDTO(entity.getMeterType()));
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;
	}
	public static List<RoomMeterDTO> buildRoomMeterDTO(List<RoomMeterEntity> entities){
		List<RoomMeterDTO> listReturn = new ArrayList<RoomMeterDTO>();
		Iterator<RoomMeterEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoomMeterDTO((RoomMeterEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<RoomMeterEntity> buildRoomMeterEntity(List<RoomMeterDTO> dtoList){ 
		List<RoomMeterEntity> listReturn = new ArrayList<RoomMeterEntity>();
		Iterator<RoomMeterDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoomMeterEntity((RoomMeterDTO)iterator.next()));
		}
		return listReturn;
	}
	public RoomMeterEntity buildRoomMeterEntity(RoomMeterDTO dto) {
		RoomMeterEntity entity = null;
		if (dto.getId() == null)
			entity = (RoomMeterEntity)DtoEntityUtil.initEntity(new RoomMeterEntity());
		else
			entity = roomMeterRepository.findOne(dto.getId());
		entity.setIsActive(dto.getIsActive());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		if(dto.getRoom() != null && dto.getRoom().getId() !=null)
		 entity.setRoom(roomRepository.findOne(dto.getRoom().getId()));
		if(dto.getMeterType() != null && dto.getMeterType().getId() !=null)
		 entity.setMeterType(meterTypeRepository.findOne(dto.getMeterType().getId()));
		return entity;
	}
}
