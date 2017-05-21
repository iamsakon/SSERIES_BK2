package com.sky.biz.sseries.mbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@SessionScoped
public class MenuView {

	private MenuModel model;
	
	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();
        
        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("ข้อมูลหลัก");           
        this.createDefaultMenuItem(firstSubmenu,"External","http://www.primefaces.org","ui-icon-home");         
        model.addElement(firstSubmenu);
	}
	
	private DefaultMenuItem createDefaultMenuItem(DefaultSubMenu parent,String  name,String outcome,String icon){
		DefaultMenuItem item = new DefaultMenuItem(name);
		//item.setUrl(url);
		item.setOutcome(outcome);
        item.setIcon(icon);
        parent.addElement(item);
		return item;
	}
}
