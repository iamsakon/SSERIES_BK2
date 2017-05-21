package com.sky.biz.sseries.apm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.apm.entity.RoomEntity;
import com.sky.biz.sseries.apm.entity.RoomPriceMasterEntity;

import java.util.List;

public interface RoomRepository extends PagingAndSortingRepository<RoomEntity, Long>,JpaSpecificationExecutor<RoomEntity>{

	public Page<RoomEntity> findByCompCode(String compCode,Pageable pageRequest);
	public RoomEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
	public List<RoomEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);
	public RoomEntity findByCompCodeAndMarkDeleteAndCode(String compCode,boolean markDelete,String code);
	
}
