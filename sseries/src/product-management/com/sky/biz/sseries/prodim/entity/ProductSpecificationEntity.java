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

/**
 * @author User
 *
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "prodim_product_specification")
@SequenceGenerator(name = "seq_prodim_product_specification", sequenceName = "seq_prodim_product_specification")
@Entity
public class ProductSpecificationEntity extends AbstractProdimEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne
	@JoinColumn(name="product_master_id")
	private ProductMasterEntity productMaster;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProductMasterEntity getProductMaster() {
		return productMaster;
	}
	public void setProductMaster(ProductMasterEntity productMaster) {
		this.productMaster = productMaster;
	}
	
}
