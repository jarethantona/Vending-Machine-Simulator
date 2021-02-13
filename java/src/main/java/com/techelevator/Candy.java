package com.techelevator;

public class Candy extends VendingMachineItems {
	
	private String type =  "Candy";
	private String sound = "\"Munch Munch, Yum!\"";

	public Candy(String slot, String name, double price, int count) {
		super(slot, name, price, count);
	}
	
	@Override
	public String getType() {
		return this.type;
	
	}
	
	@Override
	public String getSound() {
		return this.sound;
	}

	
	
	

	
}
