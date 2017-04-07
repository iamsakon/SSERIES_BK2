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
public class AbstractCorporateTypeController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<CorporateTypeDTO> lazyData;
	@ManagedProperty(value="#{corporateTypeServiceImpl}")
	private CorporateTypeServiceImpl corporateTypeServiceImpl;
	private CorporateTypeDTO selectedCorporateTypeDTO;
	private CorporateTypeDTO mainCorporateTypeDTO;
	private CorporateTypeDTO criteriaCorporateTypeDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/bpn/corporate-type-create";
		this.editView="app/bpn/corporate-type-edit";
		this.listView="app/bpn/corporate-type-list";
		this.readView="app/bpn/corporate-type-view";
		this.selectedCorporateTypeDTO = new CorporateTypeDTO();
		this.criteriaCorporateTypeDTO = new CorporateTypeDTO();
		this.mainCorporateTypeDTO = new CorporateTypeDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<CorporateTypeDTO>(corporateTypeServiceImpl);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedCorporateTypeDTO == null || this.selectedCorporateTypeDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainCorporateTypeDTO = this.selectedCorporateTypeDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedCorporateTypeDTO == null || this.selectedCorporateTypeDTO.getId() == null){
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
			this.mainCorporateTypeDTO = new CorporateTypeDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			corporateTypeServiceImpl.saveNew(this.mainCorporateTypeDTO);
			this.selectedCorporateTypeDTO = this.mainCorporateTypeDTO;
			this.mainCorporateTypeDTO = new CorporateTypeDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Corporate Type was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			corporateTypeServiceImpl.update(this.mainCorporateTypeDTO);
			this.selectedCorporateTypeDTO = this.mainCorporateTypeDTO;
			this.mainCorporateTypeDTO = new CorporateTypeDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Corporate Type was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			corporateTypeServiceImpl.delete(this.selectedCorporateTypeDTO);
			this.selectedCorporateTypeDTO = this.mainCorporateTypeDTO;
			this.mainCorporateTypeDTO = new CorporateTypeDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Corporate Type was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaCorporateTypeDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaCorporateTypeDTO = new CorporateTypeDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(CorporateTypeDTO corporateType){
		try{
			this.selectedCorporateTypeDTO = corporateType;
			if(this.selectedCorporateTypeDTO == null || this.selectedCorporateTypeDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				corporateTypeServiceImpl.delete(this.selectedCorporateTypeDTO);
				this.selectedCorporateTypeDTO = this.mainCorporateTypeDTO;
				this.mainCorporateTypeDTO = new CorporateTypeDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Corporate Type was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(CorporateTypeDTO corporateType){
			this.selectedCorporateTypeDTO = corporateType;
			this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedCorporateTypeDTO = (CorporateTypeDTO) event.getObject();
	}

	public CorporateTypeServiceImpl getCorporateTypeServiceImpl() {
			return corporateTypeServiceImpl;
	}

	public void setCorporateTypeServiceImpl(CorporateTypeServiceImpl corporateTypeServiceImpl) {

		this.corporateTypeServiceImpl = corporateTypeServiceImpl;

	}

	public LazyDataModelUtil<CorporateTypeDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<CorporateTypeDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public CorporateTypeDTO getSelectedCorporateTypeDTO() {

		return selectedCorporateTypeDTO;

	}

	public void setSelectedCorporateTypeDTO(CorporateTypeDTO selectedCorporateTypeDTO) {

		this.selectedCorporateTypeDTO = selectedCorporateTypeDTO;

	}

	public CorporateTypeDTO getMainCorporateTypeDTO() {

		return mainCorporateTypeDTO;

	}

	public void setMainCorporateTypeDTO(CorporateTypeDTO mainCorporateTypeDTO) {

		this.mainCorporateTypeDTO = mainCorporateTypeDTO;

	}

	public CorporateTypeDTO getCriteriaCorporateTypeDTO() {

		return criteriaCorporateTypeDTO;

	}

	public void setCriteriaCorporateTypeDTO(CorporateTypeDTO criteriaCorporateTypeDTO) {

		this.criteriaCorporateTypeDTO = criteriaCorporateTypeDTO;

	}
}
