
package com.sky.biz.sseries.usm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.usm.entity.PrivilegeEntity;

public interface PrivilegeRepository extends PagingAndSortingRepository<PrivilegeEntity, Long>,JpaSpecificationExecutor<PrivilegeEntity>{

	public Page<PrivilegeEntity> findByCompCode(String compCode,Pageable pageRequest);
}
