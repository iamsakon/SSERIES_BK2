package com.sky.biz.sseries.apm.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sky.biz.sseries.mbean.IBasicController;
@ManagedBean(name = "roomStatusController")
@SessionScoped
public class RoomStatusController extends AbstractRoomStatusController implements IBasicController {

}
