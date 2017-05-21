package com.sky.biz.sseries.apm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.apm.entity.BuildingEntity;
import java.util.List;

public interface BuildingRepository extends PagingAndSortingRepository<BuildingEntity, Long>,JpaSpecificationExecutor<BuildingEntity>{

	public Page<BuildingEntity> findByCompCode(String compCode,Pageable pageRequest);
	public BuildingEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
	public List<BuildingEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);
	public BuildingEntity findByCompCodeAndMarkDeleteAndCode(String compCode,boolean markDelete,String code);
}
