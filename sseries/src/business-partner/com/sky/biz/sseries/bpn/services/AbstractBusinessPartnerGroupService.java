package com.sky.biz.sseries.bpn.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.bpn.dto.*;
import com.sky.biz.sseries.bpn.entity.*;
import com.sky.biz.sseries.bpn.specification.*;

import java.util.*;
@SuppressWarnings("rawtypes")
public class AbstractBusinessPartnerGroupService extends BpnService implements ISSeriesServices{

	@Override

	public BusinessPartnerGroupDTO loadById(Long id){
		return buildBusinessPartnerGroupDTO(businessPartnerGroupRepository.findOne(id));

	}

	@Override
	public PageDTOUtil<BusinessPartnerGroupDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<BusinessPartnerGroupDTO> dtoList = new ArrayList<BusinessPartnerGroupDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<BusinessPartnerGroupEntity> entityPage =  businessPartnerGroupRepository.findAll(BusinessPartnerGroupSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractBusinessPartnerGroupService.buildBusinessPartnerGroupDTO(entityPage.getContent());
		PageDTOUtil<BusinessPartnerGroupDTO> pageDTO = new PageDTOUtil<BusinessPartnerGroupDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	@Override
	@SuppressWarnings("unchecked")
	public PageDTOUtil<BusinessPartnerGroupDTO> loadData(int first, int pageSize){

		return this.loadData(first,pageSize,null);
	}

	public BusinessPartnerGroupDTO saveNew(BusinessPartnerGroupDTO dto) throws Exception{
		BusinessPartnerGroupEntity entity = this.buildBusinessPartnerGroupEntity(dto);
		entity.setCreatedBy(-9999L);
		entity.setCreatedDate(Calendar.getInstance());
		entity.setActive(true);
		entity.setVersion(0);
		entity.setCompCode("FCNF");
		entity =  businessPartnerGroupRepository.save(entity);
		return buildBusinessPartnerGroupDTO(entity);

	}
	
	public BusinessPartnerGroupDTO update(BusinessPartnerGroupDTO dto) throws Exception{
		BusinessPartnerGroupEntity entity = this.buildBusinessPartnerGroupEntity(dto);
		entity.setId(dto.getId());
		entity.setUpdatedBy(-9999L);
		entity.setUpdatedDate(Calendar.getInstance());		
		entity =  businessPartnerGroupRepository.save(entity);
		return buildBusinessPartnerGroupDTO(entity);

	}
	
	public void delete(BusinessPartnerGroupDTO dto) throws Exception{		
		BusinessPartnerGroupEntity entity = businessPartnerGroupRepository.findByCompCodeAndIdAndMarkDelete(dto.getCompCode(),dto.getId(),false);		
		entity.setMarkDelete(true);
		businessPartnerGroupRepository.save(entity);
		dto = buildBusinessPartnerGroupDTO(entity);

	}
	public static BusinessPartnerGroupDTO buildBusinessPartnerGroupDTO(BusinessPartnerGroupEntity entity){
		if(entity == null)
			return null;
		BusinessPartnerGroupDTO dto = null;
		dto = new BusinessPartnerGroupDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setDefaultGroup(entity.getDefaultGroup());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<BusinessPartnerGroupDTO> buildBusinessPartnerGroupDTO(List<BusinessPartnerGroupEntity> entities){
		List<BusinessPartnerGroupDTO> listReturn = new ArrayList<BusinessPartnerGroupDTO>();
		Iterator<BusinessPartnerGroupEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildBusinessPartnerGroupDTO((BusinessPartnerGroupEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<BusinessPartnerGroupEntity> buildBusinessPartnerGroupEntity(List<BusinessPartnerGroupDTO> dtoList){ 
		List<BusinessPartnerGroupEntity> listReturn = new ArrayList<BusinessPartnerGroupEntity>();
		Iterator<BusinessPartnerGroupDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildBusinessPartnerGroupEntity((BusinessPartnerGroupDTO)iterator.next()));
		}
		return listReturn;
	}
	public BusinessPartnerGroupEntity buildBusinessPartnerGroupEntity(BusinessPartnerGroupDTO dto) {
		BusinessPartnerGroupEntity entity = (BusinessPartnerGroupEntity)DtoEntityUtil.initEntity(new BusinessPartnerGroupEntity());
		
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setDefaultGroup(dto.getDefaultGroup());
		return entity;
	}
}
