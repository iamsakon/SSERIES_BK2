package com.sky.biz.sseries.prodim.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import com.sky.biz.sseries.mbean.AbstractController;
import com.sky.biz.sseries.mbean.IBasicController;
import com.sky.biz.sseries.mbean.LazyDataModelUtil;
import com.sky.biz.sseries.prodim.dto.ProductMasterDTO;
import com.sky.biz.sseries.prodim.dto.ProductTypeDTO;
import com.sky.biz.sseries.prodim.dto.UomDTO;
import com.sky.biz.sseries.prodim.services.impl.ProductMasterService;
import com.sky.biz.sseries.prodim.services.impl.ProductTypeService;
import com.sky.biz.sseries.prodim.services.impl.UomService;
import com.sky.biz.sseries.util.JsfUtil;

@ManagedBean(name = "productController")
@SessionScoped
public class ProductController extends AbstractController implements IBasicController {
	
	//private LazyProductDataModel lazyModel;
	private LazyDataModelUtil<ProductMasterDTO> lazyDataModelUtil;
	
	@ManagedProperty(value="#{productMasterService}")
	private ProductMasterService<ProductMasterDTO> productMasterService;
	@ManagedProperty(value="#{productTypeService}")
	private ProductTypeService productTypeService;
	@ManagedProperty(value="#{uomService}")
	private UomService uomService;
	
	private List<ColumnModel> columns;
	
	private ProductMasterDTO criteria;
	private ProductMasterDTO productMaster;
	private ProductMasterDTO selectedProductMaster;
	private List<ProductMasterDTO> productList;
	private List<ProductTypeDTO> productTypes;
	private List<UomDTO> uoms;
	
	@PostConstruct
	public void init() {
		productMaster = new ProductMasterDTO();
		criteria = new ProductMasterDTO();
		//productList = productMasterService.loadAllProduct();
		productTypes = productTypeService.loadAllProductType();
		uoms = uomService.loadAllUom();
		lazyDataModelUtil = new LazyDataModelUtil<ProductMasterDTO>(productMasterService);
		getDynamicColumns();
	}
	
	@Override
	public void newAction(ActionEvent actionEvent) {
		this.setCurrentSubView("app/product-info/product-create");
	}

	@Override
	public void saveAction(ActionEvent actionEvent) {
		try {
			productMasterService.save(productMaster);
			this.selectedProductMaster = productMaster;
			this.productMaster = new ProductMasterDTO(); 
			JsfUtil.addSuccessMessage("Product Master was created already!!");
			this.setCurrentSubView("app/product-info/product-view");
		} catch (Exception ex) {
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	@Override
	public void getDynamicColumns() {
		// TODO Auto-generated method stub
		columns = new ArrayList<ColumnModel>();
		columns.add(new ColumnModel("Code","code"));
		columns.add(new ColumnModel("Name","name"));
		columns.add(new ColumnModel("Short Description","shortDescription"));
		columns.add(new ColumnModel("Product Type","product.productType.name"));
	}
	
	@Override
	public void findAction(ActionEvent actionEvent){
		this.setCurrentSubView("app/product-info/product-list");
	}

	@Override
	public void viewAction(ActionEvent actionEvent) {
		this.setCurrentSubView("app/product-info/product-view");
	}

	@Override
	public void updateAction(ActionEvent actionEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAction(ActionEvent actionEvent) {
		// TODO Auto-generated method stub

	}
	
    public void onRowSelect(SelectEvent event) {
    	this.setCurrentSubView("app/product-info/product-view");
    }

//    public void onRowUnselect(UnselectEvent event) {
//        FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }

	public ProductMasterService<ProductMasterDTO> getProductMasterService() {
		return productMasterService;
	}

	public void setProductMasterService(ProductMasterService<ProductMasterDTO> productMasterService) {
		this.productMasterService = productMasterService;
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

	public List<ProductMasterDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductMasterDTO> productList) {
		this.productList = productList;
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

	public List<ColumnModel> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}

	public ProductMasterDTO getCriteria() {
		return criteria;
	}

	public void setCriteria(ProductMasterDTO criteria) {
		this.criteria = criteria;
	}

	public LazyDataModelUtil<ProductMasterDTO> getLazyDataModelUtil() {
		return lazyDataModelUtil;
	}

	public void setLazyDataModelUtil(LazyDataModelUtil<ProductMasterDTO> lazyDataModelUtil) {
		this.lazyDataModelUtil = lazyDataModelUtil;
	}



}
