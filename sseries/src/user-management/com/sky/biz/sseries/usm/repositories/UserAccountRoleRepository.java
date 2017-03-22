
package com.sky.biz.sseries.usm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.usm.entity.UserAccountRoleEntity;

public interface UserAccountRoleRepository extends PagingAndSortingRepository<UserAccountRoleEntity, Long>,JpaSpecificationExecutor<UserAccountRoleEntity>{

	public Page<UserAccountRoleEntity> findByCompCode(String compCode,Pageable pageRequest);
}
