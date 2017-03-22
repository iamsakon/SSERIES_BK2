package com.sky.biz.sseries.prodim.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sky.biz.sseries.prodim.entity.UomEntity;

public interface UomRepository extends PagingAndSortingRepository<UomEntity, Long> {
	public Page<UomEntity> findAll(Pageable pageRequest);
}
