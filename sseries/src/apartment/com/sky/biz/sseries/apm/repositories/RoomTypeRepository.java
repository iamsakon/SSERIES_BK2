package com.sky.biz.sseries.apm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sky.biz.sseries.apm.entity.RoomStatusEntity;
import com.sky.biz.sseries.apm.entity.RoomTypeEntity;
import java.util.List;

public interface RoomTypeRepository extends PagingAndSortingRepository<RoomTypeEntity, Long>,JpaSpecificationExecutor<RoomTypeEntity>{

	public Page<RoomTypeEntity> findByCompCode(String compCode,Pageable pageRequest);
	public RoomTypeEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
	public List<RoomTypeEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);
	public RoomTypeEntity findByCompCodeAndMarkDeleteAndCode(String compCode,boolean markDelete,String code);
}
