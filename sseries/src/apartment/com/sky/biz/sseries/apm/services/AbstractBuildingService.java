package com.sky.biz.sseries.apm.services;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.apm.dto.*;
import com.sky.biz.sseries.apm.entity.*;
import com.sky.biz.sseries.apm.specification.*;

import java.util.*;
@Transactional
public class AbstractBuildingService extends ApmService{

	
	public BuildingDTO loadById(Long id){
		return buildBuildingDTO(buildingRepository.findOne(id));
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageDTOUtil<BuildingDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<BuildingDTO> dtoList = new ArrayList<BuildingDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<BuildingEntity> entityPage =  buildingRepository.findAll(BuildingSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractBuildingService.buildBuildingDTO(entityPage.getContent());
		PageDTOUtil<BuildingDTO> pageDTO = new PageDTOUtil<BuildingDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	
	public PageDTOUtil<BuildingDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}

	public BuildingDTO saveNew(BuildingDTO dto) throws Exception{

		BuildingEntity entity = this.buildBuildingEntity(dto);

		entity.setCreatedBy(SpringSecurityUtil.getCurrentUserAccountId());

		entity.setCreatedDate(Calendar.getInstance());

		entity.setVersion(0);

		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());

		entity =  buildingRepository.save(entity);

		return buildBuildingDTO(entity);

	}

	public BuildingDTO update(BuildingDTO dto) throws Exception{

		BuildingEntity entity = this.buildBuildingEntity(dto);

		entity.setId(dto.getId());

		entity.setUpdatedBy(SpringSecurityUtil.getCurrentUserAccountId());

		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());

		entity.setUpdatedDate(Calendar.getInstance());

		entity =  buildingRepository.save(entity);

		return buildBuildingDTO(entity);

	}

	public void delete(BuildingDTO dto) throws Exception{

		BuildingEntity entity = buildingRepository.findByCompCodeAndIdAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),dto.getId(),false);

		entity.setMarkDelete(true);

		buildingRepository.save(entity);

		dto = buildBuildingDTO(entity);

	}

	public List<BuildingDTO> loadActiveBuilding(){

		List <BuildingDTO>resultList = new ArrayList<BuildingDTO>();

		List<BuildingEntity> listEntity =  buildingRepository.findByCompCodeAndIsActiveAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),true,false);

		resultList = buildBuildingDTO(listEntity);

		return resultList;

	}
	public static BuildingDTO buildBuildingDTO(BuildingEntity entity){
		if(entity == null)
			return null;
		BuildingDTO dto = null;
		dto = new BuildingDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<BuildingDTO> buildBuildingDTO(List<BuildingEntity> entities){
		List<BuildingDTO> listReturn = new ArrayList<BuildingDTO>();
		Iterator<BuildingEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildBuildingDTO((BuildingEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<BuildingEntity> buildBuildingEntity(List<BuildingDTO> dtoList){ 
		List<BuildingEntity> listReturn = new ArrayList<BuildingEntity>();
		Iterator<BuildingDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildBuildingEntity((BuildingDTO)iterator.next()));
		}
		return listReturn;
	}
	public BuildingEntity buildBuildingEntity(BuildingDTO dto) {
		
		BuildingEntity entity = null;
		if (dto.getId() == null)
			entity = (BuildingEntity)DtoEntityUtil.initEntity(new BuildingEntity());
		else
			entity = buildingRepository.findOne(dto.getId());
		entity.setIsActive(dto.getIsActive());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		return entity;
	}
}
