package com.sky.biz.sseries.apm.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.apm.dto.*;
import com.sky.biz.sseries.apm.entity.*;
import com.sky.biz.sseries.apm.specification.*;

import java.util.*;
public class AbstractRoomStatusService extends ApmService {

	public RoomStatusDTO loadById(Long id){
		return buildRoomStatusDTO(roomStatusRepository.findOne(id));
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public PageDTOUtil<RoomStatusDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<RoomStatusDTO> dtoList = new ArrayList<RoomStatusDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<RoomStatusEntity> entityPage =  roomStatusRepository.findAll(RoomStatusSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractRoomStatusService.buildRoomStatusDTO(entityPage.getContent());
		PageDTOUtil<RoomStatusDTO> pageDTO = new PageDTOUtil<RoomStatusDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}
	
	public PageDTOUtil<RoomStatusDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}
	public RoomStatusDTO saveNew(RoomStatusDTO dto) throws Exception{
		RoomStatusEntity entity = this.buildRoomStatusEntity(dto);
		entity.setCreatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCreatedDate(Calendar.getInstance());
		entity.setVersion(0);
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity =  roomStatusRepository.save(entity);
		return buildRoomStatusDTO(entity);
	}
	public RoomStatusDTO update(RoomStatusDTO dto) throws Exception{
		RoomStatusEntity entity = this.buildRoomStatusEntity(dto);
		entity.setId(dto.getId());
		entity.setUpdatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity.setUpdatedDate(Calendar.getInstance());
		entity =  roomStatusRepository.save(entity);
		return buildRoomStatusDTO(entity);
	}
	public void delete(RoomStatusDTO dto) throws Exception{
		RoomStatusEntity entity = roomStatusRepository.findByCompCodeAndIdAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),dto.getId(),false);
		entity.setMarkDelete(true);
		roomStatusRepository.save(entity);
		dto = buildRoomStatusDTO(entity);
	}
	public List<RoomStatusDTO> loadActiveRoomStatus(){
		List <RoomStatusDTO>resultList = new ArrayList<RoomStatusDTO>();
		List<RoomStatusEntity> listEntity =  roomStatusRepository.findByCompCodeAndIsActiveAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),true,false);
		resultList = buildRoomStatusDTO(listEntity);
		return resultList;
	}
	public static RoomStatusDTO buildRoomStatusDTO(RoomStatusEntity entity){
		if(entity == null)
			return null;
		RoomStatusDTO dto = null;
		dto = new RoomStatusDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setDefaultStatus(entity.getDefaultStatus());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;
	}
	public static List<RoomStatusDTO> buildRoomStatusDTO(List<RoomStatusEntity> entities){
		List<RoomStatusDTO> listReturn = new ArrayList<RoomStatusDTO>();
		Iterator<RoomStatusEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoomStatusDTO((RoomStatusEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<RoomStatusEntity> buildRoomStatusEntity(List<RoomStatusDTO> dtoList){ 
		List<RoomStatusEntity> listReturn = new ArrayList<RoomStatusEntity>();
		Iterator<RoomStatusDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoomStatusEntity((RoomStatusDTO)iterator.next()));
		}
		return listReturn;
	}
	public RoomStatusEntity buildRoomStatusEntity(RoomStatusDTO dto) {
		RoomStatusEntity entity = null;
		if(dto.getId() == null)
			entity = (RoomStatusEntity)DtoEntityUtil.initEntity(new RoomStatusEntity());
		else
			entity = roomStatusRepository.findOne(dto.getId());
		entity.setIsActive(dto.getIsActive());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setDefaultStatus(dto.getDefaultStatus());
		return entity;
	}
}
