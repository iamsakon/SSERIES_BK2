package com.sky.biz.sseries.ssd.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.ssd.entity.ModuleEntity;
import java.util.List;

public interface ModuleRepository extends PagingAndSortingRepository<ModuleEntity, Long>,JpaSpecificationExecutor<ModuleEntity>{

	public Page<ModuleEntity> findByCompCode(String compCode,Pageable pageRequest);
	public ModuleEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
	public List<ModuleEntity> findByCompCodeAndIsActiveAndMarkDelete(String compCode,boolean isActive,boolean markDelete);
}
