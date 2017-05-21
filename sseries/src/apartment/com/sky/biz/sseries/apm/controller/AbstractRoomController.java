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
public class AbstractRoomController extends AbstractController implements IBasicController {
	private LazyDataModelUtil<RoomDTO> lazyData;
	@ManagedProperty(value="#{roomService}")
	private IRoomService roomService;
	private RoomDTO selectedRoomDTO;
	private RoomDTO mainRoomDTO;
	private RoomDTO criteriaRoomDTO;
	private List<RoomTypeDTO> roomTypeList;	
	private List<FloorDTO> floorList;
	@ManagedProperty(value="#{roomTypeService}")
	private IRoomTypeService roomTypeService;
	@ManagedProperty(value="#{floorService}")
	private IFloorService floorService;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		this.createView="app/apm/master/room-create";
		this.editView="app/apm/master/room-edit";
		this.listView="app/apm/master/room-list";
		this.readView="app/apm/master/room-view";
		this.selectedRoomDTO = new RoomDTO();
		this.criteriaRoomDTO = new RoomDTO();
		this.mainRoomDTO = new RoomDTO();
		this.currentSubView = this.listView;
		lazyData = new LazyDataModelUtil<RoomDTO>(roomService);
		this.roomTypeList = this.roomTypeService.loadActiveRoomType();
		this.floorList = this.floorService.loadActiveFloor();
	}

	public void editAction(ActionEvent actionEvent){
		try{
			if(this.selectedRoomDTO == null || this.selectedRoomDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				this.mainRoomDTO = this.selectedRoomDTO;
				this.setCurrentSubView(this.editView);
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void viewAction(ActionEvent actionEvent){
		try{
			if(this.selectedRoomDTO == null || this.selectedRoomDTO.getId() == null){
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
			this.mainRoomDTO = new RoomDTO();
			this.setCurrentSubView(this.createView);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void saveAction(ActionEvent actionEvent) {
		try{
			roomService.saveNew(this.mainRoomDTO);
			this.selectedRoomDTO = this.mainRoomDTO;
			this.mainRoomDTO = new RoomDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Room was created already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void updateAction(ActionEvent actionEvent) {
		try{
			roomService.update(this.mainRoomDTO);
			this.selectedRoomDTO = this.mainRoomDTO;
			this.mainRoomDTO = new RoomDTO();
			this.setCurrentSubView(this.readView);
			JsfUtil.addSuccessMessage(" Room was updated already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void deleteAction(ActionEvent actionEvent) {
		try{
			roomService.delete(this.selectedRoomDTO);
			this.selectedRoomDTO = this.mainRoomDTO;
			this.mainRoomDTO = new RoomDTO();
			this.setCurrentSubView(this.listView);
			JsfUtil.addSuccessMessage(" Room was deleted already!!");
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void searchAction(ActionEvent actionEvent){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(SpecificationsUtil.DEFAULT_CRITERIA_KEY_MAP,this.criteriaRoomDTO);
			this.lazyData.setCriteriaMap(map);
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}
	}

	public void resetAction(ActionEvent actionEvent){
		this.criteriaRoomDTO = new RoomDTO();
		this.lazyData.setCriteriaMap(null);

	}

	public void setDeleteAction(RoomDTO room){
		try{
			this.selectedRoomDTO = room;
			if(this.selectedRoomDTO == null || this.selectedRoomDTO.getId() == null){
				JsfUtil.addWarningMessage("Please select at least one item");
			}else{
				roomService.delete(this.selectedRoomDTO);
				this.selectedRoomDTO = this.mainRoomDTO;
				this.mainRoomDTO = new RoomDTO();
				this.setCurrentSubView(this.listView);
				JsfUtil.addSuccessMessage(" Room was deleted already!!");
			}
		}catch(Exception ex){
			JsfUtil.addErrorMessage(ex, "SSeries Error Please Contact admin");
			ex.printStackTrace();
		}

	}

	public void setViewAction(RoomDTO room){
		this.selectedRoomDTO = room;
		this.setCurrentSubView(this.readView);

	}

	public void onRowSelect(SelectEvent event) {
		this.selectedRoomDTO = (RoomDTO) event.getObject();
	}

	public IRoomService getRoomService() {
			return roomService;
	}

	public void setRoomService(IRoomService roomService) {

		this.roomService = roomService;

	}

	public LazyDataModelUtil<RoomDTO> getLazyData() {

		return lazyData;

	}

	public void setLazyData(LazyDataModelUtil<RoomDTO> lazyData) {

		this.lazyData = lazyData;

	}

	public RoomDTO getSelectedRoomDTO() {

		return selectedRoomDTO;

	}

	public void setSelectedRoomDTO(RoomDTO selectedRoomDTO) {

		this.selectedRoomDTO = selectedRoomDTO;

	}

	public RoomDTO getMainRoomDTO() {

		return mainRoomDTO;

	}

	public void setMainRoomDTO(RoomDTO mainRoomDTO) {

		this.mainRoomDTO = mainRoomDTO;

	}

	public RoomDTO getCriteriaRoomDTO() {

		return criteriaRoomDTO;

	}

	public void setCriteriaRoomDTO(RoomDTO criteriaRoomDTO) {

		this.criteriaRoomDTO = criteriaRoomDTO;

	}
	public IRoomTypeService getRoomTypeService() {
		return roomTypeService;
	}
	public void setRoomTypeService(IRoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}
	
	public IFloorService getFloorService() {
		return floorService;
	}
	public void setFloorService(IFloorService floorService) {
		this.floorService = floorService;
	}
	public List<RoomTypeDTO> getRoomTypeList(){
		return this.roomTypeList;
	}
	public void setRoomTypeList(List<RoomTypeDTO> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}
	
	public List<FloorDTO> getFloorList(){
		return this.floorList;
	}
	public void setFloorList(List<FloorDTO> floorList) {
		this.floorList = floorList;
	}
}