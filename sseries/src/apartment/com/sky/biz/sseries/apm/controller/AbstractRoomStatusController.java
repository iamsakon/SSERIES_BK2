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
public class AbstractRoomStatusController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<RoomStatusDTO> lazyData;
	@ManagedProperty(value="#{roomStatusService}")
	private IRoomStatusService roomStatusService;
	private RoomStatusDTO selectedRoomStatusDTO;
	private RoomStatusDTO mainRoomStatusDTO;
	private RoomStatusDTO criteriaRoomStatusDTO;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/apm/master/room-status-create";
		this.editView="app/apm/master/room-status-edit";
		this.listView="app/apm/master/room-status-list";
		this.readView="app/apm/master/room-status-view";
		this.selectedRoomStatusDTO = new RoomStatusDTO();
		this.criteriaRoomStatusDTO = new RoomStatusDTO();
		this.mainRoomStatusDTO = new RoomStatusDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<RoomStatusDTO>(roomStatusService);
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedRoomStatusDTO == null || this.selectedRoomStatusDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainRoomStatusDTO = this.selectedRoomStatusDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedRoomStatusDTO == null || this.selectedRoomStatusDTO.getId() == null){
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
			this.mainRoomStatusDTO = new RoomStatusDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			roomStatusService.saveNew(this.mainRoomStatusDTO);
			this.selectedRoomStatusDTO = this.mainRoomStatusDTO;
			this.mainRoomStatusDTO = new RoomStatusDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Room Status was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			roomStatusService.update(this.mainRoomStatusDTO);
			this.selectedRoomStatusDTO = this.mainRoomStatusDTO;
			this.mainRoomStatusDTO = new RoomStatusDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Room Status was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			roomStatusService.delete(this.selectedRoomStatusDTO);
			this.selectedRoomStatusDTO = this.mainRoomStatusDTO;
			this.mainRoomStatusDTO = new RoomStatusDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Room Status was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaRoomStatusDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaRoomStatusDTO = new RoomStatusDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(RoomStatusDTO roomStatus){
		try{
			this.selectedRoomStatusDTO = roomStatus;
			if(this.selectedRoomStatusDTO == null || this.selectedRoomStatusDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				roomStatusService.delete(this.selectedRoomStatusDTO);
				this.selectedRoomStatusDTO = this.mainRoomStatusDTO;
				this.mainRoomStatusDTO = new RoomStatusDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Room Status was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(RoomStatusDTO roomStatus){
		this.selectedRoomStatusDTO = roomStatus;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedRoomStatusDTO = (RoomStatusDTO) event.getObject();
	}

	public IRoomStatusService getRoomStatusService() {
			return roomStatusService;
	}

	public void setRoomStatusService(IRoomStatusService roomStatusService) {

		this.roomStatusService = roomStatusService;

	}

	public LazyDataModelUtil<RoomStatusDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<RoomStatusDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public RoomStatusDTO getSelectedRoomStatusDTO() {

		return selectedRoomStatusDTO;

	}

	public void setSelectedRoomStatusDTO(RoomStatusDTO selectedRoomStatusDTO) {

		this.selectedRoomStatusDTO = selectedRoomStatusDTO;

	}

	public RoomStatusDTO getMainRoomStatusDTO() {

		return mainRoomStatusDTO;

	}

	public void setMainRoomStatusDTO(RoomStatusDTO mainRoomStatusDTO) {

		this.mainRoomStatusDTO = mainRoomStatusDTO;

	}

	public RoomStatusDTO getCriteriaRoomStatusDTO() {

		return criteriaRoomStatusDTO;

	}

	public void setCriteriaRoomStatusDTO(RoomStatusDTO criteriaRoomStatusDTO) {

		this.criteriaRoomStatusDTO = criteriaRoomStatusDTO;

	}
}
