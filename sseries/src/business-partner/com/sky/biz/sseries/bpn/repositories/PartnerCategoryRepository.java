package com.sky.biz.sseries.bpn.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.bpn.entity.PartnerCategoryEntity;

public interface PartnerCategoryRepository extends PagingAndSortingRepository<PartnerCategoryEntity, Long>,JpaSpecificationExecutor<PartnerCategoryEntity>{

	public Page<PartnerCategoryEntity> findByCompCode(String compCode,Pageable pageRequest);
	public PartnerCategoryEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
}
