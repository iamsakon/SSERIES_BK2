package com.sky.biz.sseries.bpn.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.bpn.entity.CorporateTypeEntity;

public interface CorporateTypeRepository extends PagingAndSortingRepository<CorporateTypeEntity, Long>,JpaSpecificationExecutor<CorporateTypeEntity>{

	public Page<CorporateTypeEntity> findByCompCode(String compCode,Pageable pageRequest);
	public CorporateTypeEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
}
