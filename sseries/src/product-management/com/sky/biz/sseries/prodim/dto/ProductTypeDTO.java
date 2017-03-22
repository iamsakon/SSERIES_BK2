package com.sky.biz.sseries.prodim.dto;

public class ProductTypeDTO extends AbstractProdimDTO {
	
	private String name;
	
	private boolean enableProductAttribute;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnableProductAttribute() {
		return enableProductAttribute;
	}
	public void setEnableProductAttribute(boolean enableProductAttribute) {
		this.enableProductAttribute = enableProductAttribute;
	}
}
