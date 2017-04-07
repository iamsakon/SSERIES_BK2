package com.sky.biz.sseries.bpn.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sky.biz.sseries.bpn.entity.AddressTypeEntity;

public interface AddressTypeRepository extends PagingAndSortingRepository<AddressTypeEntity, Long>,JpaSpecificationExecutor<AddressTypeEntity>{

	public Page<AddressTypeEntity> findByCompCode(String compCode,Pageable pageRequest);
	public AddressTypeEntity findByCompCodeAndIdAndMarkDelete(String compCode,Long id,boolean markDelete);
}
