package com.sky.biz.sseries.ssd.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.ssd.dto.*;
import com.sky.biz.sseries.ssd.entity.*;
import com.sky.biz.sseries.ssd.specification.*;

import java.util.*;
public class AbstractProductService extends SsdService implements IProductService{

	@Override
	public ProductDTO loadById(Long id){
		return buildProductDTO(productRepository.findOne(id));
	}
	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public PageDTOUtil<ProductDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<ProductEntity> entityPage =  productRepository.findAll(ProductSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractProductService.buildProductDTO(entityPage.getContent());
		PageDTOUtil<ProductDTO> pageDTO = new PageDTOUtil<ProductDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}
	@Override
	public PageDTOUtil<ProductDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}
	public ProductDTO saveNew(ProductDTO dto) throws Exception{
		ProductEntity entity = this.buildProductEntity(dto);
		entity.setCreatedBy(-9999L);
		entity.setCreatedDate(Calendar.getInstance());
		entity.setVersion(0);
		entity.setCompCode("FCNF");
		entity =  productRepository.save(entity);
		return buildProductDTO(entity);
	}
	public ProductDTO update(ProductDTO dto) throws Exception{
		ProductEntity entity = this.buildProductEntity(dto);
		entity.setId(dto.getId());
		entity.setUpdatedBy(-9999L);
		entity.setCompCode("FCNF");
		entity.setUpdatedDate(Calendar.getInstance());
		entity =  productRepository.save(entity);
		return buildProductDTO(entity);
	}
	public void delete(ProductDTO dto) throws Exception{
		ProductEntity entity = productRepository.findByCompCodeAndIdAndMarkDelete("FCNF",dto.getId(),false);
		entity.setMarkDelete(true);
		productRepository.save(entity);
		dto = buildProductDTO(entity);
	}
	public List<ProductDTO> loadActiveProduct(){
		List <ProductDTO>resultList = new ArrayList<ProductDTO>();
		List<ProductEntity> listEntity =  productRepository.findByCompCodeAndIsActiveAndMarkDelete("FCNF",true,false);
		resultList = buildProductDTO(listEntity);
		return resultList;
	}
	public static ProductDTO buildProductDTO(ProductEntity entity){
		if(entity == null)
			return null;
		ProductDTO dto = null;
		dto = new ProductDTO();
		dto.setCode(entity.getCode());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		dto.setIsActive(entity.getIsActive());
		dto.setName(entity.getName());
		dto.setSortKey(entity.getSortKey());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;
	}
	public static List<ProductDTO> buildProductDTO(List<ProductEntity> entities){
		List<ProductDTO> listReturn = new ArrayList<ProductDTO>();
		Iterator<ProductEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildProductDTO((ProductEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<ProductEntity> buildProductEntity(List<ProductDTO> dtoList){ 
		List<ProductEntity> listReturn = new ArrayList<ProductEntity>();
		Iterator<ProductDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildProductEntity((ProductDTO)iterator.next()));
		}
		return listReturn;
	}
	public ProductEntity buildProductEntity(ProductDTO dto) {
		ProductEntity entity = (ProductEntity)DtoEntityUtil.initEntity(new ProductEntity());
		entity.setCode(dto.getCode());
		entity.setDescription(dto.getDescription());
		
		entity.setIsActive(dto.getIsActive());
		entity.setName(dto.getName());
		entity.setSortKey(dto.getSortKey());
		return entity;
	}
}
