
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


public class AbstractPrivilegeController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<PrivilegeDTO> lazyData;
	@ManagedProperty(value="#{privilegeServiceImpl}")
	private PrivilegeServiceImpl privilegeServiceImpl;
	private PrivilegeDTO selectedPrivilegeDTO;
	private PrivilegeDTO mainPrivilegeDTO;
	private PrivilegeDTO criteriaPrivilegeDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/usm/privilege-create";
		this.editView="app/usm/privilege-edit";
		this.listView="app/usm/privilege-list";
		this.readView="app/usm/privilege-view";
		this.selectedPrivilegeDTO = new PrivilegeDTO();
		this.mainPrivilegeDTO = new PrivilegeDTO();
		lazyData = new LazyDataModelUtil<PrivilegeDTO>(privilegeServiceImpl);
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			privilegeServiceImpl.save(this.mainPrivilegeDTO);
			this.selectedPrivilegeDTO = this.mainPrivilegeDTO;
			this.mainPrivilegeDTO = new PrivilegeDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage("Privilege was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}
	
	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();		
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaPrivilegeDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}
	
	public void resetAction(ActionEvent actionEvent){
		this.criteriaPrivilegeDTO = new PrivilegeDTO();
		this.lazyData.setCriteriaMap(null);
	}
	
	public void onRowSelect(SelectEvent event) {
		this.selectedPrivilegeDTO = (PrivilegeDTO) event.getObject();
    }

	public PrivilegeServiceImpl getPrivilegeServiceImpl() {
			return privilegeServiceImpl;
	}

	public void setPrivilegeServiceImpl(PrivilegeServiceImpl privilegeServiceImpl) {

		this.privilegeServiceImpl = privilegeServiceImpl;

	}

	public LazyDataModelUtil<PrivilegeDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<PrivilegeDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public PrivilegeDTO getSelectedPrivilegeDTO() {

		return selectedPrivilegeDTO;

	}

	public void setSelectedPrivilegeDTO(PrivilegeDTO selectedPrivilegeDTO) {

		this.selectedPrivilegeDTO = selectedPrivilegeDTO;

	}

	public PrivilegeDTO getMainPrivilegeDTO() {

		return mainPrivilegeDTO;

	}

	public void setMainPrivilegeDTO(PrivilegeDTO mainPrivilegeDTO) {

		this.mainPrivilegeDTO = mainPrivilegeDTO;

	}

	public PrivilegeDTO getCriteriaPrivilegeDTO() {
		return criteriaPrivilegeDTO;
	}

	public void setCriteriaPrivilegeDTO(PrivilegeDTO criteriaPrivilegeDTO) {
		this.criteriaPrivilegeDTO = criteriaPrivilegeDTO;
	}
}
