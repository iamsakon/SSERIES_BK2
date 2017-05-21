/**
 *
 */
package com.sky.biz.sseries.apm.controller;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import com.sky.biz.sseries.mbean.AbstractController;
import com.sky.biz.sseries.mbean.IBasicController;
import com.sky.biz.sseries.mbean.LazyDataModelUtil;
import com.sky.biz.sseries.apm.dto.*;
import com.sky.biz.sseries.apm.services.*;
import com.sky.biz.sseries.util.JsfUtil;

import com.sky.biz.sseries.util.SpecificationsUtil;
import org.primefaces.event.SelectEvent;
public class AbstractMeterTypeController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<MeterTypeDTO> lazyData;
	@ManagedProperty(value="#{meterTypeService}")
	private IMeterTypeService meterTypeService;
	private MeterTypeDTO selectedMeterTypeDTO;
	private MeterTypeDTO mainMeterTypeDTO;
	private MeterTypeDTO criteriaMeterTypeDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/apm/master/meter-type-create";
		this.editView="app/apm/master/meter-type-edit";
		this.listView="app/apm/master/meter-type-list";
		this.readView="app/apm/master/meter-type-view";
		this.selectedMeterTypeDTO = new MeterTypeDTO();
		this.criteriaMeterTypeDTO = new MeterTypeDTO();
		this.mainMeterTypeDTO = new MeterTypeDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<MeterTypeDTO>(meterTypeService);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedMeterTypeDTO == null || this.selectedMeterTypeDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainMeterTypeDTO = this.selectedMeterTypeDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedMeterTypeDTO == null || this.selectedMeterTypeDTO.getId() == null){
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
			this.mainMeterTypeDTO = new MeterTypeDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			meterTypeService.saveNew(this.mainMeterTypeDTO);
			this.selectedMeterTypeDTO = this.mainMeterTypeDTO;
			this.mainMeterTypeDTO = new MeterTypeDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Meter Type was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			meterTypeService.update(this.mainMeterTypeDTO);
			this.selectedMeterTypeDTO = this.mainMeterTypeDTO;
			this.mainMeterTypeDTO = new MeterTypeDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Meter Type was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			meterTypeService.delete(this.selectedMeterTypeDTO);
			this.selectedMeterTypeDTO = this.mainMeterTypeDTO;
			this.mainMeterTypeDTO = new MeterTypeDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Meter Type was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaMeterTypeDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaMeterTypeDTO = new MeterTypeDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(MeterTypeDTO meterType){
		try{
			this.selectedMeterTypeDTO = meterType;
			if(this.selectedMeterTypeDTO == null || this.selectedMeterTypeDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				meterTypeService.delete(this.selectedMeterTypeDTO);
				this.selectedMeterTypeDTO = this.mainMeterTypeDTO;
				this.mainMeterTypeDTO = new MeterTypeDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Meter Type was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(MeterTypeDTO meterType){
		this.selectedMeterTypeDTO = meterType;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedMeterTypeDTO = (MeterTypeDTO) event.getObject();
	}

	public IMeterTypeService getMeterTypeService() {
			return meterTypeService;
	}

	public void setMeterTypeService(IMeterTypeService meterTypeService) {

		this.meterTypeService = meterTypeService;

	}

	public LazyDataModelUtil<MeterTypeDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<MeterTypeDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public MeterTypeDTO getSelectedMeterTypeDTO() {

		return selectedMeterTypeDTO;

	}

	public void setSelectedMeterTypeDTO(MeterTypeDTO selectedMeterTypeDTO) {

		this.selectedMeterTypeDTO = selectedMeterTypeDTO;

	}

	public MeterTypeDTO getMainMeterTypeDTO() {

		return mainMeterTypeDTO;

	}

	public void setMainMeterTypeDTO(MeterTypeDTO mainMeterTypeDTO) {

		this.mainMeterTypeDTO = mainMeterTypeDTO;

	}

	public MeterTypeDTO getCriteriaMeterTypeDTO() {

		return criteriaMeterTypeDTO;

	}

	public void setCriteriaMeterTypeDTO(MeterTypeDTO criteriaMeterTypeDTO) {

		this.criteriaMeterTypeDTO = criteriaMeterTypeDTO;

	}
}
