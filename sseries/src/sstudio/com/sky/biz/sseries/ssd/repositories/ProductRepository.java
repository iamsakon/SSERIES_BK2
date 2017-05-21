package com.sky.biz.sseries.ssd.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.ssd.entity.ProductEntity;
import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Long>,JpaSpecificationExecutor<ProductEntity>{

	public Page<ProductEntity> findByCompCode(String compCode,Pageable pageRequest);
	public ProductEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
	public List<ProductEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);
}
