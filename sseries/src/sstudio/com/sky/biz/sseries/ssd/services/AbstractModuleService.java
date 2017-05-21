package com.sky.biz.sseries.ssd.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.ssd.dto.*;
import com.sky.biz.sseries.ssd.entity.*;
import com.sky.biz.sseries.ssd.specification.*;

import java.util.*;
public class AbstractModuleService extends SsdService implements IModuleService{

	@Override
	public ModuleDTO loadById(Long id){
		return buildModuleDTO(moduleRepository.findOne(id));
	}
	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public PageDTOUtil<ModuleDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<ModuleDTO> dtoList = new ArrayList<ModuleDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<ModuleEntity> entityPage =  moduleRepository.findAll(ModuleSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractModuleService.buildModuleDTO(entityPage.getContent());
		PageDTOUtil<ModuleDTO> pageDTO = new PageDTOUtil<ModuleDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}
	@Override
	public PageDTOUtil<ModuleDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}
	public ModuleDTO saveNew(ModuleDTO dto) throws Exception{
		ModuleEntity entity = this.buildModuleEntity(dto);
		entity.setCreatedBy(-9999L);
		entity.setCreatedDate(Calendar.getInstance());
		entity.setVersion(0);
		entity.setCompCode("FCNF");
		entity =  moduleRepository.save(entity);
		return buildModuleDTO(entity);
	}
	public ModuleDTO update(ModuleDTO dto) throws Exception{
		ModuleEntity entity = this.buildModuleEntity(dto);
		entity.setId(dto.getId());
		entity.setUpdatedBy(-9999L);
		entity.setCompCode("FCNF");
		entity.setUpdatedDate(Calendar.getInstance());
		entity =  moduleRepository.save(entity);
		return buildModuleDTO(entity);
	}
	public void delete(ModuleDTO dto) throws Exception{
		ModuleEntity entity = moduleRepository.findByCompCodeAndIdAndMarkDelete("FCNF",dto.getId(),false);
		entity.setMarkDelete(true);
		moduleRepository.save(entity);
		dto = buildModuleDTO(entity);
	}
	public List<ModuleDTO> loadActiveModule(){
		List <ModuleDTO>resultList = new ArrayList<ModuleDTO>();
		List<ModuleEntity> listEntity =  moduleRepository.findByCompCodeAndIsActiveAndMarkDelete("FCNF",true,false);
		resultList = buildModuleDTO(listEntity);
		return resultList;
	}
	public static ModuleDTO buildModuleDTO(ModuleEntity entity){
		if(entity == null)
			return null;
		ModuleDTO dto = null;
		dto = new ModuleDTO();
		dto.setCode(entity.getCode());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setIsActive(entity.getIsActive());
		dto.setName(entity.getName());
		dto.setSortKey(entity.getSortKey());
		dto.setProduct(AbstractProductService.buildProductDTO(entity.getProduct()));
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;
	}
	public static List<ModuleDTO> buildModuleDTO(List<ModuleEntity> entities){
		List<ModuleDTO> listReturn = new ArrayList<ModuleDTO>();
		Iterator<ModuleEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildModuleDTO((ModuleEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<ModuleEntity> buildModuleEntity(List<ModuleDTO> dtoList){ 
		List<ModuleEntity> listReturn = new ArrayList<ModuleEntity>();
		Iterator<ModuleDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildModuleEntity((ModuleDTO)iterator.next()));
		}
		return listReturn;
	}
	public ModuleEntity buildModuleEntity(ModuleDTO dto) {
		ModuleEntity entity = (ModuleEntity)DtoEntityUtil.initEntity(new ModuleEntity());
		entity.setCode(dto.getCode());
		entity.setDescription(dto.getDescription());
		
		entity.setIsActive(dto.getIsActive());
		entity.setName(dto.getName());
		entity.setSortKey(dto.getSortKey());
		if(dto.getProduct() != null && dto.getProduct().getId() !=null)
		 entity.setProduct(productRepository.findOne(dto.getId()));
		return entity;
	}
}
