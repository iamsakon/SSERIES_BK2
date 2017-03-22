
package com.sky.biz.sseries.bpn.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.bpn.entity.BusinessPartnerGroupEntity;

public interface BusinessPartnerGroupRepository extends PagingAndSortingRepository<BusinessPartnerGroupEntity, Long>,JpaSpecificationExecutor<BusinessPartnerGroupEntity>{

	public Page<BusinessPartnerGroupEntity> findByCompCode(String compCode,Pageable pageRequest);
	
	public BusinessPartnerGroupEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
}
