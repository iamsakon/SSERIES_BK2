/**
 * 
 */
package com.sky.biz.sseries.prodim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "prodim_product_type")
@SequenceGenerator(name = "seq_prodim_product_type", sequenceName = "seq_prodim_product_type")
@Entity
public class ProductTypeEntity extends AbstractProdimEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="name")
	private String name;
	//@Column(name="enable_product_attribute")
	private boolean enableProductAttribute;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
