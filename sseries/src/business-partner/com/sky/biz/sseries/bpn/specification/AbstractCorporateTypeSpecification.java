package com.sky.biz.sseries.bpn.specification;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.Map;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;
import com.sky.biz.sseries.bpn.dto.*;
import com.sky.biz.sseries.bpn.entity.*;

import java.util.*;
import com.sky.biz.sseries.util.SpecificationsUtil;
public class AbstractCorporateTypeSpecification{
	public static Specification<CorporateTypeEntity> basicCriteria(Map<String,Object> criteriaMap){
		return new Specification<CorporateTypeEntity>() {
			public Predicate toPredicate(Root<CorporateTypeEntity> root,CriteriaQuery<?> query,CriteriaBuilder cb){
				CorporateTypeDTO dto = null;
				Predicate p1 = cb.equal(root.get("markDelete"), false);
				if(criteriaMap != null)
					dto = (CorporateTypeDTO)criteriaMap.get(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP);
				if(dto!=null){
		
					if(SpecificationsUtil.isNotEmpty(dto.getIsActive())){
						p1 = cb.and(cb.equal(root.get("IsActive"),dto.getIsActive()),p1);
					}
		
					if(SpecificationsUtil.isNotEmpty(dto.getName())){
						p1 = cb.and(cb.like(root.get("Name"),SpecificationsUtil.getLikePattern(dto.getName(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);
					}
		
					if(SpecificationsUtil.isNotEmpty(dto.getDescription())){
						p1 = cb.and(cb.like(root.get("Description"),SpecificationsUtil.getLikePattern(dto.getDescription(),SpecificationsUtil.LIKE_PATTERN_PARTIAL)),p1);
					}
		
				}
				return p1;
			}
		};
	}
}
