package com.sky.biz.sseries.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import com.sky.biz.sseries.util.JsfUtil;

public class AbstractController {

	@ManagedProperty(value="#{controlView}")
	protected ControlView controlView;
	
	protected String createView="app/empty";
	protected String editView="app/empty";
	protected String listView="app/empty";
	protected String readView="app/empty";
	
	protected String currentSubView = "app/empty";

	public ControlView getControlView() {
		return controlView;
	}

	public void setControlView(ControlView controlView) {
		this.controlView = controlView;
	}
	

	public String getCurrentSubView() {
		return currentSubView;
	}

	public void setCurrentSubView(String currentSubView) {
		this.currentSubView = currentSubView;
	}

	public boolean getDisabledNewEvent() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getDisabledSaveEvent() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getDisabledEditEvent() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean getDisabledFindEvent(){
		// TODO Auto-generated method stub
		return false;
	}
	
	static public class ColumnModel implements Serializable {
		 
        private String header;
        private String property;
 
        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }
 
        public String getHeader() {
            return header;
        }
 
        public String getProperty() {
            return property;
        }
    }
	
	public void newAction(ActionEvent actionEvent) {
		this.setCurrentSubView(this.createView);
	}

	public void saveAction(ActionEvent actionEvent) {
		JsfUtil.addErrorMessage("Not implement saveAction yet");
	}


	public void searchAction(ActionEvent actionEvent){
		JsfUtil.addErrorMessage("Not implement searchAction yet");
	}
	
	public void resetAction(ActionEvent actionEvent){
		JsfUtil.addErrorMessage("Not implement resetAction yet");
	}
	
	public void findAction(ActionEvent actionEvent) {
		this.setCurrentSubView(this.listView);
	}

	
	public void viewAction(ActionEvent actionEvent) {
		this.setCurrentSubView(this.readView);
	}

	
	public void editAction(ActionEvent actionEvent){
		this.setCurrentSubView(this.editView);
	}

	public void updateAction(ActionEvent actionEvent) {
		JsfUtil.addErrorMessage("Not implement updateAction yet");
	}


	public void deleteAction(ActionEvent actionEvent) {
		JsfUtil.addErrorMessage("Not implement deleteAction yet");
	}


	public void getDynamicColumns() {
		// TODO Auto-generated method stub
		
	}

	public String getCreateView() {
		return createView;
	}

	public void setCreateView(String createView) {
		this.createView = createView;
	}

	public String getEditView() {
		return editView;
	}

	public void setEditView(String editView) {
		this.editView = editView;
	}

	public String getListView() {
		return listView;
	}

	public void setListView(String listView) {
		this.listView = listView;
	}

	public String getReadView() {
		return readView;
	}

	public void setReadView(String readView) {
		this.readView = readView;
	}
	
}
