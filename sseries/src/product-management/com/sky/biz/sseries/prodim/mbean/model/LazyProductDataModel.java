package com.sky.biz.sseries.prodim.mbean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import com.sky.biz.sseries.prodim.dto.ProductMasterDTO;
import com.sky.biz.sseries.prodim.services.impl.ProductMasterService;


public class LazyProductDataModel extends LazyDataModel<ProductMasterDTO> {

	private ProductMasterService service;
	
	private List<ProductMasterDTO> datasource;
	
	public LazyProductDataModel(){
		//datasource = this.load(1, 20, "", null,null);
	}
	
	public LazyProductDataModel(ProductMasterService service){
		this.service = service;
		//datasource = this.load(1, 20, "", null,null);
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public ProductMasterDTO getRowData(String rowKey) {
		datasource = (List<ProductMasterDTO>)getWrappedData();
        for(ProductMasterDTO productMasterDTO : datasource) {
            if(productMasterDTO.getId().toString().equals(rowKey))
                return productMasterDTO;
        }
        return null;
    }
 
    @Override
    public Object getRowKey(ProductMasterDTO productMasterDTO) {
        return productMasterDTO.getId();
    }
    
    @Override
    public List<ProductMasterDTO> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String,Object> filters) {
        return this.load(1, 20, "", null,null);
    }
    
    @Override
    public List<ProductMasterDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<ProductMasterDTO> data = new ArrayList<ProductMasterDTO>();
        data = service.loadData(first, pageSize);
        setWrappedData(data);
        this.setRowCount(data.size());
        return data;
    }
}
