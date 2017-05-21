package com.sky.biz.sseries.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "tenant")
@SessionScoped
public class TenantBean {

	String tenant;

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		System.out.println(tenant);
		this.tenant = tenant;
	}
}
