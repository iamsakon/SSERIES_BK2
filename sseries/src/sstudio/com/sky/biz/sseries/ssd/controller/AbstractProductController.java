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
public class AbstractProductController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<ProductDTO> lazyData;
	@ManagedProperty(value="#{productService}")
	private IProductService productService;
	private ProductDTO selectedProductDTO;
	private ProductDTO mainProductDTO;
	private ProductDTO criteriaProductDTO;
	

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/ssd/master/product-create";
		this.editView="app/ssd/master/product-edit";
		this.listView="app/ssd/master/product-list";
		this.readView="app/ssd/master/product-view";
		this.selectedProductDTO = new ProductDTO();
		this.criteriaProductDTO = new ProductDTO();
		this.mainProductDTO = new ProductDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<ProductDTO>(productService);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedProductDTO == null || this.selectedProductDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainProductDTO = this.selectedProductDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedProductDTO == null || this.selectedProductDTO.getId() == null){
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
			this.mainProductDTO = new ProductDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			productService.saveNew(this.mainProductDTO);
			this.selectedProductDTO = this.mainProductDTO;
			this.mainProductDTO = new ProductDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Product was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			productService.update(this.mainProductDTO);
			this.selectedProductDTO = this.mainProductDTO;
			this.mainProductDTO = new ProductDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Product was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			productService.delete(this.selectedProductDTO);
			this.selectedProductDTO = this.mainProductDTO;
			this.mainProductDTO = new ProductDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Product was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaProductDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaProductDTO = new ProductDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(ProductDTO product){
		try{
			this.selectedProductDTO = product;
			if(this.selectedProductDTO == null || this.selectedProductDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				productService.delete(this.selectedProductDTO);
				this.selectedProductDTO = this.mainProductDTO;
				this.mainProductDTO = new ProductDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Product was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(ProductDTO product){
		this.selectedProductDTO = product;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedProductDTO = (ProductDTO) event.getObject();
	}

	public IProductService getProductService() {
			return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;

	}

	public LazyDataModelUtil<ProductDTO> getLazyData() {
		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<ProductDTO> lazyData) {
		this.lazyData = lazyData;

	}

	public ProductDTO getSelectedProductDTO() {
		return selectedProductDTO;

	}

	public void setSelectedProductDTO(ProductDTO selectedProductDTO) {
		this.selectedProductDTO = selectedProductDTO;

	}

	public ProductDTO getMainProductDTO() {
		return mainProductDTO;

	}

	public void setMainProductDTO(ProductDTO mainProductDTO) {
		this.mainProductDTO = mainProductDTO;

	}

	public ProductDTO getCriteriaProductDTO() {
		return criteriaProductDTO;

	}

	public void setCriteriaProductDTO(ProductDTO criteriaProductDTO) {
		this.criteriaProductDTO = criteriaProductDTO;

	}
}
