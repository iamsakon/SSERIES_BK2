package com.sky.biz.sseries.apm.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.apm.dto.*;
import com.sky.biz.sseries.apm.entity.*;
import com.sky.biz.sseries.apm.specification.*;

import java.util.*;
public class AbstractFloorService extends ApmService {

	public FloorDTO loadById(Long id){
		return buildFloorDTO(floorRepository.findOne(id));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public PageDTOUtil<FloorDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<FloorDTO> dtoList = new ArrayList<FloorDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<FloorEntity> entityPage =  floorRepository.findAll(FloorSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractFloorService.buildFloorDTO(entityPage.getContent());
		PageDTOUtil<FloorDTO> pageDTO = new PageDTOUtil<FloorDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	public PageDTOUtil<FloorDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}
	public FloorDTO saveNew(FloorDTO dto) throws Exception{
		FloorEntity entity = this.buildFloorEntity(dto);
		entity.setCreatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCreatedDate(Calendar.getInstance());
		entity.setVersion(0);
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity =  floorRepository.save(entity);
		return buildFloorDTO(entity);
	}
	public FloorDTO update(FloorDTO dto) throws Exception{
		FloorEntity entity = this.buildFloorEntity(dto);
		entity.setId(dto.getId());
		entity.setUpdatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity.setUpdatedDate(Calendar.getInstance());
		entity =  floorRepository.save(entity);
		return buildFloorDTO(entity);
	}
	public void delete(FloorDTO dto) throws Exception{
		FloorEntity entity = floorRepository.findByCompCodeAndIdAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),dto.getId(),false);
		entity.setMarkDelete(true);
		floorRepository.save(entity);
		dto = buildFloorDTO(entity);
	}
	public List<FloorDTO> loadActiveFloor(){
		List <FloorDTO>resultList = new ArrayList<FloorDTO>();
		List<FloorEntity> listEntity =  floorRepository.findByCompCodeAndIsActiveAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),true,false);
		resultList = buildFloorDTO(listEntity);
		return resultList;
	}
	public static FloorDTO buildFloorDTO(FloorEntity entity){
		if(entity == null)
			return null;
		FloorDTO dto = null;
		dto = new FloorDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setBuilding(AbstractBuildingService.buildBuildingDTO(entity.getBuilding()));
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;
	}
	public static List<FloorDTO> buildFloorDTO(List<FloorEntity> entities){
		List<FloorDTO> listReturn = new ArrayList<FloorDTO>();
		Iterator<FloorEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildFloorDTO((FloorEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<FloorEntity> buildFloorEntity(List<FloorDTO> dtoList){ 
		List<FloorEntity> listReturn = new ArrayList<FloorEntity>();
		Iterator<FloorDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildFloorEntity((FloorDTO)iterator.next()));
		}
		return listReturn;
	}
	public FloorEntity buildFloorEntity(FloorDTO dto) {
		FloorEntity entity = null;
		if(dto.getId() ==null)
			entity = (FloorEntity)DtoEntityUtil.initEntity(new FloorEntity());
		else 
			entity = floorRepository.findOne(dto.getId());
		entity.setIsActive(dto.getIsActive());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		if(dto.getBuilding() != null && dto.getBuilding().getId() !=null)
		 entity.setBuilding(buildingRepository.findOne(dto.getBuilding().getId()));
		return entity;
	}
}
