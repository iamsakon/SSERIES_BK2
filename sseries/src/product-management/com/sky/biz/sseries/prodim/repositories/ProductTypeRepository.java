package com.sky.biz.sseries.prodim.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.prodim.entity.ProductTypeEntity;

public interface ProductTypeRepository extends 
PagingAndSortingRepository<ProductTypeEntity, Long>,JpaSpecificationExecutor<ProductTypeEntity>{

	public Page<ProductTypeEntity> findAll(Pageable pageRequest);
}
