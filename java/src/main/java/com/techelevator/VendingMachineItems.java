package com.techelevator;
public class VendingMachineItems {
	
	private String slot;
	private String name;
	private double price;
	private String type;
	private int count;
	private String sound;
	
	
	public VendingMachineItems(String slot, String name, double price, int count) {
		this.slot = slot;
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getSlot() {
		return slot;
	}
	
	public String getType() {
		return type;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getSound() {
		return sound;
	}
	
	public int decreaseCount() {
		return this.count -= 1;
	}
	
}