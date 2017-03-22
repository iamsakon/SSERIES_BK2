package com.sky.biz.sseries.usm.specification;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.Map;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;

import com.sky.biz.sseries.usm.dto.UserAccountDTO;
import com.sky.biz.sseries.usm.entity.UserAccountEntity;
import com.sky.biz.sseries.util.SpecificationsUtil;
/**
 * A class which is used to create Specification objects which are used to
 * create JPA criteria queries for UserAccountEntity information.
 * 
 * @author MrMai
 */
public class UserAccountSpecifications {

	public static Specification<UserAccountEntity> basicCriteria(Map<String,Object> criteriaMap){
//		return UserAccountSpecifications.userAccountActive();
		return new Specification<UserAccountEntity>() {
			public Predicate toPredicate(Root<UserAccountEntity> root,
					CriteriaQuery<?> query,CriteriaBuilder cb){
				UserAccountDTO dto = null;
				String usernameCriteria = "";
				Predicate p1 = cb.equal(root.get("isActive"), true);
				if(criteriaMap != null)
					dto = (UserAccountDTO)criteriaMap.get(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP);				
				
				if(dto!=null){
					if(!SpecificationsUtil.isEmpty(dto.getUsername())){
						usernameCriteria = SpecificationsUtil.getLikePattern(dto.getUsername(),SpecificationsUtil.LIKE_PATTERN_PARTIAL);	
						p1 = cb.and(cb.like(root.get("username"),usernameCriteria),p1);
					}
					if(dto.getEnabled() == true){
						p1 = cb.and(cb.equal(root.get("enabled"),dto.getEnabled()),p1);
					}
				}
				
								
				return p1;
			}
		};
	}
	
	public static Specification<UserAccountEntity> userAccountActive() {
	    return new Specification<UserAccountEntity>() {
	      public Predicate toPredicate(Root<UserAccountEntity> root, 
	    		  CriteriaQuery<?> query, CriteriaBuilder cb) {
	        return cb.equal(root.get("isActive"), true);
	      }
	    };
	}
	

}
