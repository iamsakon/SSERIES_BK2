
/**
 *
 */
package com.sky.biz.sseries.usm.framework.controller;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import com.sky.biz.sseries.mbean.AbstractController;
import com.sky.biz.sseries.mbean.IBasicController;
import com.sky.biz.sseries.mbean.LazyDataModelUtil;
import com.sky.biz.sseries.usm.dto.*;
import com.sky.biz.sseries.usm.services.impl.*;

import com.sky.biz.sseries.util.JsfUtil;


public class AbstractRoleController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<RoleDTO> lazyData;
	@ManagedProperty(value="#{roleServiceImpl}")
	private RoleServiceImpl roleServiceImpl;
	private RoleDTO selectedRoleDTO;
	private RoleDTO mainRoleDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/usm/role-create";
		this.editView="app/usm/role-edit";
		this.listView="app/usm/role-list";
		this.readView="app/usm/role-view";
		this.selectedRoleDTO = new RoleDTO();
		this.mainRoleDTO = new RoleDTO();
		lazyData = new LazyDataModelUtil<RoleDTO>(roleServiceImpl);
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			roleServiceImpl.save(this.mainRoleDTO);
			this.selectedRoleDTO = this.mainRoleDTO;
			this.mainRoleDTO = new RoleDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage("RoleDTO was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}
	
	public void onRowSelect(SelectEvent event) {
		this.selectedRoleDTO = (RoleDTO) event.getObject();
    }

	public RoleServiceImpl getRoleServiceImpl() {
			return roleServiceImpl;
	}

	public void setRoleServiceImpl(RoleServiceImpl roleServiceImpl) {

		this.roleServiceImpl = roleServiceImpl;

	}

	public LazyDataModelUtil<RoleDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<RoleDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public RoleDTO getSelectedRoleDTO() {

		return selectedRoleDTO;

	}

	public void setSelectedRoleDTO(RoleDTO selectedRoleDTO) {

		this.selectedRoleDTO = selectedRoleDTO;

	}

	public RoleDTO getMainRoleDTO() {

		return mainRoleDTO;

	}

	public void setMainRoleDTO(RoleDTO mainRoleDTO) {

		this.mainRoleDTO = mainRoleDTO;

	}
}
