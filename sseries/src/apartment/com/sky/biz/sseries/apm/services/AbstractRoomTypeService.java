package com.sky.biz.sseries.apm.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.apm.dto.*;
import com.sky.biz.sseries.apm.entity.*;
import com.sky.biz.sseries.apm.specification.*;

import java.util.*;
public class AbstractRoomTypeService extends ApmService {

	public RoomTypeDTO loadById(Long id){
		return buildRoomTypeDTO(roomTypeRepository.findOne(id));
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public PageDTOUtil<RoomTypeDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<RoomTypeDTO> dtoList = new ArrayList<RoomTypeDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<RoomTypeEntity> entityPage =  roomTypeRepository.findAll(RoomTypeSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractRoomTypeService.buildRoomTypeDTO(entityPage.getContent());
		PageDTOUtil<RoomTypeDTO> pageDTO = new PageDTOUtil<RoomTypeDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}
	
	public PageDTOUtil<RoomTypeDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}
	public RoomTypeDTO saveNew(RoomTypeDTO dto) throws Exception{
		RoomTypeEntity entity = this.buildRoomTypeEntity(dto);
		entity.setCreatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCreatedDate(Calendar.getInstance());
		entity.setVersion(0);
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity =  roomTypeRepository.save(entity);
		return buildRoomTypeDTO(entity);
	}
	public RoomTypeDTO update(RoomTypeDTO dto) throws Exception{
		RoomTypeEntity entity = this.buildRoomTypeEntity(dto);
		entity.setId(dto.getId());
		entity.setUpdatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity.setUpdatedDate(Calendar.getInstance());
		entity =  roomTypeRepository.save(entity);
		return buildRoomTypeDTO(entity);
	}
	public void delete(RoomTypeDTO dto) throws Exception{
		RoomTypeEntity entity = roomTypeRepository.findByCompCodeAndIdAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),dto.getId(),false);
		entity.setMarkDelete(true);
		roomTypeRepository.save(entity);
		dto = buildRoomTypeDTO(entity);
	}
	public List<RoomTypeDTO> loadActiveRoomType(){
		List <RoomTypeDTO>resultList = new ArrayList<RoomTypeDTO>();
		List<RoomTypeEntity> listEntity =  roomTypeRepository.findByCompCodeAndIsActiveAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),true,false);
		resultList = buildRoomTypeDTO(listEntity);
		return resultList;
	}
	public static RoomTypeDTO buildRoomTypeDTO(RoomTypeEntity entity){
		if(entity == null)
			return null;
		RoomTypeDTO dto = null;
		dto = new RoomTypeDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;
	}
	public static List<RoomTypeDTO> buildRoomTypeDTO(List<RoomTypeEntity> entities){
		List<RoomTypeDTO> listReturn = new ArrayList<RoomTypeDTO>();
		Iterator<RoomTypeEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoomTypeDTO((RoomTypeEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<RoomTypeEntity> buildRoomTypeEntity(List<RoomTypeDTO> dtoList){ 
		List<RoomTypeEntity> listReturn = new ArrayList<RoomTypeEntity>();
		Iterator<RoomTypeDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoomTypeEntity((RoomTypeDTO)iterator.next()));
		}
		return listReturn;
	}
	public RoomTypeEntity buildRoomTypeEntity(RoomTypeDTO dto) {
		RoomTypeEntity entity = null;
		if(dto.getId() == null)
			entity = (RoomTypeEntity)DtoEntityUtil.initEntity(new RoomTypeEntity());
		else
			entity = roomTypeRepository.findOne(dto.getId());
		entity.setIsActive(dto.getIsActive());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		return entity;
	}
}
