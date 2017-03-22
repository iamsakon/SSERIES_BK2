/**
 * 
 */
package com.sky.biz.sseries.prodim.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sky.biz.sseries.entity.AbstractEntity;

/**
 * @author User
 *
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "prodim_product_master")
@SequenceGenerator(name = "seq_prodim_product_master", sequenceName = "seq_prodim_product_master")
@Entity
public class ProductMasterEntity extends AbstractEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@Column(name = "short_description")
	private String shortDescription;
	@Column(name = "full_description")
	private String FullDescription;
	@ManyToOne
	@JoinColumn(name="product_type_id")
	private ProductTypeEntity productType;
	@ManyToOne
	@JoinColumn(name="default_uom_id")
	private UomEntity defaultUom;
	@ManyToOne
	@JoinColumn(name="product_category_id")
	private ProductCategoryEntity productCategory;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public ProductTypeEntity getProductType() {
		return productType;
	}
	public void setProductType(ProductTypeEntity productType) {
		this.productType = productType;
	}
	public UomEntity getDefaultUom() {
		return defaultUom;
	}
	public void setDefaultUom(UomEntity defaultUom) {
		this.defaultUom = defaultUom;
	}
	public ProductCategoryEntity getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategoryEntity productCategory) {
		this.productCategory = productCategory;
	}
}
