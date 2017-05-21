package com.sky.biz.sseries.mbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.sky.biz.sseries.dto.MenuItemDto;

@ManagedBean(name = "treeBasicView")
@SessionScoped
public class TreeMenuView {
	private TreeNode root;

	@ManagedProperty(value="#{controlView}")
	private ControlView controlView;
	
	private TreeNode selectedNode;
	
	@PostConstruct
	public void init() {
		root = new DefaultTreeNode("Root", null);
		TreeNode node0 = this.getRootTreeNode(root,"System","");
		
		
		TreeNode node1 = this.getRootTreeNode(root, "E-HRM", "");
		TreeNode node2 = this.getRootTreeNode(root, "Inventory", "");
		TreeNode node3 = this.getRootTreeNode(root, "Prototype", "");
		TreeNode node4 = this.getRootTreeNode(root,"User Management","");
		TreeNode node5 = this.getRootTreeNode(root,"Business Partner","");
		TreeNode node6 = this.getRootTreeNode(root,"Apartment","");
		TreeNode node7 = this.getRootTreeNode(root,"S-Studio","");
		
		TreeNode node00 = new DefaultTreeNode(new MenuItemDto("General",""), node0);
		TreeNode node01 = new DefaultTreeNode(new MenuItemDto("Structure",""), node0);

		TreeNode node10 = new DefaultTreeNode(new MenuItemDto("OM",""), node1);
		TreeNode node11 = new DefaultTreeNode(new MenuItemDto("PIM",""), node1);				
		
		TreeNode node20 = this.getRootTreeNode(node2,"Product Information","");
		TreeNode node21 = this.getRootTreeNode(node2,"UOM","");
		
		TreeNode node30 = this.getRootTreeNode(node3, "Example", "prototype/master");
		
		TreeNode node40 = new DefaultTreeNode(new MenuItemDto("User Account","app/usm/user-account"),node4);
		TreeNode node41 = new DefaultTreeNode(new MenuItemDto("Role","app/usm/role"),node4);
		TreeNode node42 = new DefaultTreeNode(new MenuItemDto("Privilege","app/usm/privilege"),node4);
		
//		TreeNode node50 = new DefaultTreeNode(new MenuItemDto("Business Partner Group","app/bpn/business-partner-group"),node5);
		TreeNode node50 = new DefaultTreeNode(new MenuItemDto("Partner Group","app/bpn/partner-group"),node5);
		TreeNode node51 = new DefaultTreeNode(new MenuItemDto("Partner Category","app/bpn/partner-category"),node5);
		TreeNode node52 = new DefaultTreeNode(new MenuItemDto("Corporate Type","app/bpn/corporate-type"),node5);
		TreeNode node53 = new DefaultTreeNode(new MenuItemDto("Address Type","app/bpn/address-type"),node5);
		TreeNode node54 = new DefaultTreeNode(new MenuItemDto("Title Name","app/bpn/title-name"),node5);
		

		TreeNode node60 = new DefaultTreeNode(new MenuItemDto("Master Data",""),node6);
		TreeNode node61 = new DefaultTreeNode(new MenuItemDto("Process",""),node6);
		TreeNode node62 = new DefaultTreeNode(new MenuItemDto("Report",""),node6);
		TreeNode node63 = new DefaultTreeNode(new MenuItemDto("Util",""),node6);
		
		TreeNode node70 = new DefaultTreeNode(new MenuItemDto("Master Data",""),node7);
		TreeNode node71 = new DefaultTreeNode(new MenuItemDto("Process",""),node7);
		TreeNode node72 = new DefaultTreeNode(new MenuItemDto("Report",""),node7);
		TreeNode node73 = new DefaultTreeNode(new MenuItemDto("Util",""),node7);
		
		TreeNode node601 = new DefaultTreeNode(new MenuItemDto("Building","app/apm/master/building"),node60);
		TreeNode node602 = new DefaultTreeNode(new MenuItemDto("Floor","app/apm/master/floor"),node60);
		TreeNode node603 = new DefaultTreeNode(new MenuItemDto("Room Type","app/apm/master/room-type"),node60);
		TreeNode node604 = new DefaultTreeNode(new MenuItemDto("Room","app/apm/master/room"),node60);
		TreeNode node605 = new DefaultTreeNode(new MenuItemDto("Room Price","app/apm/master/room-price-master"),node60);
		TreeNode node606 = new DefaultTreeNode(new MenuItemDto("Room Status","app/apm/master/room-status"),node60);
		TreeNode node607 = new DefaultTreeNode(new MenuItemDto("Meter Type","app/apm/master/meter-type"),node60);
		TreeNode node608 = new DefaultTreeNode(new MenuItemDto("Manage Building","app/apm/util/manage-building"),node63);
		
		TreeNode node701 = new DefaultTreeNode(new MenuItemDto("Product Master","app/ssd/master/product"),node70);
		TreeNode node702 = new DefaultTreeNode(new MenuItemDto("Module Master","app/ssd/master/module"),node70);
		
		node1.getChildren().add(new DefaultTreeNode(new MenuItemDto("Node 1.1","")));
		node00.getChildren().add(new DefaultTreeNode(new MenuItemDto("Node 0.0.0","app/org/general")));
		node00.getChildren().add(new DefaultTreeNode(new MenuItemDto("Node 0.0.1","app/org/structure")));
		node01.getChildren().add(new DefaultTreeNode(new MenuItemDto("Node 0.1.0","")));
		node10.getChildren().add(new DefaultTreeNode(new MenuItemDto("Node 1.0.0","")));
		
		this.getRootTreeNode(node20,"Product","app/product-info/product");
		this.getRootTreeNode(node20,"New","app/product-info/product-create");
	}


	private TreeNode getRootTreeNode(TreeNode parent,String menuName,String outcome){
		return new DefaultTreeNode(new MenuItemDto(menuName,outcome),parent);
	}
	
	public TreeNode getRoot() {
		return root;
	}


	public ControlView getControlView() {
		return controlView;
	}


	public void setControlView(ControlView controlView) {
		this.controlView = controlView;
	}


	public TreeNode getSelectedNode() {
		return selectedNode;
	}


	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
		if(this.selectedNode != null){
			MenuItemDto menu = (MenuItemDto)this.selectedNode.getData();
			System.out.println(menu.getName());
		}
	}
}
