package com.sky.biz.sseries.util;

public class SpecificationsUtil {
	
	public static final String DEFAULT_CRITERIA_KEY_MAP = "default_criteria_key_map";
	
	public static final int LIKE_PATTERN_RIGHT = 0;
	
	public static final int LIKE_PATTERN_LEFT = 1;
	
	public static final int LIKE_PATTERN_PARTIAL = 2;
	
	public static String getLikePattern(final String searchTerm,int likePatternType){
		StringBuilder pattern = new StringBuilder();
		if(likePatternType == LIKE_PATTERN_LEFT || likePatternType == LIKE_PATTERN_PARTIAL){
			pattern.append("%");
		}
		pattern.append((searchTerm == null ? "" : searchTerm.trim()));
		
		if(likePatternType == LIKE_PATTERN_RIGHT || likePatternType == LIKE_PATTERN_PARTIAL){
			pattern.append("%");
		}
		
		return pattern.toString();
	}
	
	public static String getLikePattern(final String searchTerm) {
		StringBuilder pattern = new StringBuilder();
		pattern.append((searchTerm == null ? "" : searchTerm).toLowerCase());
		pattern.append("%");
		return pattern.toString();
	}
	
	public static boolean isNotEmpty(Double chk){
		if(chk == null){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isNotEmpty(Boolean chk){
		if(chk == null){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isNotEmpty(String chk){
		if(chk == null || "".equals (chk)){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isEmpty(String chk){
		if(chk == null || "".equals(chk)){
			return true;
		}else{
			return false;
		}
	}
	
}
