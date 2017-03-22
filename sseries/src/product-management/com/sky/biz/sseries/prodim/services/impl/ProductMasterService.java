/**
 * 
 */
package com.sky.biz.sseries.prodim.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sky.biz.sseries.dto.AbstractDTO;
import com.sky.biz.sseries.prodim.dto.ProductMasterDTO;
import com.sky.biz.sseries.prodim.entity.ProductMasterEntity;
import com.sky.biz.sseries.prodim.entity.UomEntity;
import com.sky.biz.sseries.prodim.repositories.ProductCategoryRepository;
import com.sky.biz.sseries.prodim.repositories.ProductMasterRepository;
import com.sky.biz.sseries.prodim.repositories.ProductTypeRepository;
import com.sky.biz.sseries.prodim.repositories.UomRepository;
import com.sky.biz.sseries.util.DtoEntityUtil;
import com.sky.biz.sseries.util.EntityDtoUtil;
import com.sky.biz.sseries.util.SpringDataUtil;
import com.sky.biz.sseries.prodim.util.*;
import com.sky.biz.sseries.services.ISSeriesServices;
/**
 * @author User
 *
 */
@Service
public class ProductMasterService<T> implements ISSeriesServices<T>{

	@Autowired
	private ProductMasterRepository productMasterRepo;
	@Autowired
	ProductTypeRepository productTypeRepo;
	@Autowired
	UomRepository uomRepo;
	@Autowired
	ProductCategoryRepository productCategoryRepo;
	
	@Override
	public ProductMasterDTO loadById(Long id){
		return buildProductMasterDTO(productMasterRepo.findOne(id));
	}
	
	@Override
	public List<T> loadData(int first,int pageSize){
		List<ProductMasterDTO> productMasterDtos = new ArrayList<ProductMasterDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<ProductMasterEntity> productMasterEntities = productMasterRepo.findByCompCode(pageRequest,"FCNF");
		productMasterDtos = EntityDtoUtil.getProductMasterDTO(productMasterEntities.getContent());
		return (List<T>) productMasterDtos;
	}
//	@Deprecated
//	public List<ProductMasterDTO> loadAllProduct(){
//		List<ProductMasterDTO> productMasterDtos = new ArrayList<ProductMasterDTO>();
//		Pageable pageRequest = SpringDataUtil.createPageRequest();
//		Page<ProductMasterEntity> productMasterEntities = productMasterRepo.findByCompCode(pageRequest,"FCNF");
//		productMasterDtos = EntityDtoUtil.getProductMasterDTO(productMasterEntities.getContent());
//		return productMasterDtos;
//	}
//	
//	@Deprecated
//	public List<ProductMasterDTO> loadAllProduct(int first, int pageSize){
//		List<ProductMasterDTO> productMasterDtos = new ArrayList<ProductMasterDTO>();
//		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
//		Page<ProductMasterEntity> productMasterEntities = productMasterRepo.findByCompCode(pageRequest,"FCNF");
//		productMasterDtos = EntityDtoUtil.getProductMasterDTO(productMasterEntities.getContent());
//		return productMasterDtos;
//	}
	
	@Override
	public void save(T object) throws Exception {
		this.saveProduct((ProductMasterDTO)object);		
	}
	
	public void saveProduct(ProductMasterDTO dto) throws Exception{
		//TODO Check duplicate before save ==> check by code and compCode
		ProductMasterEntity checkProductMaster = productMasterRepo.findByCompCodeAndCodeAndIsActive("FCNF", dto.getCode(), true);
		if(checkProductMaster == null){
			ProductMasterEntity entity = this.buildProductMasterEntity(dto);
			productMasterRepo.save(entity);
		}else{
			throw new Exception("Product Code is already exists");
		}
	}
	
	public List<ProductMasterEntity> buildProductMasterDTO(List<ProductMasterDTO> dtoList){
		List<ProductMasterEntity> listReturn = new ArrayList<ProductMasterEntity>();
		Iterator<ProductMasterDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildProductMasterEntity((ProductMasterDTO)iterator.next()));			
		}
		return listReturn;
	}
	
	public static ProductMasterDTO buildProductMasterDTO(ProductMasterEntity entity){
		if(entity == null)
			return null;
		ProductMasterDTO dto = null;
		dto = new ProductMasterDTO();
		dto.setId(entity.getId());
		dto.setUom(EntityDtoUtil.getUOMDTO(entity.getDefaultUom()));
		dto.setProductType(EntityDtoUtil.getProductTypeDTO(entity.getProductType()));
		dto.setProductCategory(EntityDtoUtil.getProductCategoryDTO(entity.getProductCategory()));
		dto.setCode(entity.getCode());
		dto.setFullDescription(entity.getFullDescription());
		dto.setName(entity.getName());
		dto.setShortDescription(entity.getShortDescription());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;
	}
	
	public ProductMasterEntity buildProductMasterEntity(ProductMasterDTO dto) {
		ProductMasterEntity entity = (ProductMasterEntity) DtoEntityUtil.initEntity(new ProductMasterEntity());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setProductType(productTypeRepo.findOne(dto.getProductType().getId()));
		if(dto.getUom() != null && dto.getUom().getId()!=null)
			entity.setDefaultUom(uomRepo.findOne(dto.getUom().getId()));
		if(dto.getProductCategory() != null && dto.getProductCategory().getId() != null)
			entity.setProductCategory(productCategoryRepo.findOne(dto.getProductCategory().getId()));
		return entity;
	}

}
