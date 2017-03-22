
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
import com.sky.biz.sseries.mbean.AbstractController;
import com.sky.biz.sseries.mbean.IBasicController;
import com.sky.biz.sseries.mbean.LazyDataModelUtil;
import com.sky.biz.sseries.usm.dto.*;
import com.sky.biz.sseries.usm.services.impl.*;

import com.sky.biz.sseries.util.JsfUtil;

public class AbstractUserAccountRoleController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<UserAccountRoleDTO> lazyData;
	@ManagedProperty(value="#{userAccountRoleServiceImpl}")
	private UserAccountRoleServiceImpl userAccountRoleServiceImpl;
	private UserAccountRoleDTO selectedUserAccountRoleDTO;
	private UserAccountRoleDTO mainUserAccountRoleDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/usm/user-account-role-create";
		this.editView="app/usm/user-account-role-edit";
		this.listView="app/usm/user-account-role-list";
		this.readView="app/usm/user-account-role-view";
		this.selectedUserAccountRoleDTO = new UserAccountRoleDTO();
		this.mainUserAccountRoleDTO = new UserAccountRoleDTO();
		lazyData = new LazyDataModelUtil<UserAccountRoleDTO>(userAccountRoleServiceImpl);
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			userAccountRoleServiceImpl.save(this.mainUserAccountRoleDTO);
			this.selectedUserAccountRoleDTO = this.mainUserAccountRoleDTO;
			this.mainUserAccountRoleDTO = new UserAccountRoleDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage("UserAccountRoleDTO was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public UserAccountRoleServiceImpl getUserAccountRoleServiceImpl() {
			return userAccountRoleServiceImpl;
	}

	public void setUserAccountRoleServiceImpl(UserAccountRoleServiceImpl userAccountRoleServiceImpl) {

		this.userAccountRoleServiceImpl = userAccountRoleServiceImpl;

	}

	public LazyDataModelUtil<UserAccountRoleDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<UserAccountRoleDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public UserAccountRoleDTO getSelectedUserAccountRoleDTO() {

		return selectedUserAccountRoleDTO;

	}

	public void setSelectedUserAccountRoleDTO(UserAccountRoleDTO selectedUserAccountRoleDTO) {

		this.selectedUserAccountRoleDTO = selectedUserAccountRoleDTO;

	}

	public UserAccountRoleDTO getMainUserAccountRoleDTO() {

		return mainUserAccountRoleDTO;

	}

	public void setMainUserAccountRoleDTO(UserAccountRoleDTO mainUserAccountRoleDTO) {

		this.mainUserAccountRoleDTO = mainUserAccountRoleDTO;

	}
}
