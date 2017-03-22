
package com.sky.biz.sseries.usm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.usm.entity.UserAccountEntity;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccountEntity, Long>,JpaSpecificationExecutor<UserAccountEntity>{

	public Page<UserAccountEntity> findByCompCode(String compCode,Pageable pageRequest);
}
