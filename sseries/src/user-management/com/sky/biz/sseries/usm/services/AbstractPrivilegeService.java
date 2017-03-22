
package com.sky.biz.sseries.usm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.usm.util.*;
import com.sky.biz.sseries.usm.repositories.*;
import com.sky.biz.sseries.usm.dto.*;
import com.sky.biz.sseries.usm.entity.*;
import com.sky.biz.sseries.usm.services.*;

import java.util.*;


public class AbstractPrivilegeService extends UsmService implements ISSeriesServices{

	public PrivilegeDTO loadById(Long id){
		return buildPrivilegeDTO(privilegeRepository.findOne(id));

	}

	public PageDTOUtil<PrivilegeDTO> loadData(int first, int pageSize,Map criteriaMap){
		List<PrivilegeDTO> dtoList = new ArrayList<PrivilegeDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<PrivilegeEntity> entityPage = privilegeRepository.findByCompCode("FCNF",pageRequest);
		dtoList = AbstractPrivilegeService.buildPrivilegeDTO(entityPage.getContent());
		PageDTOUtil<PrivilegeDTO> pageDTO = new PageDTOUtil<PrivilegeDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}
	
	public PageDTOUtil<PrivilegeDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}

	public void save(PrivilegeDTO dto) throws Exception{

		PrivilegeEntity entity = this.buildPrivilegeEntity(dto);

		privilegeRepository.save(entity);

	}
	public static PrivilegeDTO buildPrivilegeDTO(PrivilegeEntity entity){
		if(entity == null)
			return null;
		PrivilegeDTO dto = null;
		dto = new PrivilegeDTO();
		dto.setActiveFlag(entity.getActiveFlag());
		dto.setDeleteFlag(entity.getDeleteFlag());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<PrivilegeDTO> buildPrivilegeDTO(List<PrivilegeEntity> entities){
		List<PrivilegeDTO> listReturn = new ArrayList<PrivilegeDTO>();
		Iterator<PrivilegeEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
		listReturn.add(AbstractPrivilegeService.buildPrivilegeDTO((PrivilegeEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<PrivilegeEntity> buildPrivilegeEntity(List<PrivilegeDTO> dtoList){ 
		List<PrivilegeEntity> listReturn = new ArrayList<PrivilegeEntity>();
		Iterator<PrivilegeDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildPrivilegeEntity((PrivilegeDTO)iterator.next()));
		}
		return listReturn;
	}
	public PrivilegeEntity buildPrivilegeEntity(PrivilegeDTO dto) {
		PrivilegeEntity entity = (PrivilegeEntity)DtoEntityUtil.initEntity(new PrivilegeEntity());
		entity.setActiveFlag(dto.getActiveFlag());
		entity.setDeleteFlag(dto.getDeleteFlag());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		return entity;
	}
}
