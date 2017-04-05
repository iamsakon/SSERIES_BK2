package com.sky.biz.sseries.bpn.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.bpn.dto.*;
import com.sky.biz.sseries.bpn.entity.*;
import com.sky.biz.sseries.bpn.specification.*;

import java.util.*;
public class AbstractCorporateTypeService extends BpnService implements ISSeriesServices{

	@Override
	public CorporateTypeDTO loadById(Long id){
		return buildCorporateTypeDTO(corporateTypeRepository.findOne(id));

	}

	@Override
	public PageDTOUtil<CorporateTypeDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<CorporateTypeDTO> dtoList = new ArrayList<CorporateTypeDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<CorporateTypeEntity> entityPage =  corporateTypeRepository.findAll(CorporateTypeSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractCorporateTypeService.buildCorporateTypeDTO(entityPage.getContent());
		PageDTOUtil<CorporateTypeDTO> pageDTO = new PageDTOUtil<CorporateTypeDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	@Override

	@SuppressWarnings("unchecked")
	public PageDTOUtil<CorporateTypeDTO> loadData(int first, int pageSize){

		return this.loadData(first,pageSize,null);
	}

	public CorporateTypeDTO saveNew(CorporateTypeDTO dto) throws Exception{

		CorporateTypeEntity entity = this.buildCorporateTypeEntity(dto);

		entity.setCreatedBy(-9999L);

		entity.setCreatedDate(Calendar.getInstance());

		entity.setVersion(0);

		entity.setCompCode("FCNF");

		entity =  corporateTypeRepository.save(entity);

		return buildCorporateTypeDTO(entity);

	}

	public CorporateTypeDTO update(CorporateTypeDTO dto) throws Exception{

		CorporateTypeEntity entity = this.buildCorporateTypeEntity(dto);

		entity.setId(dto.getId());

		entity.setUpdatedBy(-9999L);
		
		entity.setCompCode("FCNF");

		entity.setUpdatedDate(Calendar.getInstance());

		entity =  corporateTypeRepository.save(entity);

		return buildCorporateTypeDTO(entity);

	}

	public void delete(CorporateTypeDTO dto) throws Exception{

		CorporateTypeEntity entity = corporateTypeRepository.findByCompCodeAndIdAndMarkDelete("FCNF",dto.getId(),false);

		entity.setMarkDelete(true);

		corporateTypeRepository.save(entity);

		dto = buildCorporateTypeDTO(entity);

	}
	public static CorporateTypeDTO buildCorporateTypeDTO(CorporateTypeEntity entity){
		if(entity == null)
			return null;
		CorporateTypeDTO dto = null;
		dto = new CorporateTypeDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<CorporateTypeDTO> buildCorporateTypeDTO(List<CorporateTypeEntity> entities){
		List<CorporateTypeDTO> listReturn = new ArrayList<CorporateTypeDTO>();
		Iterator<CorporateTypeEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildCorporateTypeDTO((CorporateTypeEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<CorporateTypeEntity> buildCorporateTypeEntity(List<CorporateTypeDTO> dtoList){ 
		List<CorporateTypeEntity> listReturn = new ArrayList<CorporateTypeEntity>();
		Iterator<CorporateTypeDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildCorporateTypeEntity((CorporateTypeDTO)iterator.next()));
		}
		return listReturn;
	}
	public CorporateTypeEntity buildCorporateTypeEntity(CorporateTypeDTO dto) {
		CorporateTypeEntity entity = (CorporateTypeEntity)DtoEntityUtil.initEntity(new CorporateTypeEntity());
		entity.setIsActive(dto.getIsActive());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		return entity;
	}
}
