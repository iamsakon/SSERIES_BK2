package com.sky.biz.sseries.prodim.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sky.biz.sseries.prodim.entity.ProductCategoryEntity;

public interface ProductCategoryRepository  extends
PagingAndSortingRepository<ProductCategoryEntity, Long>,
JpaSpecificationExecutor<ProductCategoryEntity>{

}
