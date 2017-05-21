package com.sky.biz.sseries.apm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sky.biz.sseries.apm.entity.RoomPriceMasterEntity;
import java.util.List;

public interface RoomPriceMasterRepository extends PagingAndSortingRepository<RoomPriceMasterEntity, Long>,JpaSpecificationExecutor<RoomPriceMasterEntity>{

	public Page<RoomPriceMasterEntity> findByCompCode(String compCode,Pageable pageRequest);
	public RoomPriceMasterEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
	public List<RoomPriceMasterEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);
	public RoomPriceMasterEntity findByCompCodeAndMarkDeleteAndCode(String compCode,boolean markDelete,String code);
}
