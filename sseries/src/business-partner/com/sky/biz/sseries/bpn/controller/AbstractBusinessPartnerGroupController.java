/**
 *
 */
package com.sky.biz.sseries.bpn.controller;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import com.sky.biz.sseries.mbean.AbstractController;
import com.sky.biz.sseries.mbean.IBasicController;
import com.sky.biz.sseries.mbean.LazyDataModelUtil;
import com.sky.biz.sseries.bpn.dto.*;
import com.sky.biz.sseries.bpn.services.impl.*;

import com.sky.biz.sseries.util.JsfUtil;

import com.sky.biz.sseries.util.SpecificationsUtil;
import org.primefaces.event.SelectEvent;
public class AbstractBusinessPartnerGroupController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<BusinessPartnerGroupDTO> lazyData;
	@ManagedProperty(value="#{businessPartnerGroupServiceImpl}")
	private BusinessPartnerGroupServiceImpl businessPartnerGroupServiceImpl;
	private BusinessPartnerGroupDTO selectedBusinessPartnerGroupDTO;
	private BusinessPartnerGroupDTO mainBusinessPartnerGroupDTO;
	private BusinessPartnerGroupDTO criteriaBusinessPartnerGroupDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/bpn/business-partner-group-create";
		this.editView="app/bpn/business-partner-group-edit";
		this.listView="app/bpn/business-partner-group-list";
		this.readView="app/bpn/business-partner-group-view";
		this.selectedBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();
		this.criteriaBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();
		this.mainBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<BusinessPartnerGroupDTO>(businessPartnerGroupServiceImpl);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedBusinessPartnerGroupDTO == null || this.selectedBusinessPartnerGroupDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainBusinessPartnerGroupDTO = this.selectedBusinessPartnerGroupDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}
	
	public void newAction(ActionEvent actionEvent) {
		try {
			mainBusinessPartnerGroupDTO  = new BusinessPartnerGroupDTO();
			this.setCurrentSubView(this.createView);
		} catch (Exception ex) {
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			this.selectedBusinessPartnerGroupDTO = businessPartnerGroupServiceImpl.saveNew(this.mainBusinessPartnerGroupDTO);
			this.selectedBusinessPartnerGroupDTO = this.mainBusinessPartnerGroupDTO;
			this.mainBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage("Business Partner Group  was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			businessPartnerGroupServiceImpl.update(this.mainBusinessPartnerGroupDTO);
			this.selectedBusinessPartnerGroupDTO = this.mainBusinessPartnerGroupDTO;
			this.mainBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage("Business Partner Group was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}


	public void deleteAction(ActionEvent actionEvent) {
		try{
			businessPartnerGroupServiceImpl.delete(this.selectedBusinessPartnerGroupDTO);
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage("Business Partner Group was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}
	
	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaBusinessPartnerGroupDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaBusinessPartnerGroupDTO = new BusinessPartnerGroupDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedBusinessPartnerGroupDTO = (BusinessPartnerGroupDTO) event.getObject();
	}

	public BusinessPartnerGroupServiceImpl getBusinessPartnerGroupServiceImpl() {
			return businessPartnerGroupServiceImpl;
	}

	public void setBusinessPartnerGroupServiceImpl(BusinessPartnerGroupServiceImpl businessPartnerGroupServiceImpl) {

		this.businessPartnerGroupServiceImpl = businessPartnerGroupServiceImpl;

	}

	public LazyDataModelUtil<BusinessPartnerGroupDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<BusinessPartnerGroupDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public BusinessPartnerGroupDTO getSelectedBusinessPartnerGroupDTO() {

		return selectedBusinessPartnerGroupDTO;

	}

	public void setSelectedBusinessPartnerGroupDTO(BusinessPartnerGroupDTO selectedBusinessPartnerGroupDTO) {

		this.selectedBusinessPartnerGroupDTO = selectedBusinessPartnerGroupDTO;

	}

	public BusinessPartnerGroupDTO getMainBusinessPartnerGroupDTO() {

		return mainBusinessPartnerGroupDTO;

	}

	public void setMainBusinessPartnerGroupDTO(BusinessPartnerGroupDTO mainBusinessPartnerGroupDTO) {

		this.mainBusinessPartnerGroupDTO = mainBusinessPartnerGroupDTO;

	}

	public BusinessPartnerGroupDTO getCriteriaBusinessPartnerGroupDTO() {

		return criteriaBusinessPartnerGroupDTO;

	}

	public void setCriteriaBusinessPartnerGroupDTO(BusinessPartnerGroupDTO criteriaBusinessPartnerGroupDTO) {

		this.criteriaBusinessPartnerGroupDTO = criteriaBusinessPartnerGroupDTO;

	}
}
