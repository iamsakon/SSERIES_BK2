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
public class AbstractRoomTypeController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<RoomTypeDTO> lazyData;
	@ManagedProperty(value="#{roomTypeService}")
	private IRoomTypeService roomTypeService;
	private RoomTypeDTO selectedRoomTypeDTO;
	private RoomTypeDTO mainRoomTypeDTO;
	private RoomTypeDTO criteriaRoomTypeDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/apm/master/room-type-create";
		this.editView="app/apm/master/room-type-edit";
		this.listView="app/apm/master/room-type-list";
		this.readView="app/apm/master/room-type-view";
		this.selectedRoomTypeDTO = new RoomTypeDTO();
		this.criteriaRoomTypeDTO = new RoomTypeDTO();
		this.mainRoomTypeDTO = new RoomTypeDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<RoomTypeDTO>(roomTypeService);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedRoomTypeDTO == null || this.selectedRoomTypeDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainRoomTypeDTO = this.selectedRoomTypeDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedRoomTypeDTO == null || this.selectedRoomTypeDTO.getId() == null){
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
			this.mainRoomTypeDTO = new RoomTypeDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			roomTypeService.saveNew(this.mainRoomTypeDTO);
			this.selectedRoomTypeDTO = this.mainRoomTypeDTO;
			this.mainRoomTypeDTO = new RoomTypeDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Room Type was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			roomTypeService.update(this.mainRoomTypeDTO);
			this.selectedRoomTypeDTO = this.mainRoomTypeDTO;
			this.mainRoomTypeDTO = new RoomTypeDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Room Type was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			roomTypeService.delete(this.selectedRoomTypeDTO);
			this.selectedRoomTypeDTO = this.mainRoomTypeDTO;
			this.mainRoomTypeDTO = new RoomTypeDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Room Type was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaRoomTypeDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaRoomTypeDTO = new RoomTypeDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(RoomTypeDTO roomType){
		try{
			this.selectedRoomTypeDTO = roomType;
			if(this.selectedRoomTypeDTO == null || this.selectedRoomTypeDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				roomTypeService.delete(this.selectedRoomTypeDTO);
				this.selectedRoomTypeDTO = this.mainRoomTypeDTO;
				this.mainRoomTypeDTO = new RoomTypeDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Room Type was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(RoomTypeDTO roomType){
		this.selectedRoomTypeDTO = roomType;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedRoomTypeDTO = (RoomTypeDTO) event.getObject();
	}

	public IRoomTypeService getRoomTypeService() {
			return roomTypeService;
	}

	public void setRoomTypeService(IRoomTypeService roomTypeService) {

		this.roomTypeService = roomTypeService;

	}

	public LazyDataModelUtil<RoomTypeDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<RoomTypeDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public RoomTypeDTO getSelectedRoomTypeDTO() {

		return selectedRoomTypeDTO;

	}

	public void setSelectedRoomTypeDTO(RoomTypeDTO selectedRoomTypeDTO) {

		this.selectedRoomTypeDTO = selectedRoomTypeDTO;

	}

	public RoomTypeDTO getMainRoomTypeDTO() {

		return mainRoomTypeDTO;

	}

	public void setMainRoomTypeDTO(RoomTypeDTO mainRoomTypeDTO) {

		this.mainRoomTypeDTO = mainRoomTypeDTO;

	}

	public RoomTypeDTO getCriteriaRoomTypeDTO() {

		return criteriaRoomTypeDTO;

	}

	public void setCriteriaRoomTypeDTO(RoomTypeDTO criteriaRoomTypeDTO) {

		this.criteriaRoomTypeDTO = criteriaRoomTypeDTO;

	}
}
