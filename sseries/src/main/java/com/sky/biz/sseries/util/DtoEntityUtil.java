package com.sky.biz.sseries.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.sky.biz.sseries.entity.AbstractEntity;
import com.sky.biz.sseries.usm.dto.UserAccountDTO;
import java.util.*;

public class DtoEntityUtil {
	
	public static AbstractEntity initEntity(AbstractEntity entity) {
		//TODO 
		//UserAccountDTO userDto = (UserAccountDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		entity.setActive(true);
//		entity.setMarkDelete(false);
//		entity.setVersion(0);
		//entity.setCompCode(userDto.getCompCode());
		//entity.setCreatedBy(-9999L);
		//entity.setCreatedDate(Calendar.getInstance());
//		entity.setCompCode("FCNF");
		return entity;
	}

	
}
