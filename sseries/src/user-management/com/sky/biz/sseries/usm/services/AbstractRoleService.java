
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


public class AbstractRoleService extends UsmService implements ISSeriesServices{

	public RoleDTO loadById(Long id){
		return buildRoleDTO(roleRepository.findOne(id));

	}

	public PageDTOUtil<RoleDTO> loadData(int first, int pageSize,Map criteriaMap){
		List<RoleDTO> dtoList = new ArrayList<RoleDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<RoleEntity> entityPage = roleRepository.findByCompCode("FCNF",pageRequest);
		dtoList = AbstractRoleService.buildRoleDTO(entityPage.getContent());
		PageDTOUtil<RoleDTO> pageDTO = new PageDTOUtil<RoleDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}
	
	public PageDTOUtil<RoleDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);		
	}

	public void save(RoleDTO dto) throws Exception{

		RoleEntity entity = this.buildRoleEntity(dto);

		roleRepository.save(entity);

	}
	public static RoleDTO buildRoleDTO(RoleEntity entity){
		if(entity == null)
			return null;
		RoleDTO dto = null;
		dto = new RoleDTO();
		dto.setName(entity.getName());
		dto.setId(entity.getId());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<RoleDTO> buildRoleDTO(List<RoleEntity> entities){
		List<RoleDTO> listReturn = new ArrayList<RoleDTO>();
		Iterator<RoleEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
		listReturn.add(AbstractRoleService.buildRoleDTO((RoleEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<RoleEntity> buildRoleEntity(List<RoleDTO> dtoList){ 
		List<RoleEntity> listReturn = new ArrayList<RoleEntity>();
		Iterator<RoleDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRoleEntity((RoleDTO)iterator.next()));
		}
		return listReturn;
	}
	public RoleEntity buildRoleEntity(RoleDTO dto) {
		RoleEntity entity = (RoleEntity)DtoEntityUtil.initEntity(new RoleEntity());
		entity.setName(dto.getName());
		
		return entity;
	}
}
