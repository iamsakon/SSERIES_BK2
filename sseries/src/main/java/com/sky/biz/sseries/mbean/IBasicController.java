package com.sky.biz.sseries.mbean;

import javax.faces.event.ActionEvent;

public interface IBasicController {
	/**
	 * 
	 * @param actionEvent
	 */
	public void newAction(ActionEvent actionEvent);
	/**
	 * 
	 * @param actionEvent
	 */
	public void saveAction(ActionEvent actionEvent);
	/**
	 * 
	 * @param actionEvent
	 */
	public void findAction(ActionEvent actionEvent);
	
	/**
	 * 
	 * @param actionEvent
	 */
	public void viewAction(ActionEvent actionEvent);
	/**
	 * 
	 * @param actionEvent
	 */
	public void updateAction(ActionEvent actionEvent);
	/**
	 * 
	 * @param actionEvent
	 */
	public void deleteAction(ActionEvent actionEvent);
	
	public void getDynamicColumns();
	/**
	 * 
	 * @return
	 */
	public boolean getDisabledNewEvent();
	/**
	 * 
	 * @return
	 */
	public boolean getDisabledSaveEvent();
	/**
	 * 
	 * @return
	 */
	public boolean getDisabledEditEvent();
	/**
	 * 
	 * @return
	 */
	public boolean getDisabledFindEvent();
	
}
