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
public class AbstractBuildingController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<BuildingDTO> lazyData;
	@ManagedProperty(value="#{buildingService}")
	private IBuildingService buildingService;
	private BuildingDTO selectedBuildingDTO;
	private BuildingDTO mainBuildingDTO;
	private BuildingDTO criteriaBuildingDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/apm/master/building-create";
		this.editView="app/apm/master/building-edit";
		this.listView="app/apm/master/building-list";
		this.readView="app/apm/master/building-view";
		this.selectedBuildingDTO = new BuildingDTO();
		this.criteriaBuildingDTO = new BuildingDTO();
		this.mainBuildingDTO = new BuildingDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<BuildingDTO>(buildingService);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedBuildingDTO == null || this.selectedBuildingDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainBuildingDTO = this.selectedBuildingDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedBuildingDTO == null || this.selectedBuildingDTO.getId() == null){
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
			this.mainBuildingDTO = new BuildingDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			buildingService.saveNew(this.mainBuildingDTO);
			this.selectedBuildingDTO = this.mainBuildingDTO;
			this.mainBuildingDTO = new BuildingDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Building was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			buildingService.update(this.mainBuildingDTO);
			this.selectedBuildingDTO = this.mainBuildingDTO;
			this.mainBuildingDTO = new BuildingDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Building was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			buildingService.delete(this.selectedBuildingDTO);
			this.selectedBuildingDTO = this.mainBuildingDTO;
			this.mainBuildingDTO = new BuildingDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Building was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaBuildingDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaBuildingDTO = new BuildingDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(BuildingDTO building){
		try{
			this.selectedBuildingDTO = building;
			if(this.selectedBuildingDTO == null || this.selectedBuildingDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				buildingService.delete(this.selectedBuildingDTO);
				this.selectedBuildingDTO = this.mainBuildingDTO;
				this.mainBuildingDTO = new BuildingDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Building was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(BuildingDTO building){
		this.selectedBuildingDTO = building;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedBuildingDTO = (BuildingDTO) event.getObject();
	}

	public IBuildingService getBuildingService() {
			return buildingService;
	}

	public void setBuildingService(IBuildingService buildingService) {

		this.buildingService = buildingService;

	}

	public LazyDataModelUtil<BuildingDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<BuildingDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public BuildingDTO getSelectedBuildingDTO() {

		return selectedBuildingDTO;

	}

	public void setSelectedBuildingDTO(BuildingDTO selectedBuildingDTO) {

		this.selectedBuildingDTO = selectedBuildingDTO;

	}

	public BuildingDTO getMainBuildingDTO() {

		return mainBuildingDTO;

	}

	public void setMainBuildingDTO(BuildingDTO mainBuildingDTO) {

		this.mainBuildingDTO = mainBuildingDTO;

	}

	public BuildingDTO getCriteriaBuildingDTO() {

		return criteriaBuildingDTO;

	}

	public void setCriteriaBuildingDTO(BuildingDTO criteriaBuildingDTO) {

		this.criteriaBuildingDTO = criteriaBuildingDTO;

	}
}
