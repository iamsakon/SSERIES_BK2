package com.sky.biz.sseries.apm.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sky.biz.sseries.mbean.IBasicController;
@ManagedBean(name = "floorController")
@SessionScoped
public class FloorController extends AbstractFloorController implements IBasicController {

}
