package com.sky.biz.sseries.prodim.dto;

public class ProductMasterDTO extends AbstractProdimDTO {

	private String code;

	private String name;

	private String shortDescription;

	private String FullDescription;
	
	private ProductTypeDTO productType = new ProductTypeDTO();
	
	private UomDTO uom = new UomDTO();
	
	private ProductCategoryDTO productCategory = new ProductCategoryDTO();
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFullDescription() {
		return FullDescription;
	}

	public void setFullDescription(String fullDescription) {
		FullDescription = fullDescription;
	}

	public ProductTypeDTO getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeDTO productType) {
		this.productType = productType;
	}

	public UomDTO getUom() {
		return uom;
	}

	public void setUom(UomDTO uom) {
		this.uom = uom;
	}

	public ProductCategoryDTO getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryDTO productCategory) {
		this.productCategory = productCategory;
	}
}
