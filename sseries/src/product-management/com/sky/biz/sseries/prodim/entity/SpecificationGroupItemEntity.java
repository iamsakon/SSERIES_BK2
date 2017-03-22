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
@Table(name = "prodim_specification_group_item")
@SequenceGenerator(name = "seq_prodim_specification_group_item", sequenceName = "seq_prodim_specification_group_item")
@Entity
public class SpecificationGroupItemEntity extends AbstractProdimEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne
	@JoinColumn(name="specification_group_id")
	private SpecificationGroupEntity specificationGroup;
	@ManyToOne
	@JoinColumn(name="specification_item_id")
	private SpecificationItemEntity specificationItem;	
	@Column(name="sort_key")
	private int sortKey;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SpecificationGroupEntity getSpecificationGroup() {
		return specificationGroup;
	}
	public void setSpecificationGroup(SpecificationGroupEntity specificationGroup) {
		this.specificationGroup = specificationGroup;
	}
	public SpecificationItemEntity getSpecificationItem() {
		return specificationItem;
	}
	public void setSpecificationItem(SpecificationItemEntity specificationItem) {
		this.specificationItem = specificationItem;
	}
	public int getSortKey() {
		return sortKey;
	}
	public void setSortKey(int sortKey) {
		this.sortKey = sortKey;
	}
	
}
