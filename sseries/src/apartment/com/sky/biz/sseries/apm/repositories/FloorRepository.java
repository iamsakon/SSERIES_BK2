package com.sky.biz.sseries.apm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sky.biz.sseries.apm.entity.FloorEntity;
import java.util.List;

public interface FloorRepository extends PagingAndSortingRepository<FloorEntity, Long>,JpaSpecificationExecutor<FloorEntity>{

	public Page<FloorEntity> findByCompCode(String compCode,Pageable pageRequest);
	public FloorEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
	public List<FloorEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);
	public FloorEntity findByCompCodeAndMarkDeleteAndCode(String compCode,boolean markDelete,String code);
}
