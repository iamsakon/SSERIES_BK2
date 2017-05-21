package com.sky.biz.sseries.ssd.controller.util;

public class SpecificationUtil {

	public static String KEY_FULL_PACKAGE_NAME = "%FULL_PACKAGE_NAME%";
	public static String KEY_CLASS_NAME = "%CLASS_NAME%";
	
	public static String getTemplate(){
		StringBuilder str = new StringBuilder();
		str.append("package "+ KEY_FULL_PACKAGE_NAME +".specification;");
		str.append("\n\n");
		str.append("public class "+ KEY_CLASS_NAME +"Specification extends Abstract"+ KEY_CLASS_NAME +"Specification {");
		str.append("\n\n");
		str.append("}");
		return str.toString();
	}
	
	public static String getTemplate(String packageName,String className){
		String template = SpecificationUtil.getTemplate();
		template = template.replace(KEY_FULL_PACKAGE_NAME,packageName);
		template = template.replace(KEY_CLASS_NAME,className);
		return template;
	}
}
