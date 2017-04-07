package com.sky.biz.sseries.bpn.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.bpn.entity.PartnerGroupEntity;

public interface PartnerGroupRepository extends PagingAndSortingRepository<PartnerGroupEntity, Long>,JpaSpecificationExecutor<PartnerGroupEntity>{

	public Page<PartnerGroupEntity> findByCompCode(String compCode,Pageable pageRequest);
	public PartnerGroupEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
}
