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
public class AbstractPartnerGroupController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<PartnerGroupDTO> lazyData;
	@ManagedProperty(value="#{partnerGroupServiceImpl}")
	private PartnerGroupServiceImpl partnerGroupServiceImpl;
	private PartnerGroupDTO selectedPartnerGroupDTO;
	private PartnerGroupDTO mainPartnerGroupDTO;
	private PartnerGroupDTO criteriaPartnerGroupDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/bpn/partner-group-create";
		this.editView="app/bpn/partner-group-edit";
		this.listView="app/bpn/partner-group-list";
		this.readView="app/bpn/partner-group-view";
		this.selectedPartnerGroupDTO = new PartnerGroupDTO();
		this.criteriaPartnerGroupDTO = new PartnerGroupDTO();
		this.mainPartnerGroupDTO = new PartnerGroupDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<PartnerGroupDTO>(partnerGroupServiceImpl);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedPartnerGroupDTO == null || this.selectedPartnerGroupDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainPartnerGroupDTO = this.selectedPartnerGroupDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedPartnerGroupDTO == null || this.selectedPartnerGroupDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.setCurrentSubView(this.readView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void newAction(ActionEvent actionEvent) {
		try{
			this.mainPartnerGroupDTO = new PartnerGroupDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			partnerGroupServiceImpl.saveNew(this.mainPartnerGroupDTO);
			this.selectedPartnerGroupDTO = this.mainPartnerGroupDTO;
			this.mainPartnerGroupDTO = new PartnerGroupDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Partner Group was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			partnerGroupServiceImpl.update(this.mainPartnerGroupDTO);
			this.selectedPartnerGroupDTO = this.mainPartnerGroupDTO;
			this.mainPartnerGroupDTO = new PartnerGroupDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Partner Group was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			partnerGroupServiceImpl.delete(this.selectedPartnerGroupDTO);
			this.selectedPartnerGroupDTO = this.mainPartnerGroupDTO;
			this.mainPartnerGroupDTO = new PartnerGroupDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Partner Group was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaPartnerGroupDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaPartnerGroupDTO = new PartnerGroupDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(PartnerGroupDTO partnerGroup){
		try{
			this.selectedPartnerGroupDTO = partnerGroup;
			if(this.selectedPartnerGroupDTO == null || this.selectedPartnerGroupDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				partnerGroupServiceImpl.delete(this.selectedPartnerGroupDTO);
				this.selectedPartnerGroupDTO = this.mainPartnerGroupDTO;
				this.mainPartnerGroupDTO = new PartnerGroupDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Partner Group was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(PartnerGroupDTO partnerGroup){
		this.selectedPartnerGroupDTO = partnerGroup;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedPartnerGroupDTO = (PartnerGroupDTO) event.getObject();
	}

	public PartnerGroupServiceImpl getPartnerGroupServiceImpl() {
			return partnerGroupServiceImpl;
	}

	public void setPartnerGroupServiceImpl(PartnerGroupServiceImpl partnerGroupServiceImpl) {

		this.partnerGroupServiceImpl = partnerGroupServiceImpl;

	}

	public LazyDataModelUtil<PartnerGroupDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<PartnerGroupDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public PartnerGroupDTO getSelectedPartnerGroupDTO() {

		return selectedPartnerGroupDTO;

	}

	public void setSelectedPartnerGroupDTO(PartnerGroupDTO selectedPartnerGroupDTO) {

		this.selectedPartnerGroupDTO = selectedPartnerGroupDTO;

	}

	public PartnerGroupDTO getMainPartnerGroupDTO() {

		return mainPartnerGroupDTO;

	}

	public void setMainPartnerGroupDTO(PartnerGroupDTO mainPartnerGroupDTO) {

		this.mainPartnerGroupDTO = mainPartnerGroupDTO;

	}

	public PartnerGroupDTO getCriteriaPartnerGroupDTO() {

		return criteriaPartnerGroupDTO;

	}

	public void setCriteriaPartnerGroupDTO(PartnerGroupDTO criteriaPartnerGroupDTO) {

		this.criteriaPartnerGroupDTO = criteriaPartnerGroupDTO;

	}
}
