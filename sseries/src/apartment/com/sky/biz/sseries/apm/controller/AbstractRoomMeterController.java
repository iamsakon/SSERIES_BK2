/**
 *
 */
package com.sky.biz.sseries.apm.controller;
import java.util.*;
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
public class AbstractRoomMeterController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<RoomMeterDTO> lazyData;
	@ManagedProperty(value="#{roomMeterService}")
	private IRoomMeterService roomMeterService;
	private RoomMeterDTO selectedRoomMeterDTO;
	private RoomMeterDTO mainRoomMeterDTO;
	private RoomMeterDTO criteriaRoomMeterDTO;
	private List<MeterTypeDTO> meterTypeList;
	
	private List<RoomDTO> roomList;
	@ManagedProperty(value="#{meterTypeService}")
	private IMeterTypeService meterTypeService;
	@ManagedProperty(value="#{roomService}")
	private IRoomService roomService;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/apm/master/room-meter-create";
		this.editView="app/apm/master/room-meter-edit";
		this.listView="app/apm/master/room-meter-list";
		this.readView="app/apm/master/room-meter-view";
		this.selectedRoomMeterDTO = new RoomMeterDTO();
		this.criteriaRoomMeterDTO = new RoomMeterDTO();
		this.mainRoomMeterDTO = new RoomMeterDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<RoomMeterDTO>(roomMeterService);
		this.meterTypeList = this.meterTypeService.loadActiveMeterType();
	
		this.roomList = this.roomService.loadActiveRoom();
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedRoomMeterDTO == null || this.selectedRoomMeterDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainRoomMeterDTO = this.selectedRoomMeterDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedRoomMeterDTO == null || this.selectedRoomMeterDTO.getId() == null){
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
			this.mainRoomMeterDTO = new RoomMeterDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			roomMeterService.saveNew(this.mainRoomMeterDTO);
			this.selectedRoomMeterDTO = this.mainRoomMeterDTO;
			this.mainRoomMeterDTO = new RoomMeterDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Room Meter was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			roomMeterService.update(this.mainRoomMeterDTO);
			this.selectedRoomMeterDTO = this.mainRoomMeterDTO;
			this.mainRoomMeterDTO = new RoomMeterDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Room Meter was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			roomMeterService.delete(this.selectedRoomMeterDTO);
			this.selectedRoomMeterDTO = this.mainRoomMeterDTO;
			this.mainRoomMeterDTO = new RoomMeterDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Room Meter was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaRoomMeterDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaRoomMeterDTO = new RoomMeterDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(RoomMeterDTO roomMeter){
		try{
			this.selectedRoomMeterDTO = roomMeter;
			if(this.selectedRoomMeterDTO == null || this.selectedRoomMeterDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				roomMeterService.delete(this.selectedRoomMeterDTO);
				this.selectedRoomMeterDTO = this.mainRoomMeterDTO;
				this.mainRoomMeterDTO = new RoomMeterDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Room Meter was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(RoomMeterDTO roomMeter){
		this.selectedRoomMeterDTO = roomMeter;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedRoomMeterDTO = (RoomMeterDTO) event.getObject();
	}

	public IRoomMeterService getRoomMeterService() {
			return roomMeterService;
	}

	public void setRoomMeterService(IRoomMeterService roomMeterService) {
		this.roomMeterService = roomMeterService;

	}

	public LazyDataModelUtil<RoomMeterDTO> getLazyData() {
		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<RoomMeterDTO> lazyData) {
		this.lazyData = lazyData;

	}

	public RoomMeterDTO getSelectedRoomMeterDTO() {
		return selectedRoomMeterDTO;

	}

	public void setSelectedRoomMeterDTO(RoomMeterDTO selectedRoomMeterDTO) {
		this.selectedRoomMeterDTO = selectedRoomMeterDTO;

	}

	public RoomMeterDTO getMainRoomMeterDTO() {
		return mainRoomMeterDTO;

	}

	public void setMainRoomMeterDTO(RoomMeterDTO mainRoomMeterDTO) {
		this.mainRoomMeterDTO = mainRoomMeterDTO;

	}

	public RoomMeterDTO getCriteriaRoomMeterDTO() {
		return criteriaRoomMeterDTO;

	}

	public void setCriteriaRoomMeterDTO(RoomMeterDTO criteriaRoomMeterDTO) {
		this.criteriaRoomMeterDTO = criteriaRoomMeterDTO;

	}
	public IMeterTypeService getMeterTypeService() {
		return meterTypeService;
	}
	public void setMeterTypeService(IMeterTypeService meterTypeService) {
		this.meterTypeService = meterTypeService;
	}
	
	public IRoomService getRoomService() {
		return roomService;
	}
	public void setRoomService(IRoomService roomService) {
		this.roomService = roomService;
	}
	public List<MeterTypeDTO> getMeterTypeList(){
		return this.meterTypeList;
	}
	public void setMeterTypeList(List<MeterTypeDTO> meterTypeList) {
		this.meterTypeList = meterTypeList;
	}
	
	public List<RoomDTO> getRoomList(){
		return this.roomList;
	}
	public void setRoomList(List<RoomDTO> roomList) {
		this.roomList = roomList;
	}
}
