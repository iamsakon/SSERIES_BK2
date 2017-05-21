package com.sky.biz.sseries.ssd.controller.util;

public class ServiceImplUtil {
	
	public static String KEY_FULL_PACKAGE_NAME = "%FULL_PACKAGE_NAME%";
	public static String KEY_CLASS_NAME = "%CLASS_NAME%";
	public static String KEY_CLASS_NAME_INS = "%CLASS_NAME_INS%";
	
	public static String getTemplate(){
		StringBuilder str = new StringBuilder();
		str.append("package "+ KEY_FULL_PACKAGE_NAME +".services.impl;");
		str.append("\n\n");
		str.append("import org.springframework.stereotype.Service;");
		str.append("\n");
		str.append("import com.sky.biz.sseries.services.ISSeriesServices;");
		str.append("\n");
		str.append("import com.sky.biz.sseries.ssd.services.Abstract"+ KEY_CLASS_NAME +"Service;");
		str.append("\n\n");
		str.append("@SuppressWarnings(\"rawtypes\")");
		str.append("\n");
		str.append("@Service (\""+ KEY_CLASS_NAME_INS +"Service\")");
		str.append("\n");
		str.append("public class "+ KEY_CLASS_NAME +"ServiceImpl extends Abstract"+ KEY_CLASS_NAME +"Service implements ISSeriesServices {");
		str.append("\n\n");
		str.append("}");
		return str.toString();
	}
	
	public static String getTemplate(String packageName,String className,String classNameIns){
		String template = ServiceImplUtil.getTemplate();
		template = template.replace(KEY_FULL_PACKAGE_NAME,packageName);
		template = template.replace(KEY_CLASS_NAME,className);
		template = template.replace(KEY_CLASS_NAME_INS,classNameIns);
		return template;
	}
}
