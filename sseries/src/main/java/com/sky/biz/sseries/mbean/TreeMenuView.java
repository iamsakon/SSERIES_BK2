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
		
		TreeNode node50 = new DefaultTreeNode(new MenuItemDto("Business Partner Group","app/bpn/business-partner-group"),node5);
		TreeNode node51 = new DefaultTreeNode(new MenuItemDto("Business Partner","app/bpn/business-partner"),node5);
		

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
