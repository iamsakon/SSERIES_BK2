
package com.sky.biz.sseries.bpn.specification;

import java.util.Map;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;
import com.sky.biz.sseries.bpn.util.*;
import com.sky.biz.sseries.bpn.dto.*;
import com.sky.biz.sseries.bpn.entity.*;

import java.util.*;
import com.sky.biz.sseries.util.SpecificationsUtil;
public class AbstractBusinessPartnerGroupSpecification{
	public static Specification<BusinessPartnerGroupEntity> basicCriteria(Map<String,Object> criteriaMap){
		return new Specification<BusinessPartnerGroupEntity>() {
			public Predicate toPredicate(Root<BusinessPartnerGroupEntity> root,CriteriaQuery<?> query,CriteriaBuilder cb){
				BusinessPartnerGroupDTO dto = null;
				Predicate p1 = cb.equal(root.get("markDelete"), false);
				if(criteriaMap != null)
					dto = (BusinessPartnerGroupDTO)criteriaMap.get(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP);
				if(dto!=null){
		
					if(SpecificationsUtil.isNotEmpty(dto.getDefaultGroup())){
						p1 = cb.and(cb.equal(root.get("defaultGroup"),dto.getDefaultGroup()),p1);
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
