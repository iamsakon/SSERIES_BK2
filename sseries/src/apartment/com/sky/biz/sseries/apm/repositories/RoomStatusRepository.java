package com.sky.biz.sseries.apm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sky.biz.sseries.apm.entity.RoomEntity;
import com.sky.biz.sseries.apm.entity.RoomStatusEntity;
import java.util.List;

public interface RoomStatusRepository extends PagingAndSortingRepository<RoomStatusEntity, Long>,JpaSpecificationExecutor<RoomStatusEntity>{

	public Page<RoomStatusEntity> findByCompCode(String compCode,Pageable pageRequest);
	public RoomStatusEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
	public List<RoomStatusEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);
	public List<RoomStatusEntity> findByCompCodeAndIsActiveAndMarkDeleteAndDefaultStatus(String compCode,boolean isActive,boolean markDelete,boolean defaultStatus);
	public RoomStatusEntity findByCompCodeAndMarkDeleteAndCode(String compCode,boolean markDelete,String code);
}
