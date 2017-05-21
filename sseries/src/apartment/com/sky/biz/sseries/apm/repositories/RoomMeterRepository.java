package com.sky.biz.sseries.apm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sky.biz.sseries.apm.entity.RoomMeterEntity;
import java.util.List;

public interface RoomMeterRepository extends PagingAndSortingRepository<RoomMeterEntity, Long>,JpaSpecificationExecutor<RoomMeterEntity>{

	public Page<RoomMeterEntity> findByCompCode(String compCode,Pageable pageRequest);
	public RoomMeterEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
	public List<RoomMeterEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);
	public RoomMeterEntity findByCompCodeAndMarkDeleteAndCode(String compCode,boolean markDelete,String code);
}
