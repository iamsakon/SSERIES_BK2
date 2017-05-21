package com.sky.biz.sseries.apm.specification;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.Map;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;
import com.sky.biz.sseries.apm.dto.*;
import com.sky.biz.sseries.apm.entity.*;

import com.sky.biz.sseries.util.SpecificationsUtil;
public class AbstractBuildingSpecification{
	public static Specification<BuildingEntity> basicCriteria(Map<String,Object> criteriaMap){
		return new Specification<BuildingEntity>() {
			public Predicate toPredicate(Root<BuildingEntity> root,CriteriaQuery<?> query,CriteriaBuilder cb){
				BuildingDTO dto = null;
				Predicate p1 = cb.equal(root.get("markDelete"), false);
				if(criteriaMap != null)
					dto = (BuildingDTO)criteriaMap.get(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP);
				if(dto!=null){
		
					if(SpecificationsUtil.isNotEmpty(dto.getIsActive())){
						p1 = cb.and(cb.equal(root.get("isActive"),dto.getIsActive()),p1);
					}
		
					if(SpecificationsUtil.isNotEmpty(dto.getCode())){
						p1 = cb.and(cb.like(root.get("code"),SpecificationsUtil.getLikePattern(dto.getCode(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);
					}
		
					if(SpecificationsUtil.isNotEmpty(dto.getName())){
						p1 = cb.and(cb.like(root.get("name"),SpecificationsUtil.getLikePattern(dto.getName(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);
					}
		
					if(SpecificationsUtil.isNotEmpty(dto.getDescription())){
						p1 = cb.and(cb.like(root.get("description"),SpecificationsUtil.getLikePattern(dto.getDescription(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);
					}
		
				}
				return p1;
			}
		};
	}
}