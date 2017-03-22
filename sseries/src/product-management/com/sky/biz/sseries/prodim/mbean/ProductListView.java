package com.sky.biz.sseries.prodim.mbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.sky.biz.sseries.mbean.AbstractController;
import com.sky.biz.sseries.mbean.ControlView;
import com.sky.biz.sseries.prodim.dto.*;
import com.sky.biz.sseries.prodim.services.impl.ProductMasterService;
import com.sky.biz.sseries.prodim.services.impl.ProductTypeService;
import com.sky.biz.sseries.prodim.services.impl.UomService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.List;

@ManagedBean(name = "productListView")
@SessionScoped
public class ProductListView extends AbstractController{

	@ManagedProperty(value="#{productMasterService}")
	private ProductMasterService productMasterService;
	@ManagedProperty(value="#{productTypeService}")
	private ProductTypeService productTypeService;
	@ManagedProperty(value="#{uomService}")
	private UomService uomService;
	
	private ProductMasterDTO productMaster;
	private ProductMasterDTO selectedProductMaster;
	private List<ProductMasterDTO> productList;
	private List<ProductTypeDTO> productTypes;
	private List<UomDTO> uoms;
	
	@PostConstruct
	public void init() {
		productMaster = new ProductMasterDTO();
		productList = productMasterService.loadData(0,10);
		productTypes = productTypeService.loadAllProductType();
		uoms = uomService.loadAllUom();
	}
	
	public void buttonAction(ActionEvent actionEvent) {
        addMessage("Product Master was created already!!");
    }
	
	public void openProductView(ActionEvent actionEvent){
		controlView.doNav2("app/product-info/product-view");
	}
	
	
	public void saveAction(ActionEvent actionEvent){
		try {
			productMasterService.save(productMaster);
			this.selectedProductMaster = productMaster;
			this.productMaster = new ProductMasterDTO(); 
			addMessage("Product Master was created already!!");
			controlView.doNav2("app/product-info/product-view");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessage(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	public void saveAction2(ActionEvent actionEvent){
		try {
			productMasterService.save(productMaster);
			addMessage("Product Master was created already22");
		} catch (Exception e) {
			addMessage(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public List<ProductMasterDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductMasterDTO> productList) {
		this.productList = productList;
	}

	public ProductMasterService getProductMasterService() {
		return productMasterService;
	}

	public void setProductMasterService(ProductMasterService productMasterService) {
		this.productMasterService = productMasterService;
	}

	public ProductMasterDTO getProductMaster() {
		return productMaster;
	}

	public void setProductMaster(ProductMasterDTO productMaster) {
		this.productMaster = productMaster;
	}

	public ProductMasterDTO getSelectedProductMaster() {
		return selectedProductMaster;
	}

	public void setSelectedProductMaster(ProductMasterDTO selectedProductMaster) {
		this.selectedProductMaster = selectedProductMaster;
	}

	public List<ProductTypeDTO> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<ProductTypeDTO> productTypes) {
		this.productTypes = productTypes;
	}

	public List<UomDTO> getUoms() {
		return uoms;
	}

	public void setUoms(List<UomDTO> uoms) {
		this.uoms = uoms;
	}

	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	public UomService getUomService() {
		return uomService;
	}

	public void setUomService(UomService uomService) {
		this.uomService = uomService;
	}

}
