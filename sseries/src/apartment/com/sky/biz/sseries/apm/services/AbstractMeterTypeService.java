package com.sky.biz.sseries.apm.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.apm.dto.*;
import com.sky.biz.sseries.apm.entity.*;
import com.sky.biz.sseries.apm.specification.*;

import java.util.*;
public class AbstractMeterTypeService extends ApmService {

	
	public MeterTypeDTO loadById(Long id){
		return buildMeterTypeDTO(meterTypeRepository.findOne(id));
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public PageDTOUtil<MeterTypeDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<MeterTypeDTO> dtoList = new ArrayList<MeterTypeDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<MeterTypeEntity> entityPage =  meterTypeRepository.findAll(MeterTypeSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractMeterTypeService.buildMeterTypeDTO(entityPage.getContent());
		PageDTOUtil<MeterTypeDTO> pageDTO = new PageDTOUtil<MeterTypeDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}
	
	public PageDTOUtil<MeterTypeDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}
	public MeterTypeDTO saveNew(MeterTypeDTO dto) throws Exception{
		MeterTypeEntity entity = this.buildMeterTypeEntity(dto);
		entity.setCreatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCreatedDate(Calendar.getInstance());
		entity.setVersion(0);
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity =  meterTypeRepository.save(entity);
		return buildMeterTypeDTO(entity);
	}
	public MeterTypeDTO update(MeterTypeDTO dto) throws Exception{
		MeterTypeEntity entity = this.buildMeterTypeEntity(dto);
		entity.setId(dto.getId());
		entity.setUpdatedBy(SpringSecurityUtil.getCurrentUserAccountId());
		entity.setCompCode(SpringSecurityUtil.getCurrentCompCode());
		entity.setUpdatedDate(Calendar.getInstance());
		entity =  meterTypeRepository.save(entity);
		return buildMeterTypeDTO(entity);
	}
	public void delete(MeterTypeDTO dto) throws Exception{
		MeterTypeEntity entity = meterTypeRepository.findByCompCodeAndIdAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),dto.getId(),false);
		entity.setMarkDelete(true);
		meterTypeRepository.save(entity);
		dto = buildMeterTypeDTO(entity);
	}
	public List<MeterTypeDTO> loadActiveMeterType(){
		List <MeterTypeDTO>resultList = new ArrayList<MeterTypeDTO>();
		List<MeterTypeEntity> listEntity =  meterTypeRepository.findByCompCodeAndIsActiveAndMarkDelete(SpringSecurityUtil.getCurrentCompCode(),true,false);
		resultList = buildMeterTypeDTO(listEntity);
		return resultList;
	}
	public static MeterTypeDTO buildMeterTypeDTO(MeterTypeEntity entity){
		if(entity == null)
			return null;
		MeterTypeDTO dto = null;
		dto = new MeterTypeDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;
	}
	public static List<MeterTypeDTO> buildMeterTypeDTO(List<MeterTypeEntity> entities){
		List<MeterTypeDTO> listReturn = new ArrayList<MeterTypeDTO>();
		Iterator<MeterTypeEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildMeterTypeDTO((MeterTypeEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<MeterTypeEntity> buildMeterTypeEntity(List<MeterTypeDTO> dtoList){ 
		List<MeterTypeEntity> listReturn = new ArrayList<MeterTypeEntity>();
		Iterator<MeterTypeDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildMeterTypeEntity((MeterTypeDTO)iterator.next()));
		}
		return listReturn;
	}
	public MeterTypeEntity buildMeterTypeEntity(MeterTypeDTO dto) {
		MeterTypeEntity entity = null;
		if(dto.getId() == null)
			entity = (MeterTypeEntity)DtoEntityUtil.initEntity(new MeterTypeEntity());
		else
			entity = meterTypeRepository.findOne(dto.getId());
		entity.setIsActive(dto.getIsActive());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		return entity;
	}
}
