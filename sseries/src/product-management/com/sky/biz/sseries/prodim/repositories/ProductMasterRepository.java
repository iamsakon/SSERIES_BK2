/**
 * 
 */
package com.sky.biz.sseries.prodim.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.prodim.entity.ProductMasterEntity;


/**
 * @author User
 *
 */
public interface ProductMasterRepository extends
PagingAndSortingRepository<ProductMasterEntity, Long>,
JpaSpecificationExecutor<ProductMasterEntity>{
	@Deprecated
	public Page<ProductMasterEntity> findAll(Pageable pageRequest);
	
	public Page<ProductMasterEntity> findByCompCode(Pageable pageRequest,String compCode);
	
	public ProductMasterEntity findByCompCodeAndCodeAndIsActive(String compCode,String code,boolean isActive);
	
	//public Page<ProductMasterEntity> findByCode(String code);
	
}
