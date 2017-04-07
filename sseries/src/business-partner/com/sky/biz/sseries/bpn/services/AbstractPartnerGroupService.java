package com.sky.biz.sseries.bpn.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.bpn.dto.*;
import com.sky.biz.sseries.bpn.entity.*;
import com.sky.biz.sseries.bpn.specification.*;

import java.util.*;
public class AbstractPartnerGroupService extends BpnService implements ISSeriesServices{

	@Override
	public PartnerGroupDTO loadById(Long id){
		return buildPartnerGroupDTO(partnerGroupRepository.findOne(id));

	}

	@Override
	public PageDTOUtil<PartnerGroupDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<PartnerGroupDTO> dtoList = new ArrayList<PartnerGroupDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<PartnerGroupEntity> entityPage =  partnerGroupRepository.findAll(PartnerGroupSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractPartnerGroupService.buildPartnerGroupDTO(entityPage.getContent());
		PageDTOUtil<PartnerGroupDTO> pageDTO = new PageDTOUtil<PartnerGroupDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	@Override

	@SuppressWarnings("unchecked")
	public PageDTOUtil<PartnerGroupDTO> loadData(int first, int pageSize){

		return this.loadData(first,pageSize,null);
	}

	public PartnerGroupDTO saveNew(PartnerGroupDTO dto) throws Exception{

		PartnerGroupEntity entity = this.buildPartnerGroupEntity(dto);

		entity.setCreatedBy(-9999L);

		entity.setCreatedDate(Calendar.getInstance());

		entity.setVersion(0);

		entity.setCompCode("FCNF");

		entity =  partnerGroupRepository.save(entity);

		return buildPartnerGroupDTO(entity);

	}

	public PartnerGroupDTO update(PartnerGroupDTO dto) throws Exception{

		PartnerGroupEntity entity = this.buildPartnerGroupEntity(dto);

		entity.setId(dto.getId());

		entity.setUpdatedBy(-9999L);

		entity.setCompCode("FCNF");

		entity.setUpdatedDate(Calendar.getInstance());

		entity =  partnerGroupRepository.save(entity);

		return buildPartnerGroupDTO(entity);

	}

	public void delete(PartnerGroupDTO dto) throws Exception{

		PartnerGroupEntity entity = partnerGroupRepository.findByCompCodeAndIdAndMarkDelete("FCNF",dto.getId(),false);

		entity.setMarkDelete(true);

		partnerGroupRepository.save(entity);

		dto = buildPartnerGroupDTO(entity);

	}
	public static PartnerGroupDTO buildPartnerGroupDTO(PartnerGroupEntity entity){
		if(entity == null)
			return null;
		PartnerGroupDTO dto = null;
		dto = new PartnerGroupDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setDefaultGroup(entity.getDefaultGroup());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<PartnerGroupDTO> buildPartnerGroupDTO(List<PartnerGroupEntity> entities){
		List<PartnerGroupDTO> listReturn = new ArrayList<PartnerGroupDTO>();
		Iterator<PartnerGroupEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildPartnerGroupDTO((PartnerGroupEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<PartnerGroupEntity> buildPartnerGroupEntity(List<PartnerGroupDTO> dtoList){ 
		List<PartnerGroupEntity> listReturn = new ArrayList<PartnerGroupEntity>();
		Iterator<PartnerGroupDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildPartnerGroupEntity((PartnerGroupDTO)iterator.next()));
		}
		return listReturn;
	}
	public PartnerGroupEntity buildPartnerGroupEntity(PartnerGroupDTO dto) {
		PartnerGroupEntity entity = (PartnerGroupEntity)DtoEntityUtil.initEntity(new PartnerGroupEntity());
		entity.setIsActive(dto.getIsActive());
		entity.setDefaultGroup(dto.getDefaultGroup());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		return entity;
	}
}
