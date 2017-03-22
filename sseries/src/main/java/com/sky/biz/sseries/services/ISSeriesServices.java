package com.sky.biz.sseries.services;

import java.util.Map;

import com.sky.biz.sseries.dto.AbstractDTO;
import com.sky.biz.sseries.util.PageDTOUtil;

public interface ISSeriesServices<T> {

	public AbstractDTO loadById(Long id);
	
	public PageDTOUtil<T> loadData(int first,int pageSize);
	
	public PageDTOUtil<T> loadData(int first,int pageSize,Map<String, Object> criteriaMap);
	
}
