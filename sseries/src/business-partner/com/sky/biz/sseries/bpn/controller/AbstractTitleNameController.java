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
public class AbstractTitleNameController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<TitleNameDTO> lazyData;
	@ManagedProperty(value="#{titleNameServiceImpl}")
	private TitleNameServiceImpl titleNameServiceImpl;
	private TitleNameDTO selectedTitleNameDTO;
	private TitleNameDTO mainTitleNameDTO;
	private TitleNameDTO criteriaTitleNameDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/bpn/title-name-create";
		this.editView="app/bpn/title-name-edit";
		this.listView="app/bpn/title-name-list";
		this.readView="app/bpn/title-name-view";
		this.selectedTitleNameDTO = new TitleNameDTO();
		this.criteriaTitleNameDTO = new TitleNameDTO();
		this.mainTitleNameDTO = new TitleNameDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<TitleNameDTO>(titleNameServiceImpl);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedTitleNameDTO == null || this.selectedTitleNameDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainTitleNameDTO = this.selectedTitleNameDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedTitleNameDTO == null || this.selectedTitleNameDTO.getId() == null){
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
			this.mainTitleNameDTO = new TitleNameDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			titleNameServiceImpl.saveNew(this.mainTitleNameDTO);
			this.selectedTitleNameDTO = this.mainTitleNameDTO;
			this.mainTitleNameDTO = new TitleNameDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Title Name was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			titleNameServiceImpl.update(this.mainTitleNameDTO);
			this.selectedTitleNameDTO = this.mainTitleNameDTO;
			this.mainTitleNameDTO = new TitleNameDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Title Name was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			titleNameServiceImpl.delete(this.selectedTitleNameDTO);
			this.selectedTitleNameDTO = this.mainTitleNameDTO;
			this.mainTitleNameDTO = new TitleNameDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Title Name was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaTitleNameDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaTitleNameDTO = new TitleNameDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(TitleNameDTO titleName){
		try{
			this.selectedTitleNameDTO = titleName;
			if(this.selectedTitleNameDTO == null || this.selectedTitleNameDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				titleNameServiceImpl.delete(this.selectedTitleNameDTO);
				this.selectedTitleNameDTO = this.mainTitleNameDTO;
				this.mainTitleNameDTO = new TitleNameDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Title Name was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(TitleNameDTO titleName){
		this.selectedTitleNameDTO = titleName;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedTitleNameDTO = (TitleNameDTO) event.getObject();
	}

	public TitleNameServiceImpl getTitleNameServiceImpl() {
			return titleNameServiceImpl;
	}

	public void setTitleNameServiceImpl(TitleNameServiceImpl titleNameServiceImpl) {

		this.titleNameServiceImpl = titleNameServiceImpl;

	}

	public LazyDataModelUtil<TitleNameDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<TitleNameDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public TitleNameDTO getSelectedTitleNameDTO() {

		return selectedTitleNameDTO;

	}

	public void setSelectedTitleNameDTO(TitleNameDTO selectedTitleNameDTO) {

		this.selectedTitleNameDTO = selectedTitleNameDTO;

	}

	public TitleNameDTO getMainTitleNameDTO() {

		return mainTitleNameDTO;

	}

	public void setMainTitleNameDTO(TitleNameDTO mainTitleNameDTO) {

		this.mainTitleNameDTO = mainTitleNameDTO;

	}

	public TitleNameDTO getCriteriaTitleNameDTO() {

		return criteriaTitleNameDTO;

	}

	public void setCriteriaTitleNameDTO(TitleNameDTO criteriaTitleNameDTO) {

		this.criteriaTitleNameDTO = criteriaTitleNameDTO;

	}
}
