package com.sky.biz.sseries.prototype.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.sky.biz.sseries.mbean.AbstractController;
import com.sky.biz.sseries.mbean.ControlView;

@ManagedBean(name = "masterView")
@SessionScoped
public class MasterView extends AbstractController{

	public void newAction(ActionEvent actionEvent){
		currentSubView = "prototype/scr/create";
	}

	
}
