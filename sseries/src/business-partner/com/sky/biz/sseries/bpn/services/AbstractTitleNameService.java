package com.sky.biz.sseries.bpn.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.util.*;
import com.sky.biz.sseries.bpn.dto.*;
import com.sky.biz.sseries.bpn.entity.*;
import com.sky.biz.sseries.bpn.specification.*;

import java.util.*;
public class AbstractTitleNameService extends BpnService implements ISSeriesServices{

	@Override
	public TitleNameDTO loadById(Long id){
		return buildTitleNameDTO(titleNameRepository.findOne(id));

	}

	@Override
	public PageDTOUtil<TitleNameDTO> loadData(int first, int pageSize, Map criteriaMap){
		List<TitleNameDTO> dtoList = new ArrayList<TitleNameDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest(first,pageSize);
		Page<TitleNameEntity> entityPage =  titleNameRepository.findAll(TitleNameSpecification.basicCriteria(criteriaMap),pageRequest);
		dtoList =  AbstractTitleNameService.buildTitleNameDTO(entityPage.getContent());
		PageDTOUtil<TitleNameDTO> pageDTO = new PageDTOUtil<TitleNameDTO>(entityPage.getTotalPages(),entityPage.getTotalElements(),dtoList);
		return pageDTO;
	}

	@Override

	@SuppressWarnings("unchecked")
	public PageDTOUtil<TitleNameDTO> loadData(int first, int pageSize){

		return this.loadData(first,pageSize,null);
	}

	public TitleNameDTO saveNew(TitleNameDTO dto) throws Exception{

		TitleNameEntity entity = this.buildTitleNameEntity(dto);

		entity.setCreatedBy(-9999L);

		entity.setCreatedDate(Calendar.getInstance());

		entity.setVersion(0);

		entity.setCompCode("FCNF");

		entity =  titleNameRepository.save(entity);

		return buildTitleNameDTO(entity);

	}

	public TitleNameDTO update(TitleNameDTO dto) throws Exception{

		TitleNameEntity entity = this.buildTitleNameEntity(dto);

		entity.setId(dto.getId());

		entity.setUpdatedBy(-9999L);

		entity.setCompCode("FCNF");

		entity.setUpdatedDate(Calendar.getInstance());

		entity =  titleNameRepository.save(entity);

		return buildTitleNameDTO(entity);

	}

	public void delete(TitleNameDTO dto) throws Exception{

		TitleNameEntity entity = titleNameRepository.findByCompCodeAndIdAndMarkDelete("FCNF",dto.getId(),false);

		entity.setMarkDelete(true);

		titleNameRepository.save(entity);

		dto = buildTitleNameDTO(entity);

	}
	public static TitleNameDTO buildTitleNameDTO(TitleNameEntity entity){
		if(entity == null)
			return null;
		TitleNameDTO dto = null;
		dto = new TitleNameDTO();
		dto.setIsActive(entity.getIsActive());
		dto.setName(entity.getName());
		dto.setAbbrname(entity.getAbbrname());
		dto.setDescription(entity.getDescription());
		dto.setId(entity.getId());
		EntityDtoUtil.getAbstractDTO(entity,dto);
		return dto;

	}
	public static List<TitleNameDTO> buildTitleNameDTO(List<TitleNameEntity> entities){
		List<TitleNameDTO> listReturn = new ArrayList<TitleNameDTO>();
		Iterator<TitleNameEntity> iterator = entities.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildTitleNameDTO((TitleNameEntity)iterator.next()));
		}
		return listReturn;
		}
	public List<TitleNameEntity> buildTitleNameEntity(List<TitleNameDTO> dtoList){ 
		List<TitleNameEntity> listReturn = new ArrayList<TitleNameEntity>();
		Iterator<TitleNameDTO> iterator = dtoList.iterator();
		while(iterator.hasNext()){
			listReturn.add(buildTitleNameEntity((TitleNameDTO)iterator.next()));
		}
		return listReturn;
	}
	public TitleNameEntity buildTitleNameEntity(TitleNameDTO dto) {
		TitleNameEntity entity = (TitleNameEntity)DtoEntityUtil.initEntity(new TitleNameEntity());
		entity.setIsActive(dto.getIsActive());
		entity.setName(dto.getName());
		entity.setAbbrname(dto.getAbbrname());
		entity.setDescription(dto.getDescription());
		
		return entity;
	}
}
