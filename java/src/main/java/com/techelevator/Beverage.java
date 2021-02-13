package com.techelevator;

public class Beverage extends VendingMachineItems {
	
	private String type =  "Drink";
	private String sound= "\"Glug Glug, Yum!\"";

	public Beverage(String slot, String name, double price, int count) {
		super(slot, name, price, count);
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getSound() {
		return sound;
	}
	

}




