package com.sky.biz.sseries.bpn.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.bpn.dto.*;
import com.sky.biz.sseries.bpn.entity.*;
import com.sky.biz.sseries.bpn.specification.*;

import java.util.*;
public class AbstractPartnerCategoryService extends BpnService implements ISSeriesServices{

	@Override
	public PartnerCategoryDTO loadById(Long id){
		return buildPartnerCategoryDTO(partnerCategoryRepository.findOne(id));

	}

	@Override
	public PageDTOUtil<PartnerCategoryDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<PartnerCategoryDTO> dtoList = new ArrayList<PartnerCategoryDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<PartnerCategoryEntity> entityPage =  partnerCategoryRepository.findAll(PartnerCategorySpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractPartnerCategoryService.buildPartnerCategoryDTO(entityPage.getContent());
		PageDTOUtil<PartnerCategoryDTO> pageDTO = new PageDTOUtil<PartnerCategoryDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	@Override

	@SuppressWarnings("unchecked")
	public PageDTOUtil<PartnerCategoryDTO> loadData(int first, int pageSize){

		return this.loadData(first,pageSize,null);
	}

	public PartnerCategoryDTO saveNew(PartnerCategoryDTO dto) throws Exception{

		PartnerCategoryEntity entity = this.buildPartnerCategoryEntity(dto);

		entity.setCreatedBy(-9999L);

		entity.setCreatedDate(Calendar.getInstance());

		entity.setActive(true);

		entity.setVersion(0);

		entity.setCompCode("FCNF");

		entity =  partnerCategoryRepository.save(entity);

		return buildPartnerCategoryDTO(entity);

	}

	public PartnerCategoryDTO update(PartnerCategoryDTO dto) throws Exception{

		PartnerCategoryEntity entity = this.buildPartnerCategoryEntity(dto);

		entity.setId(dto.getId());

		entity.setUpdatedBy(-9999L);

		entity.setUpdatedDate(Calendar.getInstance());

		entity =  partnerCategoryRepository.save(entity);

		return buildPartnerCategoryDTO(entity);

	}

	public void delete(PartnerCategoryDTO dto) throws Exception{

		PartnerCategoryEntity entity = partnerCategoryRepository.findByCompCodeAndIdAndMarkDelete("FCNF",dto.getId(),false);

		entity.setMarkDelete(true);

		partnerCategoryRepository.save(entity);

		dto = buildPartnerCategoryDTO(entity);

	}
	public static PartnerCategoryDTO buildPartnerCategoryDTO(PartnerCategoryEntity entity){
		if(entity == null)
			return null;
		PartnerCategoryDTO dto = null;
		dto = new PartnerCategoryDTO();
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<PartnerCategoryDTO> buildPartnerCategoryDTO(List<PartnerCategoryEntity> entities){
		List<PartnerCategoryDTO> listReturn = new ArrayList<PartnerCategoryDTO>();
		Iterator<PartnerCategoryEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildPartnerCategoryDTO((PartnerCategoryEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<PartnerCategoryEntity> buildPartnerCategoryEntity(List<PartnerCategoryDTO> dtoList){ 
		List<PartnerCategoryEntity> listReturn = new ArrayList<PartnerCategoryEntity>();
		Iterator<PartnerCategoryDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildPartnerCategoryEntity((PartnerCategoryDTO)iterator.next()));
		}
		return listReturn;
	}
	public PartnerCategoryEntity buildPartnerCategoryEntity(PartnerCategoryDTO dto) {
		PartnerCategoryEntity entity = (PartnerCategoryEntity)DtoEntityUtil.initEntity(new PartnerCategoryEntity());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		return entity;
	}
}
