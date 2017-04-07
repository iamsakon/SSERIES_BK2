package com.sky.biz.sseries.bpn.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.bpn.dto.*;
import com.sky.biz.sseries.bpn.entity.*;
import com.sky.biz.sseries.bpn.specification.*;

import java.util.*;
public class AbstractAddressTypeService extends BpnService implements ISSeriesServices{

	@Override
	public AddressTypeDTO loadById(Long id){
		return buildAddressTypeDTO(addressTypeRepository.findOne(id));

	}

	@Override
	public PageDTOUtil<AddressTypeDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<AddressTypeDTO> dtoList = new ArrayList<AddressTypeDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<AddressTypeEntity> entityPage =  addressTypeRepository.findAll(AddressTypeSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractAddressTypeService.buildAddressTypeDTO(entityPage.getContent());
		PageDTOUtil<AddressTypeDTO> pageDTO = new PageDTOUtil<AddressTypeDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	@Override

	@SuppressWarnings("unchecked")
	public PageDTOUtil<AddressTypeDTO> loadData(int first, int pageSize){

		return this.loadData(first,pageSize,null);
	}

	public AddressTypeDTO saveNew(AddressTypeDTO dto) throws Exception{

		AddressTypeEntity entity = this.buildAddressTypeEntity(dto);

		entity.setCreatedBy(-9999L);

		entity.setCreatedDate(Calendar.getInstance());

		entity.setVersion(0);

		entity.setCompCode("FCNF");

		entity =  addressTypeRepository.save(entity);

		return buildAddressTypeDTO(entity);

	}

	public AddressTypeDTO update(AddressTypeDTO dto) throws Exception{

		AddressTypeEntity entity = this.buildAddressTypeEntity(dto);

		entity.setId(dto.getId());

		entity.setUpdatedBy(-9999L);

		entity.setCompCode("FCNF");

		entity.setUpdatedDate(Calendar.getInstance());

		entity =  addressTypeRepository.save(entity);

		return buildAddressTypeDTO(entity);

	}

	public void delete(AddressTypeDTO dto) throws Exception{

		AddressTypeEntity entity = addressTypeRepository.findByCompCodeAndIdAndMarkDelete("FCNF",dto.getId(),false);

		entity.setMarkDelete(true);

		addressTypeRepository.save(entity);

		dto = buildAddressTypeDTO(entity);

	}
	public static AddressTypeDTO buildAddressTypeDTO(AddressTypeEntity entity){
		if(entity == null)
			return null;
		AddressTypeDTO dto = null;
		dto = new AddressTypeDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<AddressTypeDTO> buildAddressTypeDTO(List<AddressTypeEntity> entities){
		List<AddressTypeDTO> listReturn = new ArrayList<AddressTypeDTO>();
		Iterator<AddressTypeEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildAddressTypeDTO((AddressTypeEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<AddressTypeEntity> buildAddressTypeEntity(List<AddressTypeDTO> dtoList){ 
		List<AddressTypeEntity> listReturn = new ArrayList<AddressTypeEntity>();
		Iterator<AddressTypeDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildAddressTypeEntity((AddressTypeDTO)iterator.next()));
		}
		return listReturn;
	}
	public AddressTypeEntity buildAddressTypeEntity(AddressTypeDTO dto) {
		AddressTypeEntity entity = (AddressTypeEntity)DtoEntityUtil.initEntity(new AddressTypeEntity());
		entity.setIsActive(dto.getIsActive());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		return entity;
	}
}
