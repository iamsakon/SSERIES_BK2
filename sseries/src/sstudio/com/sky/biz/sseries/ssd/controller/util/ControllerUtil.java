package com.sky.biz.sseries.ssd.controller.util;

public class ControllerUtil {

	public static String KEY_FULL_PACKAGE_NAME = "%FULL_PACKAGE_NAME%";
	public static String KEY_CLASS_NAME = "%CLASS_NAME%";
	public static String KEY_CLASS_NAME_INS = "%CLASS_NAME_INS%";
	
	public static String getTemplate(){
		StringBuilder str = new StringBuilder();
		str.append("package "+ KEY_FULL_PACKAGE_NAME +".controller;");
		str.append("\n\n");
		str.append("import javax.faces.bean.*;");
		str.append("\n");
		str.append("import com.sky.biz.sseries.mbean.IBasicController;");
		str.append("\n");
		str.append("import "+ KEY_FULL_PACKAGE_NAME +".services.I"+ KEY_CLASS_NAME +";");
		str.append("\n\n");
		str.append("@ManagedBean(name = \""+ KEY_CLASS_NAME_INS +"Controller\")");
		str.append("\n");
		str.append("@SessionScoped");		
		str.append("\n");
		str.append("public class "+ KEY_CLASS_NAME +"Controller extends Abstract"+ KEY_CLASS_NAME +"Controller implements I"+ KEY_CLASS_NAME +", IBasicController  {");
		str.append("\n\n");
		str.append("}");
		return str.toString();
	}
	
	public static String getTemplate(String packageName,String className,String classNameIns){
		String template = ControllerUtil.getTemplate();
		template = template.replace(KEY_FULL_PACKAGE_NAME,packageName);
		template = template.replace(KEY_CLASS_NAME,className);
		template = template.replace(KEY_CLASS_NAME_INS,classNameIns);
		return template;
	}
}
