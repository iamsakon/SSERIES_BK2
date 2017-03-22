/**
 * 
 */
package com.sky.biz.sseries.prodim.dto;

/**
 * @author User
 *
 */
public class UomDTO extends AbstractProdimDTO {

	private String code;
	
	private String name;

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
}
