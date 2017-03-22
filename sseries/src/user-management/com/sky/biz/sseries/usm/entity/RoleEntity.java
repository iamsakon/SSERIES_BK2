
/**
 *
 */
package com.sky.biz.sseries.usm.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.sky.biz.sseries.entity.AbstractEntity; 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "usm_role")
@SequenceGenerator(name = "seq_usm_role", sequenceName = "seq_usm_role")
@Entity
public class RoleEntity extends AbstractEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "name")
	private String name;
	public String getName() {
		return this.name;
	}
	public void setName(String name) { 
		this.name = name;
	}
}
