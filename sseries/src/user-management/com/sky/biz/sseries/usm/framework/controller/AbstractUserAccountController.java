
/**
 *
 */
package com.sky.biz.sseries.usm.framework.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.sky.biz.sseries.util.SpecificationsUtil;


public class AbstractUserAccountController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<UserAccountDTO> lazyData;
	@ManagedProperty(value="#{userAccountServiceImpl}")
	private UserAccountServiceImpl userAccountServiceImpl;
	private UserAccountDTO selectedUserAccountDTO;
	private UserAccountDTO mainUserAccountDTO;
	private UserAccountDTO criteriaUserAccountDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/usm/user-account-create";
		this.editView="app/usm/user-account-edit";
		this.listView="app/usm/user-account-list";
		this.readView="app/usm/user-account-view";
		this.selectedUserAccountDTO = new UserAccountDTO();
		this.mainUserAccountDTO = new UserAccountDTO();
		this.criteriaUserAccountDTO = new UserAccountDTO();
		lazyData = new LazyDataModelUtil<UserAccountDTO>(userAccountServiceImpl);
	}
	
	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedUserAccountDTO == null || this.selectedUserAccountDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainUserAccountDTO = this.selectedUserAccountDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			userAccountServiceImpl.save(this.mainUserAccountDTO);
			this.selectedUserAccountDTO = this.mainUserAccountDTO;
			this.mainUserAccountDTO = new UserAccountDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage("UserAccount was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}
	
	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();		
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaUserAccountDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}
	
	public void resetAction(ActionEvent actionEvent){
		this.criteriaUserAccountDTO = new UserAccountDTO();
		this.lazyData.setCriteriaMap(null);
	}
	
	public void updateAction(ActionEvent actionEvent) {
		JsfUtil.addErrorMessage("Not implement updateAction yet");
	}


	public void deleteAction(ActionEvent actionEvent) {
		JsfUtil.addErrorMessage("Not implement deleteAction yet");
	}
	

	public void onRowSelect(SelectEvent event) {
		this.selectedUserAccountDTO = (UserAccountDTO) event.getObject();
    }
	
	public UserAccountServiceImpl getUserAccountServiceImpl() {
			return userAccountServiceImpl;
	}

	public void setUserAccountServiceImpl(UserAccountServiceImpl userAccountServiceImpl) {

		this.userAccountServiceImpl = userAccountServiceImpl;

	}

	public LazyDataModelUtil<UserAccountDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<UserAccountDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public UserAccountDTO getSelectedUserAccountDTO() {

		return selectedUserAccountDTO;

	}

	public void setSelectedUserAccountDTO(UserAccountDTO selectedUserAccountDTO) {

		this.selectedUserAccountDTO = selectedUserAccountDTO;

	}

	public UserAccountDTO getMainUserAccountDTO() {

		return mainUserAccountDTO;

	}

	public void setMainUserAccountDTO(UserAccountDTO mainUserAccountDTO) {

		this.mainUserAccountDTO = mainUserAccountDTO;

	}

	public UserAccountDTO getCriteriaUserAccountDTO() {
		return criteriaUserAccountDTO;
	}

	public void setCriteriaUserAccountDTO(UserAccountDTO criteriaUserAccountDTO) {
		this.criteriaUserAccountDTO = criteriaUserAccountDTO;
	}
}
