package com.sky.biz.sseries.prodim.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sky.biz.sseries.prodim.dto.ProductTypeDTO;
import com.sky.biz.sseries.prodim.entity.ProductTypeEntity;
import com.sky.biz.sseries.prodim.repositories.ProductTypeRepository;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.util.EntityDtoUtil;
import com.sky.biz.sseries.util.SpringDataUtil;

@Service
public class ProductTypeService implements ISSeriesServices<ProductTypeDTO> {

	@Autowired
	private ProductTypeRepository productTypeRepo;
	
	@Override
	public ProductTypeDTO loadById(Long id){
		return EntityDtoUtil.getProductTypeDTO(productTypeRepo.findOne(id));
	}
	
	
	public List<ProductTypeDTO> loadAllProductType(){
		List<ProductTypeDTO> productTypeDtos = new ArrayList<ProductTypeDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest();
		Page<ProductTypeEntity> productTypeEntities = productTypeRepo.findAll(pageRequest);
		productTypeDtos = EntityDtoUtil.getProductTypeDTO(productTypeEntities.getContent());
		return productTypeDtos;
	}


	@Override
	public List<ProductTypeDTO> loadData(int first, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(ProductTypeDTO object) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
