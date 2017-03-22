
package com.sky.biz.sseries.usm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.usm.entity.RoleEntity;

public interface RoleRepository extends PagingAndSortingRepository<RoleEntity, Long>,JpaSpecificationExecutor<RoleEntity>{

	public Page<RoleEntity> findByCompCode(String compCode,Pageable pageRequest);
}
