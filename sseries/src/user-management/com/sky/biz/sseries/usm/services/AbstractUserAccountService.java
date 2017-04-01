
package com.sky.biz.sseries.usm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.usm.repositories.*;
import com.sky.biz.sseries.usm.services.UsmService;
import com.sky.biz.sseries.usm.specification.UserAccountSpecifications;
import com.sky.biz.sseries.dto.AbstractDTO;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.usm.dto.*;
import com.sky.biz.sseries.usm.entity.*;

import java.util.*;

public class AbstractUserAccountService extends UsmService implements ISSeriesServices{

	@Override
	@SuppressWarnings("unchecked")
	public UserAccountDTO loadById(Long id){
		return buildUserAccountDTO(userAccountRepository.findOne(id));
	}
	
	@Override
	public PageDTOUtil loadData(int first, int pageSize, Map criteriaMap) {
		List<UserAccountDTO> dtoList = new ArrayList<UserAccountDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<UserAccountEntity> entityPage =  userAccountRepository.findAll(UserAccountSpecifications.basicCriteria(criteriaMap),pageRequest);
		//Page<UserAccountEntity> entityPage = userAccountRepository.findByCompCode("FCNF",pageRequest);
		dtoList = AbstractUserAccountService.buildUserAccountDTO(entityPage.getContent());
		PageDTOUtil<UserAccountDTO> pageDTO = new PageDTOUtil<UserAccountDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageDTOUtil<UserAccountDTO> loadData(int first, int pageSize){
		return this.loadData(first,pageSize,null);
	}

	public void save(UserAccountDTO dto) throws Exception{

		UserAccountEntity entity = this.buildUserAccountEntity(dto);

		userAccountRepository.save(entity);

	}
	public static UserAccountDTO buildUserAccountDTO(UserAccountEntity entity){
		if(entity == null)
			return null;
		UserAccountDTO dto = null;
		dto = new UserAccountDTO();
		dto.setId(entity.getId());
		dto.setEnabled(entity.getEnabled());
		dto.setPassword(entity.getPassword());
		dto.setUsername(entity.getUsername());
		dto.setValidStart(entity.getValidStart());
		dto.setValidEnd(entity.getValidEnd());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<UserAccountDTO> buildUserAccountDTO(List<UserAccountEntity> entities){
		List<UserAccountDTO> listReturn = new ArrayList<UserAccountDTO>();
		Iterator<UserAccountEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
		listReturn.add(AbstractUserAccountService.buildUserAccountDTO((UserAccountEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<UserAccountEntity> buildUserAccountEntity(List<UserAccountDTO> dtoList){ 
		List<UserAccountEntity> listReturn = new ArrayList<UserAccountEntity>();
		Iterator<UserAccountDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildUserAccountEntity((UserAccountDTO)iterator.next()));
		}
		return listReturn;
	}
	public UserAccountEntity buildUserAccountEntity(UserAccountDTO dto) {
		UserAccountEntity entity = (UserAccountEntity)DtoEntityUtil.initEntity(new UserAccountEntity());
		
		entity.setEnabled(dto.getEnabled());
		entity.setPassword(dto.getPassword());
		entity.setUsername(dto.getUsername());
		entity.setValidStart(dto.getValidStart());
		entity.setValidEnd(dto.getValidEnd());
		return entity;
	}

}
