
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

public class AbstractUserAccountRoleService extends UsmService implements ISSeriesServices{

	public UserAccountRoleDTO loadById(Long id){
		return buildUserAccountRoleDTO(userAccountRoleRepository.findOne(id));

	}
	@Override
	public PageDTOUtil<UserAccountRoleDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<UserAccountRoleDTO> dtoList = new ArrayList<UserAccountRoleDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<UserAccountRoleEntity> entityPage = userAccountRoleRepository.findByCompCode("FCNF",pageRequest);
		dtoList = AbstractUserAccountRoleService.buildUserAccountRoleDTO(entityPage.getContent());
		PageDTOUtil<UserAccountRoleDTO> pageDTO = new PageDTOUtil<UserAccountRoleDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}
	@Override
	public PageDTOUtil<UserAccountRoleDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}

	public void save(UserAccountRoleDTO dto) throws Exception{

		UserAccountRoleEntity entity = this.buildUserAccountRoleEntity(dto);

		userAccountRoleRepository.save(entity);

	}
	public static UserAccountRoleDTO buildUserAccountRoleDTO(UserAccountRoleEntity entity){
		if(entity == null)
			return null;
		UserAccountRoleDTO dto = null;
		dto = new UserAccountRoleDTO();
		dto.setActiveFlag(entity.getActiveFlag());
		dto.setDeleteFlag(entity.getDeleteFlag());
		dto.setId(entity.getId());
		dto.setEffectiveStart(entity.getEffectiveStart());
		dto.setEffectiveEnd(entity.getEffectiveEnd());
		dto.setUserAccount(AbstractUserAccountService.buildUserAccountDTO(entity.getUserAccount()));
		dto.setRole(AbstractRoleService.buildRoleDTO(entity.getRole()));
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<UserAccountRoleDTO> buildUserAccountRoleDTO(List<UserAccountRoleEntity> entities){
		List<UserAccountRoleDTO> listReturn = new ArrayList<UserAccountRoleDTO>();
		Iterator<UserAccountRoleEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
		listReturn.add(AbstractUserAccountRoleService.buildUserAccountRoleDTO((UserAccountRoleEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<UserAccountRoleEntity> buildUserAccountRoleEntity(List<UserAccountRoleDTO> dtoList){ 
		List<UserAccountRoleEntity> listReturn = new ArrayList<UserAccountRoleEntity>();
		Iterator<UserAccountRoleDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildUserAccountRoleEntity((UserAccountRoleDTO)iterator.next()));
		}
		return listReturn;
	}
	public UserAccountRoleEntity buildUserAccountRoleEntity(UserAccountRoleDTO dto) {
		UserAccountRoleEntity entity = (UserAccountRoleEntity)DtoEntityUtil.initEntity(new UserAccountRoleEntity());
		entity.setActiveFlag(dto.getActiveFlag());
		entity.setDeleteFlag(dto.getDeleteFlag());
		
		entity.setEffectiveStart(dto.getEffectiveStart());
		entity.setEffectiveEnd(dto.getEffectiveEnd());
		if(dto.getUserAccount() != null && dto.getUserAccount().getId() !=null)
		 entity.setUserAccount(userAccountRepository.findOne(dto.getId()));
		if(dto.getRole() != null && dto.getRole().getId() !=null)
		 entity.setRole(roleRepository.findOne(dto.getId()));
		return entity;
	}
}
