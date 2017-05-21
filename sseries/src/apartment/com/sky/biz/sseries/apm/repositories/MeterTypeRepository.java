package com.sky.biz.sseries.apm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sky.biz.sseries.apm.entity.MeterTypeEntity;
import java.util.List;

public interface MeterTypeRepository extends PagingAndSortingRepository<MeterTypeEntity, Long>,JpaSpecificationExecutor<MeterTypeEntity>{

	public Page<MeterTypeEntity> findByCompCode(String compCode,Pageable pageRequest);
	public MeterTypeEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
	public List<MeterTypeEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);
	public MeterTypeEntity findByCompCodeAndMarkDeleteAndCode(String compCode,boolean markDelete,String code);
}
