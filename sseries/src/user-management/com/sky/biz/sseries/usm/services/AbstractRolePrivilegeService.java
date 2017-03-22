
package com.sky.biz.sseries.usm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.usm.util.*;
import com.sky.biz.sseries.usm.repositories.*;
import com.sky.biz.sseries.usm.services.UsmService;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.usm.dto.*;
import com.sky.biz.sseries.usm.entity.*;

import java.util.*;

public class AbstractRolePrivilegeService extends UsmService implements ISSeriesServices{

	public RolePrivilegeDTO loadById(Long id){
		return buildRolePrivilegeDTO(rolePrivilegeRepository.findOne(id));

	}
	
	public PageDTOUtil<RolePrivilegeDTO> loadData(int first, int pageSize,Map criteriaMap){
		List<RolePrivilegeDTO> dtoList = new ArrayList<RolePrivilegeDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<RolePrivilegeEntity> entityPage = rolePrivilegeRepository.findByCompCode("FCNF",pageRequest);
		dtoList = AbstractRolePrivilegeService.buildRolePrivilegeDTO(entityPage.getContent());
		PageDTOUtil<RolePrivilegeDTO> pageDTO = new PageDTOUtil<RolePrivilegeDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	public PageDTOUtil<RolePrivilegeDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}

	public void save(RolePrivilegeDTO dto) throws Exception{

		RolePrivilegeEntity entity = this.buildRolePrivilegeEntity(dto);

		rolePrivilegeRepository.save(entity);

	}
	public static RolePrivilegeDTO buildRolePrivilegeDTO(RolePrivilegeEntity entity){
		if(entity == null)
			return null;
		RolePrivilegeDTO dto = null;
		dto = new RolePrivilegeDTO();
		dto.setActiveFlag(entity.getActiveFlag());
		dto.setDeleteFlag(entity.getDeleteFlag());
		dto.setId(entity.getId());
		dto.setEffectiveEnd(entity.getEffectiveEnd());
		dto.setEffectiveStart(entity.getEffectiveStart());
		dto.setPrivilege(AbstractPrivilegeService.buildPrivilegeDTO(entity.getPrivilege()));
		dto.setRole(AbstractRoleService.buildRoleDTO(entity.getRole()));
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<RolePrivilegeDTO> buildRolePrivilegeDTO(List<RolePrivilegeEntity> entities){
		List<RolePrivilegeDTO> listReturn = new ArrayList<RolePrivilegeDTO>();
		Iterator<RolePrivilegeEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
		listReturn.add(AbstractRolePrivilegeService.buildRolePrivilegeDTO((RolePrivilegeEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<RolePrivilegeEntity> buildRolePrivilegeEntity(List<RolePrivilegeDTO> dtoList){ 
		List<RolePrivilegeEntity> listReturn = new ArrayList<RolePrivilegeEntity>();
		Iterator<RolePrivilegeDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildRolePrivilegeEntity((RolePrivilegeDTO)iterator.next()));
		}
		return listReturn;
	}
	public RolePrivilegeEntity buildRolePrivilegeEntity(RolePrivilegeDTO dto) {
		RolePrivilegeEntity entity = (RolePrivilegeEntity)DtoEntityUtil.initEntity(new RolePrivilegeEntity());
		entity.setActiveFlag(dto.getActiveFlag());
		entity.setDeleteFlag(dto.getDeleteFlag());
		
		entity.setEffectiveEnd(dto.getEffectiveEnd());
		entity.setEffectiveStart(dto.getEffectiveStart());
		if(dto.getPrivilege() != null && dto.getPrivilege().getId() !=null)
		 entity.setPrivilege(privilegeRepository.findOne(dto.getId()));
		if(dto.getRole() != null && dto.getRole().getId() !=null)
		 entity.setRole(roleRepository.findOne(dto.getId()));
		return entity;
	}

}
