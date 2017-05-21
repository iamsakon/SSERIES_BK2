package com.sky.biz.sseries.ssd.specification;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.Map;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;
import com.sky.biz.sseries.ssd.dto.*;
import com.sky.biz.sseries.ssd.entity.*;
import com.sky.biz.sseries.util.SpecificationsUtil;
public class AbstractModuleSpecification{
	public static Specification<ModuleEntity> basicCriteria(Map<String,Object> criteriaMap){
		return new Specification<ModuleEntity>() {
			public Predicate toPredicate(Root<ModuleEntity> root,CriteriaQuery<?> query,CriteriaBuilder cb){
				ModuleDTO dto = null;
				Predicate p1 = cb.equal(root.get("markDelete"), false);
				if(criteriaMap != null)
					dto = (ModuleDTO)criteriaMap.get(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP);
				if(dto!=null){
		
					if(SpecificationsUtil.isNotEmpty(dto.getCode())){
						p1 = cb.and(cb.like(root.get("code"),SpecificationsUtil.getLikePattern(dto.getCode(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);
					}
		
					if(SpecificationsUtil.isNotEmpty(dto.getDescription())){
						p1 = cb.and(cb.like(root.get("description"),SpecificationsUtil.getLikePattern(dto.getDescription(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);
					}
		
		
					if(SpecificationsUtil.isNotEmpty(dto.getIsActive())){
						p1 = cb.and(cb.equal(root.get("isActive"),dto.getIsActive()),p1);
					}
		
					if(SpecificationsUtil.isNotEmpty(dto.getName())){
						p1 = cb.and(cb.like(root.get("name"),SpecificationsUtil.getLikePattern(dto.getName(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);
					}
		
					if(SpecificationsUtil.isNotEmpty(dto.getSortKey())){
						p1 = cb.and(cb.equal(root.get("sortKey"),dto.getSortKey()),p1);
					}
				}
				return p1;
			}
		};
	}
}
