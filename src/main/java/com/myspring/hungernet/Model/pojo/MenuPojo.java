package com.myspring.hungernet.Model.pojo;

import java.util.List;

public class MenuPojo {
	
	private String type;
	private List<ItemPojo> menuItems;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<ItemPojo> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<ItemPojo> menuItems) {
		this.menuItems = menuItems;
	}
	
	

}
