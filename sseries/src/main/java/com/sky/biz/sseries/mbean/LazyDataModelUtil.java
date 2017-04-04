/**
 * 
 */
package com.sky.biz.sseries.mbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import com.sky.biz.sseries.dto.AbstractDTO;
import com.sky.biz.sseries.services.ISSeriesServices;
import com.sky.biz.sseries.usm.dto.UserAccountDTO;
import com.sky.biz.sseries.util.PageDTOUtil;
import com.sky.biz.sseries.util.SpecificationsUtil;
/**
 * @author User
 *
 */
public class LazyDataModelUtil<T> extends LazyDataModel<T> {

	private ISSeriesServices<T> service;
	
	List <AbstractDTO> datasource;
	
	private LazyDataModelUtil(){};
	
	Map<String, Object> criteriaMap = new HashMap<String, Object>();
	
	public Map<String, Object> getCriteriaMap() {
		return criteriaMap;
	}

	public void setCriteriaMap(Map<String, Object> criteriaMap) {
		this.criteriaMap = criteriaMap;
	}

	public LazyDataModelUtil(ISSeriesServices<T> service){
		this.service = service;
	}

	@SuppressWarnings("unchecked")
	@Override
    public T getRowData(String rowKey) {
		List<AbstractDTO> data = (List<AbstractDTO>)this.getWrappedData();
        for(AbstractDTO dto : data) {
            if(dto.getId().toString().equals(rowKey))
                return (T) dto;
        }
        return null;
    }
	
    @Override
    public Object getRowKey(T object) {
    	AbstractDTO dto = (AbstractDTO)object;
        return dto.getId();
    }
	
    @Override
    public List<T> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String,Object> filters) {
        return this.load(1, 20, "", null,null);
    }
    
    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<T> data = new ArrayList<T>();
        int page = 0;
        if(first > 0)
        	page = first/pageSize;
        PageDTOUtil<T> pageDTO = service.loadData(page, pageSize,criteriaMap);
        data = pageDTO.getContents();
        setWrappedData(data);
        this.setRowCount((int)pageDTO.getTotalElements());
      //paginate
//        if(data.size() > pageSize)
//        	data.subList(first,first + pageSize);
        return data;
    }
    
	public ISSeriesServices<T> getService() {
		return service;
	}

	public void setService(ISSeriesServices<T> service) {
		this.service = service;
	}
}
