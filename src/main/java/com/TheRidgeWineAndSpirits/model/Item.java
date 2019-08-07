package com.TheRidgeWineAndSpirits.model;

public class Item {

	private int itemNumber;
	private String itemName;
	private String createTime;
	private String description;
	private String type;
	
	
	public int getItemNumber() {
		return itemNumber;
	}
	public String getItemName() {
		return itemName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getDescription() {
		return description;
	}
	public String getType() {
		return type;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setType(String type) {
		this.type = type;
	}
}
