package com.sky.biz.sseries.prodim.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sky.biz.sseries.prodim.dto.ProductTypeDTO;
import com.sky.biz.sseries.prodim.dto.UomDTO;
import com.sky.biz.sseries.prodim.entity.UomEntity;
import com.sky.biz.sseries.prodim.repositories.UomRepository;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.util.EntityDtoUtil;
import com.sky.biz.sseries.util.SpringDataUtil;

import java.util.List;
import java.util.ArrayList;

@Service
public class UomService implements ISSeriesServices<UomDTO>  {

	@Autowired
	private UomRepository uomRepo;
	
	@Override
	public UomDTO loadById(Long id){
		return EntityDtoUtil.getUOMDTO(uomRepo.findOne(id));
	}
	
	public List<UomDTO> loadAllUom(){
		List<UomDTO> uomDtos = new ArrayList<UomDTO>();
		Pageable pageRequest = SpringDataUtil.createPageRequest();
		Page<UomEntity> uomEntities = uomRepo.findAll(pageRequest);
		uomDtos = EntityDtoUtil.getUOMDTO(uomEntities.getContent());
		return uomDtos;
	}

	@Override
	public List<UomDTO> loadData(int first, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UomDTO object) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
