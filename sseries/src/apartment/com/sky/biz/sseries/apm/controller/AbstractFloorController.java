/**
 *
 */
package com.sky.biz.sseries.apm.controller;
import java.util.HashMap;
import java.util.List;
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
public class AbstractFloorController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<FloorDTO> lazyData;
	@ManagedProperty(value="#{floorService}")
	private IFloorService floorService;
	private FloorDTO selectedFloorDTO;
	private FloorDTO mainFloorDTO;
	private FloorDTO criteriaFloorDTO;	
	/**
	 * 
	 */
	private List<BuildingDTO> buildingList;
	@ManagedProperty(value="#{buildingService}")
	private IBuildingService buildingService;
	
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/apm/master/floor-create";
		this.editView="app/apm/master/floor-edit";
		this.listView="app/apm/master/floor-list";
		this.readView="app/apm/master/floor-view";
		this.selectedFloorDTO = new FloorDTO();
		this.criteriaFloorDTO = new FloorDTO();
		this.mainFloorDTO = new FloorDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<FloorDTO>(floorService);
		this.buildingList = buildingService.loadActiveBuilding();
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedFloorDTO == null || this.selectedFloorDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainFloorDTO = this.selectedFloorDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedFloorDTO == null || this.selectedFloorDTO.getId() == null){
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
			this.mainFloorDTO = new FloorDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			floorService.saveNew(this.mainFloorDTO);
			this.selectedFloorDTO = this.mainFloorDTO;
			this.mainFloorDTO = new FloorDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Floor was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			floorService.update(this.mainFloorDTO);
			this.selectedFloorDTO = this.mainFloorDTO;
			this.mainFloorDTO = new FloorDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Floor was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			floorService.delete(this.selectedFloorDTO);
			this.selectedFloorDTO = this.mainFloorDTO;
			this.mainFloorDTO = new FloorDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Floor was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaFloorDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaFloorDTO = new FloorDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(FloorDTO floor){
		try{
			this.selectedFloorDTO = floor;
			if(this.selectedFloorDTO == null || this.selectedFloorDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				floorService.delete(this.selectedFloorDTO);
				this.selectedFloorDTO = this.mainFloorDTO;
				this.mainFloorDTO = new FloorDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Floor was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(FloorDTO floor){
		this.selectedFloorDTO = floor;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedFloorDTO = (FloorDTO) event.getObject();
	}

	public IFloorService getFloorService() {
			return floorService;
	}
	public void setFloorService(IFloorService floorService) {
		this.floorService = floorService;
	}

	public LazyDataModelUtil<FloorDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<FloorDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public FloorDTO getSelectedFloorDTO() {

		return selectedFloorDTO;

	}

	public void setSelectedFloorDTO(FloorDTO selectedFloorDTO) {

		this.selectedFloorDTO = selectedFloorDTO;

	}

	public FloorDTO getMainFloorDTO() {

		return mainFloorDTO;

	}

	public void setMainFloorDTO(FloorDTO mainFloorDTO) {

		this.mainFloorDTO = mainFloorDTO;

	}

	public FloorDTO getCriteriaFloorDTO() {

		return criteriaFloorDTO;

	}

	public void setCriteriaFloorDTO(FloorDTO criteriaFloorDTO) {

		this.criteriaFloorDTO = criteriaFloorDTO;

	}

	public IBuildingService getBuildingServiceImpl() {
		return buildingService;
	}

	public void setBuildingServiceImpl(IBuildingService buildingService) {
		this.buildingService = buildingService;
	}

	public List<BuildingDTO> getBuildingList() {
		return buildingList;
	}

	public void setBuildingList(List<BuildingDTO> buildingList) {
		this.buildingList = buildingList;
	}

	public IBuildingService getBuildingService() {
		return buildingService;
	}

	public void setBuildingService(IBuildingService buildingService) {
		this.buildingService = buildingService;
	}

}
