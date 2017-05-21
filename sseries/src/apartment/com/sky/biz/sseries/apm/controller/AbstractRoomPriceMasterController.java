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
public class AbstractRoomPriceMasterController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<RoomPriceMasterDTO> lazyData;
	@ManagedProperty(value="#{roomPriceMasterService}")
	private IRoomPriceMasterService roomPriceMasterService;
	private RoomPriceMasterDTO selectedRoomPriceMasterDTO;
	private RoomPriceMasterDTO mainRoomPriceMasterDTO;
	private RoomPriceMasterDTO criteriaRoomPriceMasterDTO;
	private List<RoomTypeDTO> roomTypeList;
	@ManagedProperty(value="#{roomTypeService}")
	private IRoomTypeService roomTypeService;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/apm/master/room-price-master-create";
		this.editView="app/apm/master/room-price-master-edit";
		this.listView="app/apm/master/room-price-master-list";
		this.readView="app/apm/master/room-price-master-view";
		this.selectedRoomPriceMasterDTO = new RoomPriceMasterDTO();
		this.criteriaRoomPriceMasterDTO = new RoomPriceMasterDTO();
		this.mainRoomPriceMasterDTO = new RoomPriceMasterDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<RoomPriceMasterDTO>(roomPriceMasterService);
		this.roomTypeList = this.roomTypeService.loadActiveRoomType();
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedRoomPriceMasterDTO == null || this.selectedRoomPriceMasterDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainRoomPriceMasterDTO = this.selectedRoomPriceMasterDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedRoomPriceMasterDTO == null || this.selectedRoomPriceMasterDTO.getId() == null){
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
			this.mainRoomPriceMasterDTO = new RoomPriceMasterDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			roomPriceMasterService.saveNew(this.mainRoomPriceMasterDTO);
			this.selectedRoomPriceMasterDTO = this.mainRoomPriceMasterDTO;
			this.mainRoomPriceMasterDTO = new RoomPriceMasterDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Room Price Master was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			roomPriceMasterService.update(this.mainRoomPriceMasterDTO);
			this.selectedRoomPriceMasterDTO = this.mainRoomPriceMasterDTO;
			this.mainRoomPriceMasterDTO = new RoomPriceMasterDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Room Price Master was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			roomPriceMasterService.delete(this.selectedRoomPriceMasterDTO);
			this.selectedRoomPriceMasterDTO = this.mainRoomPriceMasterDTO;
			this.mainRoomPriceMasterDTO = new RoomPriceMasterDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Room Price Master was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaRoomPriceMasterDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaRoomPriceMasterDTO = new RoomPriceMasterDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(RoomPriceMasterDTO roomPriceMaster){
		try{
			this.selectedRoomPriceMasterDTO = roomPriceMaster;
			if(this.selectedRoomPriceMasterDTO == null || this.selectedRoomPriceMasterDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				roomPriceMasterService.delete(this.selectedRoomPriceMasterDTO);
				this.selectedRoomPriceMasterDTO = this.mainRoomPriceMasterDTO;
				this.mainRoomPriceMasterDTO = new RoomPriceMasterDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Room Price Master was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(RoomPriceMasterDTO roomPriceMaster){
		this.selectedRoomPriceMasterDTO = roomPriceMaster;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedRoomPriceMasterDTO = (RoomPriceMasterDTO) event.getObject();
	}

	public IRoomPriceMasterService getRoomPriceMasterService() {
			return roomPriceMasterService;
	}

	public void setRoomPriceMasterService(IRoomPriceMasterService roomPriceMasterService) {
		this.roomPriceMasterService = roomPriceMasterService;

	}

	public LazyDataModelUtil<RoomPriceMasterDTO> getLazyData() {
		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<RoomPriceMasterDTO> lazyData) {
		this.lazyData = lazyData;

	}

	public RoomPriceMasterDTO getSelectedRoomPriceMasterDTO() {
		return selectedRoomPriceMasterDTO;

	}

	public void setSelectedRoomPriceMasterDTO(RoomPriceMasterDTO selectedRoomPriceMasterDTO) {
		this.selectedRoomPriceMasterDTO = selectedRoomPriceMasterDTO;

	}

	public RoomPriceMasterDTO getMainRoomPriceMasterDTO() {
		return mainRoomPriceMasterDTO;

	}

	public void setMainRoomPriceMasterDTO(RoomPriceMasterDTO mainRoomPriceMasterDTO) {
		this.mainRoomPriceMasterDTO = mainRoomPriceMasterDTO;

	}

	public RoomPriceMasterDTO getCriteriaRoomPriceMasterDTO() {
		return criteriaRoomPriceMasterDTO;

	}

	public void setCriteriaRoomPriceMasterDTO(RoomPriceMasterDTO criteriaRoomPriceMasterDTO) {
		this.criteriaRoomPriceMasterDTO = criteriaRoomPriceMasterDTO;

	}
	public IRoomTypeService getRoomTypeService() {
		return roomTypeService;
	}
	public void setRoomTypeService(IRoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}
	public List<RoomTypeDTO> getRoomTypeList(){
		return this.roomTypeList;
	}
	public void setRoomTypeList(List<RoomTypeDTO> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}
}
