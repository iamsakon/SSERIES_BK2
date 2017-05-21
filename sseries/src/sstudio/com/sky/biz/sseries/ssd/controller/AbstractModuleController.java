/**
 *
 */
package com.sky.biz.sseries.ssd.controller;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import com.sky.biz.sseries.mbean.AbstractController;
import com.sky.biz.sseries.mbean.IBasicController;
import com.sky.biz.sseries.mbean.LazyDataModelUtil;
import com.sky.biz.sseries.ssd.dto.*;
import com.sky.biz.sseries.ssd.services.*;

import com.sky.biz.sseries.util.JsfUtil;

import com.sky.biz.sseries.util.SpecificationsUtil;
import org.primefaces.event.SelectEvent;
public class AbstractModuleController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<ModuleDTO> lazyData;
	@ManagedProperty(value="#{moduleService}")
	private IModuleService moduleService;
	private ModuleDTO selectedModuleDTO;
	private ModuleDTO mainModuleDTO;
	private ModuleDTO criteriaModuleDTO;
	private List<ProductDTO> productList;
	@ManagedProperty(value="#{productService}")
	private IProductService productService;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/ssd/master/module-create";
		this.editView="app/ssd/master/module-edit";
		this.listView="app/ssd/master/module-list";
		this.readView="app/ssd/master/module-view";
		this.selectedModuleDTO = new ModuleDTO();
		this.criteriaModuleDTO = new ModuleDTO();
		this.mainModuleDTO = new ModuleDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<ModuleDTO>(moduleService);
		this.productList = this.productService.loadActiveProduct();
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedModuleDTO == null || this.selectedModuleDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainModuleDTO = this.selectedModuleDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedModuleDTO == null || this.selectedModuleDTO.getId() == null){
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
			this.mainModuleDTO = new ModuleDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			moduleService.saveNew(this.mainModuleDTO);
			this.selectedModuleDTO = this.mainModuleDTO;
			this.mainModuleDTO = new ModuleDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Module was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			moduleService.update(this.mainModuleDTO);
			this.selectedModuleDTO = this.mainModuleDTO;
			this.mainModuleDTO = new ModuleDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Module was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			moduleService.delete(this.selectedModuleDTO);
			this.selectedModuleDTO = this.mainModuleDTO;
			this.mainModuleDTO = new ModuleDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Module was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaModuleDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaModuleDTO = new ModuleDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(ModuleDTO module){
		try{
			this.selectedModuleDTO = module;
			if(this.selectedModuleDTO == null || this.selectedModuleDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				moduleService.delete(this.selectedModuleDTO);
				this.selectedModuleDTO = this.mainModuleDTO;
				this.mainModuleDTO = new ModuleDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Module was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(ModuleDTO module){
		this.selectedModuleDTO = module;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedModuleDTO = (ModuleDTO) event.getObject();
	}

	public IModuleService getModuleService() {
			return moduleService;
	}

	public void setModuleService(IModuleService moduleService) {
		this.moduleService = moduleService;

	}

	public LazyDataModelUtil<ModuleDTO> getLazyData() {
		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<ModuleDTO> lazyData) {
		this.lazyData = lazyData;

	}

	public ModuleDTO getSelectedModuleDTO() {
		return selectedModuleDTO;

	}

	public void setSelectedModuleDTO(ModuleDTO selectedModuleDTO) {
		this.selectedModuleDTO = selectedModuleDTO;

	}

	public ModuleDTO getMainModuleDTO() {
		return mainModuleDTO;

	}

	public void setMainModuleDTO(ModuleDTO mainModuleDTO) {
		this.mainModuleDTO = mainModuleDTO;

	}

	public ModuleDTO getCriteriaModuleDTO() {
		return criteriaModuleDTO;

	}

	public void setCriteriaModuleDTO(ModuleDTO criteriaModuleDTO) {
		this.criteriaModuleDTO = criteriaModuleDTO;

	}
	public IProductService getProductService() {
		return productService;
	}
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public List<ProductDTO> getProductList(){
		return this.productList;
	}
	public void setProductList(List<ProductDTO> productList) {
		this.productList = productList;
	}
}
