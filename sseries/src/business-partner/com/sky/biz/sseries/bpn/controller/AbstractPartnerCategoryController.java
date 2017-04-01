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
public class AbstractPartnerCategoryController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<PartnerCategoryDTO> lazyData;
	@ManagedProperty(value="#{partnerCategoryServiceImpl}")
	private PartnerCategoryServiceImpl partnerCategoryServiceImpl;
	private PartnerCategoryDTO selectedPartnerCategoryDTO;
	private PartnerCategoryDTO mainPartnerCategoryDTO;
	private PartnerCategoryDTO criteriaPartnerCategoryDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/bpn/partner-category-create";
		this.editView="app/bpn/partner-category-edit";
		this.listView="app/bpn/partner-category-list";
		this.readView="app/bpn/partner-category-view";
		this.selectedPartnerCategoryDTO = new PartnerCategoryDTO();
		this.criteriaPartnerCategoryDTO = new PartnerCategoryDTO();
		this.mainPartnerCategoryDTO = new PartnerCategoryDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<PartnerCategoryDTO>(partnerCategoryServiceImpl);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedPartnerCategoryDTO == null || this.selectedPartnerCategoryDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainPartnerCategoryDTO = this.selectedPartnerCategoryDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void newAction(ActionEvent actionEvent) {
		try{
			this.mainPartnerCategoryDTO = new PartnerCategoryDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			partnerCategoryServiceImpl.saveNew(this.mainPartnerCategoryDTO);
			this.selectedPartnerCategoryDTO = this.mainPartnerCategoryDTO;
			this.mainPartnerCategoryDTO = new PartnerCategoryDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Partner Category was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			partnerCategoryServiceImpl.update(this.mainPartnerCategoryDTO);
			this.selectedPartnerCategoryDTO = this.mainPartnerCategoryDTO;
			this.mainPartnerCategoryDTO = new PartnerCategoryDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Partner Category was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			partnerCategoryServiceImpl.delete(this.selectedPartnerCategoryDTO);
			this.selectedPartnerCategoryDTO = this.mainPartnerCategoryDTO;
			this.mainPartnerCategoryDTO = new PartnerCategoryDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Partner Category was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaPartnerCategoryDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaPartnerCategoryDTO = new PartnerCategoryDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedPartnerCategoryDTO = (PartnerCategoryDTO) event.getObject();
	}

	public PartnerCategoryServiceImpl getPartnerCategoryServiceImpl() {
			return partnerCategoryServiceImpl;
	}

	public void setPartnerCategoryServiceImpl(PartnerCategoryServiceImpl partnerCategoryServiceImpl) {

		this.partnerCategoryServiceImpl = partnerCategoryServiceImpl;

	}

	public LazyDataModelUtil<PartnerCategoryDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<PartnerCategoryDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public PartnerCategoryDTO getSelectedPartnerCategoryDTO() {

		return selectedPartnerCategoryDTO;

	}

	public void setSelectedPartnerCategoryDTO(PartnerCategoryDTO selectedPartnerCategoryDTO) {

		this.selectedPartnerCategoryDTO = selectedPartnerCategoryDTO;

	}

	public PartnerCategoryDTO getMainPartnerCategoryDTO() {

		return mainPartnerCategoryDTO;

	}

	public void setMainPartnerCategoryDTO(PartnerCategoryDTO mainPartnerCategoryDTO) {

		this.mainPartnerCategoryDTO = mainPartnerCategoryDTO;

	}

	public PartnerCategoryDTO getCriteriaPartnerCategoryDTO() {

		return criteriaPartnerCategoryDTO;

	}

	public void setCriteriaPartnerCategoryDTO(PartnerCategoryDTO criteriaPartnerCategoryDTO) {

		this.criteriaPartnerCategoryDTO = criteriaPartnerCategoryDTO;

	}
}
