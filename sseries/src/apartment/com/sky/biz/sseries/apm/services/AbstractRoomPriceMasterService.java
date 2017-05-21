package com.sky.biz.sseries.apm.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.apm.dto.*;
import com.sky.biz.sseries.apm.entity.*;
import com.sky.biz.sseries.apm.specification.*;

import java.util.*;
public class AbstractRoomPriceMasterService extends ApmService {

	
	public RoomPriceMasterDTO loadById(Long id){
		return buildRoomPriceMasterDTO(roomPriceMasterRepository.findOne(id));
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public PageDTOUtil<RoomPriceMasterDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<RoomPriceMasterDTO> dtoList = new ArrayList<RoomPriceMasterDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<RoomPriceMasterEntity> entityPage =  roomPriceMasterRepository.findAll(RoomPriceMasterSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractRoomPriceMasterService.buildRoomPriceMasterDTO(entityPage.getContent());
		PageDTOUtil<RoomPriceMasterDTO> pageDTO = new PageDTOUtil<RoomPriceMasterDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}
	
	public PageDTOUtil<RoomPriceMasterDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}
	public RoomPriceMasterDTO saveNew(RoomPriceMasterDTO dto) throws Exception{
		RoomPriceMasterEntity entity = this.buildRoomPriceMasterEntity(dto);
		entity.setCreatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCreatedDate(Calendar.getInstance());
		entity.setVersion(0);
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity =  roomPriceMasterRepository.save(entity);
		return buildRoomPriceMasterDTO(entity);
	}
	public RoomPriceMasterDTO update(RoomPriceMasterDTO dto) throws Exception{
		RoomPriceMasterEntity entity = this.buildRoomPriceMasterEntity(dto);
		entity.setId(dto.getId());
		entity.setUpdatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity.setUpdatedDate(Calendar.getInstance());
		entity =  roomPriceMasterRepository.save(entity);
		return buildRoomPriceMasterDTO(entity);
	}
	public void delete(RoomPriceMasterDTO dto) throws Exception{
		RoomPriceMasterEntity entity = roomPriceMasterRepository.findByCompCodeAndIdAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),dto.getId(),false);
		entity.setMarkDelete(true);
		roomPriceMasterRepository.save(entity);
		dto = buildRoomPriceMasterDTO(entity);
	}
	public List<RoomPriceMasterDTO> loadActiveRoomPriceMaster(){
		List <RoomPriceMasterDTO>resultList = new ArrayList<RoomPriceMasterDTO>();
		List<RoomPriceMasterEntity> listEntity =  roomPriceMasterRepository.findByCompCodeAndIsActiveAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),true,false);
		resultList = buildRoomPriceMasterDTO(listEntity);
		return resultList;
	}
	public static RoomPriceMasterDTO buildRoomPriceMasterDTO(RoomPriceMasterEntity entity){
		if(entity == null)
			return null;
		RoomPriceMasterDTO dto = null;
		dto = new RoomPriceMasterDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setRoomType(AbstractRoomTypeService.buildRoomTypeDTO(entity.getRoomType()));
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;
	}
	public static List<RoomPriceMasterDTO> buildRoomPriceMasterDTO(List<RoomPriceMasterEntity> entities){
		List<RoomPriceMasterDTO> listReturn = new ArrayList<RoomPriceMasterDTO>();
		Iterator<RoomPriceMasterEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoomPriceMasterDTO((RoomPriceMasterEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<RoomPriceMasterEntity> buildRoomPriceMasterEntity(List<RoomPriceMasterDTO> dtoList){ 
		List<RoomPriceMasterEntity> listReturn = new ArrayList<RoomPriceMasterEntity>();
		Iterator<RoomPriceMasterDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoomPriceMasterEntity((RoomPriceMasterDTO)iterator.next()));
		}
		return listReturn;
	}
	public RoomPriceMasterEntity buildRoomPriceMasterEntity(RoomPriceMasterDTO dto) {
		RoomPriceMasterEntity entity = null;
		if(dto.getId() == null)
			entity = (RoomPriceMasterEntity)DtoEntityUtil.initEntity(new RoomPriceMasterEntity());
		else
			entity = roomPriceMasterRepository.findOne(dto.getId());
		entity.setIsActive(dto.getIsActive());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		if(dto.getRoomType() != null && dto.getRoomType().getId() !=null)
		 entity.setRoomType(roomTypeRepository.findOne(dto.getId()));
		return entity;
	}
}
