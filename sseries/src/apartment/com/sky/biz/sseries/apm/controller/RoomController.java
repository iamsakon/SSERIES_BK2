package com.sky.biz.sseries.apm.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sky.biz.sseries.mbean.IBasicController;
@ManagedBean(name = "roomController")
@SessionScoped
public class RoomController extends AbstractRoomController implements IBasicController {

}
