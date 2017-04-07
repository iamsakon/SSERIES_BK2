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
public class AbstractAddressTypeController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<AddressTypeDTO> lazyData;
	@ManagedProperty(value="#{addressTypeServiceImpl}")
	private AddressTypeServiceImpl addressTypeServiceImpl;
	private AddressTypeDTO selectedAddressTypeDTO;
	private AddressTypeDTO mainAddressTypeDTO;
	private AddressTypeDTO criteriaAddressTypeDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/bpn/address-type-create";
		this.editView="app/bpn/address-type-edit";
		this.listView="app/bpn/address-type-list";
		this.readView="app/bpn/address-type-view";
		this.selectedAddressTypeDTO = new AddressTypeDTO();
		this.criteriaAddressTypeDTO = new AddressTypeDTO();
		this.mainAddressTypeDTO = new AddressTypeDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<AddressTypeDTO>(addressTypeServiceImpl);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedAddressTypeDTO == null || this.selectedAddressTypeDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainAddressTypeDTO = this.selectedAddressTypeDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedAddressTypeDTO == null || this.selectedAddressTypeDTO.getId() == null){
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
			this.mainAddressTypeDTO = new AddressTypeDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			addressTypeServiceImpl.saveNew(this.mainAddressTypeDTO);
			this.selectedAddressTypeDTO = this.mainAddressTypeDTO;
			this.mainAddressTypeDTO = new AddressTypeDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Address Type was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			addressTypeServiceImpl.update(this.mainAddressTypeDTO);
			this.selectedAddressTypeDTO = this.mainAddressTypeDTO;
			this.mainAddressTypeDTO = new AddressTypeDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Address Type was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			addressTypeServiceImpl.delete(this.selectedAddressTypeDTO);
			this.selectedAddressTypeDTO = this.mainAddressTypeDTO;
			this.mainAddressTypeDTO = new AddressTypeDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Address Type was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaAddressTypeDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaAddressTypeDTO = new AddressTypeDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(AddressTypeDTO addressType){
		try{
			this.selectedAddressTypeDTO = addressType;
			if(this.selectedAddressTypeDTO == null || this.selectedAddressTypeDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				addressTypeServiceImpl.delete(this.selectedAddressTypeDTO);
				this.selectedAddressTypeDTO = this.mainAddressTypeDTO;
				this.mainAddressTypeDTO = new AddressTypeDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Address Type was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(AddressTypeDTO addressType){
		this.selectedAddressTypeDTO = addressType;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedAddressTypeDTO = (AddressTypeDTO) event.getObject();
	}

	public AddressTypeServiceImpl getAddressTypeServiceImpl() {
			return addressTypeServiceImpl;
	}

	public void setAddressTypeServiceImpl(AddressTypeServiceImpl addressTypeServiceImpl) {

		this.addressTypeServiceImpl = addressTypeServiceImpl;

	}

	public LazyDataModelUtil<AddressTypeDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<AddressTypeDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public AddressTypeDTO getSelectedAddressTypeDTO() {

		return selectedAddressTypeDTO;

	}

	public void setSelectedAddressTypeDTO(AddressTypeDTO selectedAddressTypeDTO) {

		this.selectedAddressTypeDTO = selectedAddressTypeDTO;

	}

	public AddressTypeDTO getMainAddressTypeDTO() {

		return mainAddressTypeDTO;

	}

	public void setMainAddressTypeDTO(AddressTypeDTO mainAddressTypeDTO) {

		this.mainAddressTypeDTO = mainAddressTypeDTO;

	}

	public AddressTypeDTO getCriteriaAddressTypeDTO() {

		return criteriaAddressTypeDTO;

	}

	public void setCriteriaAddressTypeDTO(AddressTypeDTO criteriaAddressTypeDTO) {

		this.criteriaAddressTypeDTO = criteriaAddressTypeDTO;

	}
}
