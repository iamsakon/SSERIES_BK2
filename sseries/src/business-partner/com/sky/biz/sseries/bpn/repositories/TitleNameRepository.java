package com.sky.biz.sseries.bpn.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.bpn.entity.TitleNameEntity;

public interface TitleNameRepository extends PagingAndSortingRepository<TitleNameEntity, Long>,JpaSpecificationExecutor<TitleNameEntity>{

	public Page<TitleNameEntity> findByCompCode(String compCode,Pageable pageRequest);
	public TitleNameEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
}
