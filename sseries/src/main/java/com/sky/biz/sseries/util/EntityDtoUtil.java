package com.sky.biz.sseries.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sky.biz.sseries.dto.AbstractDTO;
import com.sky.biz.sseries.entity.AbstractEntity;
import com.sky.biz.sseries.prodim.dto.AbstractProdimDTO;
import com.sky.biz.sseries.prodim.dto.ProductCategoryDTO;
import com.sky.biz.sseries.prodim.dto.ProductMasterDTO;
import com.sky.biz.sseries.prodim.dto.ProductTypeDTO;
import com.sky.biz.sseries.prodim.dto.UomDTO;
import com.sky.biz.sseries.prodim.entity.AbstractProdimEntity;
import com.sky.biz.sseries.prodim.entity.ProductCategoryEntity;
import com.sky.biz.sseries.prodim.entity.ProductMasterEntity;
import com.sky.biz.sseries.prodim.entity.ProductTypeEntity;
import com.sky.biz.sseries.prodim.entity.UomEntity;

public abstract class EntityDtoUtil {

	public static void getAbstractDTO(AbstractEntity entity,AbstractDTO dto){
		if(entity != null && dto != null){
			//TODO Map from entity to dto
		}
	}
	
	public static void getAbstractProdimDTO(AbstractProdimEntity entity,AbstractProdimDTO dto){
		if(entity != null && dto != null){
			//TODO Map from entity to dto
			EntityDtoUtil.getAbstractDTO(entity, dto);
		}
	}
	
}
